package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoggerDados {

	/**********
	 * Retorna a mensagem associada a um codigo
	 * @param codigo
	 * @return a mensagem ou null
	 */
	public String getMensagem (int codigo)
	{
		String sql = "SELECT mensagem FROM mensagens WHERE codigo="+codigo;
		String mensagem = null;
		try
		{
			Statement stmt = Conexao.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if( rs != null )
			{
				if ( rs.next() )
				{
					mensagem = rs.getString("mensagem");					
				}
			}	
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return mensagem;
	}

	/**********
	 * Grava na tabela de registros o codigo e a hora da acao de um usuário
	 * @param login
	 * @param cod
	 */
	public void setRegistro ( String login, int cod )
	{
		String sql = "INSERT INTO registros (codigo,hora,usuario) VALUES ("+cod+",Now(),\'"+login+"\')";

		Statement stmt;
		try {
			stmt = Conexao.getConexao().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
