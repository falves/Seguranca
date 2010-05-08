package negocios;

import java.sql.Time;
import java.util.*;
import java.text.*;

import dados.*;

public class GerenteNegocios {

	/**
	 * Cadastra um novo usuário
	 * @param login
	 * @param senha
	 * @param gid
	 * @return true se cadastrou ou false se não
	 */
	public static boolean cadastraUsuario ( String login, String senha, int gid )
	{
		if ( GerenteDados.getGid(login) != -1 )
		{
			//TODO: Alterar se preciso
			System.out.println("Usuário já existe!");
			return false;
		}
		
		if ( GerenteDados.getPapel(gid) == null )
		{
			//TODO: Alterar se preciso
			System.out.println("Grupo de usuário não existe!");
			return false;
		}
		
		GerenteDados.CadastraUsuario(login, gid, senha);
		
		return true;
	}

	/**
	 * Verifica se um usuário está bloqueado
	 * @param login
	 * @return true se está e false se não
	 */
	public static boolean verificaBloqueado ( String login )
	{
		if ( !verificaUsuario(login) )
			return false;
		
		if( GerenteDados.getBloqueado(login) )
		{
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MINUTE, -2);
			
			if ( cal.getTime().before(GerenteDados.getHoraBloqueio("felipe")))
			{
				// faz algo
			}
		}
		return false;
	}
	
	/**
	 * Vereifica se um login existe
	 * @param login
	 * @return true se existe e false se não
	 */
	public static boolean verificaUsuario ( String login )
	{
		if ( GerenteDados.getGid(login) == -1 )
		{
			System.out.println("Usuário não encontrado!");
			return false;
		}
		return true;
	}
	
	  public static String getHoraAtual(String dateFormat) {
		  
		  Time hora_bd, hora_atual;
		  
		  Calendar cal = Calendar.getInstance();
		  
		  SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		  cal.add(Calendar.MINUTE, 5);
		  System.out.println(cal.getTime());
		  System.out.println(GerenteDados.getHoraBloqueio("felipe"));
		 
		  System.out.println(cal.getTime().before(GerenteDados.getHoraBloqueio("felipe")));
		  
		  return sdf.format(cal.getTime());
	  }

}
