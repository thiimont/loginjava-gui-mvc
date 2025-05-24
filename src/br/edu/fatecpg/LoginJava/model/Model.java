package br.edu.fatecpg.LoginJava.model;

import br.edu.fatecpg.LoginJava.view.Depuracao;

public class Model {
	private String usuarioPadrao = "admin";
	private Depuracao depuracao;
	
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
	        for (int i = 0; i < senha.length; i++) {
	            if (senha[i] != senhaPadrao[i]) {
	                correta = false;
	            }
	        }
	    }
		
		for (int i = 0; i < senhaPadrao.length; i++) {
	        senhaPadrao[i] = 0;
	    }
		
		return correta;

	}
	
	public boolean verificarLogin(String usuario, char[] senha) {
		depuracao.mensagemDepuracao("[Model] Verificando dados do usuário '" + usuario + "'");
		return usuario.equals(this.usuarioPadrao) && senhaCorreta(senha);
	}
}
