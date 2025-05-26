package br.edu.fatecpg.LoginJava.view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import br.edu.fatecpg.LoginJava.controller.Controller;

public class Painel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbl_usuariologado;
	private Controller controller;
	private Depuracao depuracao;

	public Painel(Depuracao depuracao) {
		this.depuracao = depuracao;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Painel do usuário");
		
		JButton btn_logout = new JButton("Logout");
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.logout();
			}
		});
		btn_logout.setBounds(332, 229, 106, 27);
		contentPane.add(btn_logout);
	}
	
	protected void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void setUsuarioLogado(String usuario) {
		if(lbl_usuariologado == null) {
			lbl_usuariologado = new JLabel("Bem-vindo(a), " + usuario);
			lbl_usuariologado.setBounds(12, 0, 200, 17);
			contentPane.add(lbl_usuariologado);
		} else {
			lbl_usuariologado.setText("Bem-vindo(a), " + usuario);
		}
		
		contentPane.revalidate();
		contentPane.repaint();
	}
}
