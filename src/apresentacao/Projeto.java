package apresentacao;

import dados.*;
import negocios.*;

public class Projeto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Conexao.criaConexao();
		
		//System.out.println(GerenteDados.getHoraBloqueio("felipe"));
		//System.out.println(GerenteNegocios.getHoraAtual("hh:mm:ss"));
		//GerenteDados.setBloqueado("felipe");
		GerenteNegocios.getHoraAtual("hh:mm:ss");
		
		Conexao.fechaConexao();
	}
	

}
