package br.edu.fatecpg.LoginJava.view;

import java.awt.EventQueue;

import javax.swing.UIManager;

import br.edu.fatecpg.LoginJava.model.Model;
import br.edu.fatecpg.LoginJava.controller.Controller;
import br.edu.fatecpg.LoginJava.view.Depuracao;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// As mensagens de depuração podem ser suprimidas na classe Depuracao.java
					Depuracao depuracao = new Depuracao();
                    depuracao.mensagemDepuracao("[Main] Inicializando...");
                    
                    // Herda a aparência do sistema
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    
                    // Injeção de dependências
                    Model model = new Model(depuracao);
                    Login login = new Login(depuracao);
                    Painel painel = new Painel(depuracao);
                    
                    Controller controller = new Controller(depuracao, model, login, painel);
                    
                    login.setController(controller);
                    painel.setController(controller);
					
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
