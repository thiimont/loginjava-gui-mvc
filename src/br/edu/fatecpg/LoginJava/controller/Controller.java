package br.edu.fatecpg.LoginJava.controller;

import br.edu.fatecpg.LoginJava.model.Model;
import br.edu.fatecpg.LoginJava.view.Login;
import br.edu.fatecpg.LoginJava.view.Painel;
import br.edu.fatecpg.LoginJava.view.Depuracao;

public class Controller {
	private final Login login;
	private final Painel painel;
	private final Model model;
	private final Depuracao depuracao;
	
	public Controller(Depuracao depuracao, Model model, Login login, Painel painel) {
		this.depuracao = depuracao;
		this.model = model;
		this.login = login;
		this.painel = painel;
	}
	
	public void realizarLogin(String usuario, char[] senha) {
		depuracao.mensagemDepuracao("[Controller] Chamando a model para verificar os dados digitados");
		if(model.verificarLogin(usuario, senha)) {
			depuracao.mensagemDepuracao("[Controller] Login válido, exibindo painel do usuário");
			painel.setUsuarioLogado(usuario);
			login.setVisible(false);
			painel.setVisible(true);
		} else {
			depuracao.mensagemDepuracao("[Controller] Login incorreto, exibindo mensagem");
			login.setMensagem("Usuário e/ou senha incorretos!");
		}
	}
	
	public void logout() {
		depuracao.mensagemDepuracao("[Controller] Fazendo logout...");
		login.limparLogin();
		login.setMensagem(null);
		
		painel.setVisible(false);
		login.setVisible(true);
	}

}
