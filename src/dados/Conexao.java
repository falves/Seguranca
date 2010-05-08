package dados;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	protected static Connection conexao;
	private static String path = "seguranca.mdb";
	private static String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	private static String url = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ=";
	private static boolean aberta = false;
	
	
	/**********
	 * Cria a conexão
	 */
	public static void criaConexao()
	{
		// Não abre outra conexão se já existe uma
		if ( !aberta )
		{
			try {			
				Class.forName(driver);
				conexao=DriverManager.getConnection(url + path);
				
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		aberta = true;
		
	}

	/**********
	 * Fecha a conexão
	 */
	public static void fechaConexao()
	{
		try
		{
			conexao.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}
	
	public static Connection getConexao()
	{
		return conexao;
	}
}
