package br.edu.fatecpg.LoginJava.view;

public class Depuracao {
	private boolean depuracaoAtivada = true; // Troque para 'false' se não deseja exibir mensagens de depuração no console
	
	public void mensagemDepuracao(String m) {
		if(this.depuracaoAtivada) {
			System.out.println(m);
		}
	}
}
