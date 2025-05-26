package br.edu.fatecpg.LoginJava.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import br.edu.fatecpg.LoginJava.controller.Controller;
import br.edu.fatecpg.LoginJava.view.Depuracao;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_usuario;
	private JPasswordField pwd_senha;
	private JLabel lbl_mensagem;
	private Controller controller;
	private final Depuracao depuracao;

	public Login(Depuracao depuracao) {
		this.depuracao = depuracao;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Login");
		
		txt_usuario = new JTextField();
		txt_usuario.setBounds(100, 98, 114, 21);
		contentPane.add(txt_usuario);
		txt_usuario.setColumns(10);
		
		pwd_senha = new JPasswordField();
		pwd_senha.setBounds(226, 98, 114, 21);
		contentPane.add(pwd_senha);
		
		JLabel lbl_usuario = new JLabel("Usuário:");
		lbl_usuario.setBounds(100, 79, 60, 17);
		contentPane.add(lbl_usuario);
		
		JLabel lbl_senha = new JLabel("Senha:");
		lbl_senha.setBounds(226, 79, 60, 17);
		contentPane.add(lbl_senha);
		
		JButton btn_login = new JButton("Login");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txt_usuario.getText();
				char[] senha = pwd_senha.getPassword();
				
				depuracao.mensagemDepuracao("[View] Chamando o controller para iniciar o login");
				controller.realizarLogin(usuario, senha);
			}
		});
		btn_login.setBounds(100, 131, 106, 27);
		contentPane.add(btn_login);
		
		JLabel lbl_titulo = new JLabel("Login");
		lbl_titulo.setFont(new Font("Dialog", Font.BOLD, 30));
		lbl_titulo.setBounds(185, 35, 90, 40);
		contentPane.add(lbl_titulo);
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void setMensagem(String m) {
		if(lbl_mensagem == null) {
			lbl_mensagem = new JLabel(m);
			lbl_mensagem.setBounds(100, 170, 230, 17);
			contentPane.add(lbl_mensagem);
		} else {
			lbl_mensagem.setText(m);
		}
		
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	public void limparLogin() {
		txt_usuario.setText(null);
		pwd_senha.setText(null);
	}
}
