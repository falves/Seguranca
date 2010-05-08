package negocios;

import java.sql.Time;
import java.util.*;
import java.text.*;

import dados.*;

public class GerenteNegocios {

	/**
	 * Cadastra um novo usu�rio
	 * @param login
	 * @param senha
	 * @param gid
	 * @return true se cadastrou ou false se n�o
	 */
	public static boolean cadastraUsuario ( String login, String senha, int gid )
	{
		if ( GerenteDados.getGid(login) != -1 )
		{
			//TODO: Alterar se preciso
			System.out.println("Usu�rio j� existe!");
			return false;
		}
		
		if ( GerenteDados.getPapel(gid) == null )
		{
			//TODO: Alterar se preciso
			System.out.println("Grupo de usu�rio n�o existe!");
			return false;
		}
		
		GerenteDados.CadastraUsuario(login, gid, senha);
		
		return true;
	}

	/**
	 * Verifica se um usu�rio est� bloqueado
	 * @param login
	 * @return true se est� e false se n�o
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
	 * @return true se existe e false se n�o
	 */
	public static boolean verificaUsuario ( String login )
	{
		if ( GerenteDados.getGid(login) == -1 )
		{
			System.out.println("Usu�rio n�o encontrado!");
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
