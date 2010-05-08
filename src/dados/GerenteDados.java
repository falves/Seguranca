package dados;

import java.sql.*;

public class GerenteDados {

	
	/*************************************************
	 * 												 *
	 * 				Tabela de Usuarios				 *
	 * 												 *
	 *************************************************/
	
	/**********
	 * Retorna o login de um usuário a partir de seu UID
	 * @param uid
	 * @return o Login do UID ou null
	 */
	public static String getLogin (int uid)
	{
		String sql = "SELECT login FROM usuarios WHERE uid="+uid;
		String login_bd = null; 		
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if( rs != null )
			{
				if ( rs.next() )
				{
					login_bd = rs.getString("login");					
				}
			}	
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return login_bd;
	}

	/**********
	 * Retorna o UID de um usuário a partir de seu login
	 * @param login
	 * @return O UID ou -1
	 */
	public static int getUid (String login)
	{
		String sql = "SELECT uid FROM usuarios WHERE login=\'"+login+"\'";
		int retorno = -1;
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if( rs != null )
			{
				if ( rs.next() )
				{
					retorno = rs.getInt("uid");					
				}
				else
					retorno = -1;
			}	
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return retorno;
	}

	/**********
	 * Retorna a senha pessoal de um usuário a partir de seu login
	 * @param login
	 * @return A senha ou null
	 */
	public static String getSenhaPessoal ( String login )
	{
		String sql = "SELECT senha_pessoal FROM usuarios WHERE login=\'"+login+"\'";
		String senha_bd = null; 		
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if( rs != null )
			{
				if ( rs.next() )
				{
					senha_bd = rs.getString("senha_pessoal");					
				}
			}	
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return senha_bd;
	}

	/**********
	 * Retorna o GID de um usuário a partir de seu login
	 * @param login
	 * @return o GID ou -1
	 */
	public static int getGid ( String login )
	{
		String sql = "SELECT gid FROM usuarios WHERE login=\'"+login+"\'";
		int gid_bd = -1; 		
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if( rs != null )
			{
				if ( rs.next() )
				{
					gid_bd = rs.getInt("gid");					
				}
			}	
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return gid_bd;
	}

	/**********
	 * Retorna se um usuário está bloqueado a partir do seu login
	 * @param login
	 * @return treu ou false
	 */
	public static boolean getBloqueado ( String login )
	{
		String sql = "SELECT bloqueado FROM usuarios WHERE login=\'"+login+"\'";
		boolean bloqueado = true; 		
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if( rs != null )
			{
				if ( rs.next() )
				{
					bloqueado = rs.getBoolean("bloqueado");					
				}
			}	
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return bloqueado;
	}
	
	/**********
	 * Retorna a hora do bloquei de um usuário a partir de seu login
	 * @param login
	 * @return hora que o usuario foi bloqueado ou null
	 */
	public static Timestamp getHoraBloqueio ( String login )
	{
		String sql = "SELECT hora_bloqueio FROM usuarios WHERE login=\'"+login+"\'";
		Timestamp hora_bd = null;
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if( rs != null )
			{
				if ( rs.next() )
				{ 
					hora_bd = rs.getTimestamp("hora_bloqueio");
				}
			}	
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return hora_bd;
	}

	/**********
	 * Retorna o numero de erros de um usuário a partir de seu login
	 * @param login
	 * @return
	 */
	public static int getNumErros ( String login )
	{
		String sql = "SELECT num_erros FROM usuarios WHERE login=\'"+login+"\'";
		int numero = -1; 		
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if( rs != null )
			{
				if ( rs.next() )
				{
					numero = rs.getInt("num_erros");					
				}
			}	
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return numero;
	}

	
	
	
	/*************************************************
	 * 												 *
	 * 			     Tabela de GID    				 *
	 * 												 *
	 *************************************************/
	
	/**********
	 * Retorna o nome de um papel a partir de seu GID
	 * @param gid
	 * @return Nome do papel ou null
	 */
	public static String getPapel ( int gid )
	{
		String sql = "SELECT papel FROM gid WHERE gid="+gid;
		String papel = null; 		
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if( rs != null )
			{
				if ( rs.next() )
				{
					papel = rs.getString("papel");					
				}
			}	
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return papel;
	}

	
	
	
	/*************************************************
	 * 												 *
	 * 			     Tabela de Senhas				 *
	 * 												 *
	 *************************************************/
	
