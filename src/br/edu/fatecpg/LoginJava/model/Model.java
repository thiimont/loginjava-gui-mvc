package br.edu.fatecpg.LoginJava.model;

import br.edu.fatecpg.LoginJava.view.Depuracao;

import java.util.Arrays;

public class Model {
	private String usuarioPadrao = "admin";
	private final Depuracao depuracao;
	
	public Model(Depuracao depuracao) {
		this.depuracao = depuracao;
	}
	
	private boolean senhaCorreta(char[] senha) {
		// Senha é armazenada em caracteres e depois zerada para maior segurança
		char[] senhaPadrao = {'f', 'a', 't', 'e', 'c', '2', '0', '2', '5'};
		boolean correta = true;
		
		if (senha.length != senhaPadrao.length) {
	        correta = false;
	    } else {
	        for (int caractere = 0; caractere < senhaPadrao.length; caractere++) {
	            if (senha[caractere] != senhaPadrao[caractere]) {
	                correta = false;
					break;
	            }
	        }
	    }
		
		Arrays.fill(senhaPadrao, '0');
		return correta;
	}
	
	public boolean verificarLogin(String usuario, char[] senha) {
		depuracao.mensagemDepuracao("[Model] Verificando dados do usuário '" + usuario + "'");
		return usuario.equals(this.usuarioPadrao) && senhaCorreta(senha);
	}
}