	/**********
	 * Retorna a senha de numero "num" do usuario com uid especificado
	 * @param uid, num
	 * @return senha ou null
	 */
	public static String getSenha ( int uid, int num )
	{
		String sql = "SELECT senha FROM senhas_de_unica_vez WHERE num_senha="+num+" AND uid="+uid;
		String senha = null; 		
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if( rs != null )
			{
				if ( rs.next() )
				{
					senha = rs.getString("senha");					
				}
			}	
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return senha;
	}

	/**********
	 * Retorna se uma senha já foi usada, a partir de um UID e um Numero
	 * @param uid
	 * @param num
	 * @return true ou false
	 */
	public static boolean getSenhaUsada ( int uid, int num)
	{
		String sql = "SELECT usada FROM senhas_de_unica_vez WHERE num_senha="+num+" AND uid="+uid;
		boolean usada = true; 		
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if( rs != null )
			{
				if ( rs.next() )
				{
					usada = rs.getBoolean("usada");					
				}
			}	
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return usada;
	}





	/*************************************************
	 * 												 *
	 * 					Getters						 *
	 * 												 *
	 *************************************************/



	/**********
	 * Altera o login de um usuário a partir de seu UID
	 * @param uid, login
	 */
	public static void setLogin (int uid, String login)
	{
		String sql = "UPDATE usuarios SET login=\'"+login+"\' WHERE uid="+uid;
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**********
	 * Altera a senha pessoal de um usuário a partir de seu login
	 * @param login, senha
	 */
	public static void setSenhaPessoal ( String login, String senha )
	{
		String sql = "UPDATE usuarios SET senha_pessoal=\'"+senha+"\' WHERE login=\'"+login+"\'";
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**********
	 * Altera o GID de um usuário a partir de seu login
	 * @param login, gid
	 */
	public static void setGid ( String login, int gid )
	{
		String sql = "UPDATE usuarios SET gid="+gid+" WHERE login=\'"+login+"\'";
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**********
	 * Bloqueia ou desbloqueia um usuário
	 * @param login, true ou false
	 */
	public static void setBloqueado ( String login )
	{
		String sql = "UPDATE usuarios SET bloqueado=true,hora_bloqueio=Now() WHERE login=\'"+login+"\'";
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**********
	 * Altera o numero de erros de um usuário a partir de seu login
	 * @param login, numero de erros
	 */
	public static void setNumErros ( String login, int numero )
	{
		String sql = "UPDATE usuarios SET num_erros="+numero+" WHERE login=\'"+login+"\'";
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**********
	 * Altera o nome de um papel a partir de seu GID
	 * @param gid, nome do papel
	 */
	public static void setPapel ( int gid, String papel )
	{
		String sql = "UPDATE gid SET papel=\'"+papel+"\' WHERE gid="+gid;
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**********
	 * Marca que uma senha já foi usada, a partir de um UID e um Numero
	 * @param uid
	 * @param num
	 * @return true ou false
	 */
	public static void setSenhaUsada ( int uid, int num)
	{
		String sql = "UPDATE senhas_de_unica_vez SET usada=true WHERE uid="+uid+" AND num_senha="+num;
		
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	
	
	
	/*************************************************
	 * 												 *
	 * 				   Cadastros					 *
	 * 												 *
	 *************************************************/
	
	
	
	/**********
	 * Cadastra um novo grupo de usuário, que deve ter um nome único
	 * @param nomePapel
	 */
	public static void cadastraGid ( String nomePapel )
	{
		String sql = "INSERT INTO gid(papel) VALUES (\'"+ nomePapel + "\')";
		
		try
		{			
			Statement stmt = Conexao.getConexao().createStatement();
			stmt.executeUpdate(sql);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**********
	 * Cadastra um novo usuário, que deve ter um login único e um gid válido
	 * @param login
	 * @param gid
	 * @param senha_pessoal
	 */
	public static void CadastraUsuario(String login, int gid, String senha_pessoal) {
		String sql = "INSERT INTO usuarios(login,senha_pessoal,gid,bloqueado) VALUES (\'"
				+ login + "\',\'" + senha_pessoal + "\'," + gid + ",false)";

		try 
		{
			Statement stmt = Conexao.getConexao().createStatement();
			stmt.executeUpdate(sql);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}





