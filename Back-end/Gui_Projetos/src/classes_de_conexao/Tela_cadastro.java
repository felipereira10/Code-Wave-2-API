package classes_de_conexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	private JTextField tfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_cadastro frame = new Tela_cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUser.setBounds(41, 70, 66, 31);
		contentPane.add(lblUser);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(41, 133, 66, 31);
		contentPane.add(lblSenha);
		
		JLabel lblCreateAcconunt = new JLabel("Create Acconunt");
		lblCreateAcconunt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCreateAcconunt.setBounds(147, 11, 142, 31);
		contentPane.add(lblCreateAcconunt);
		
		tfUser = new JTextField();
		tfUser.setBounds(117, 70, 172, 27);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(117, 133, 172, 27);
		contentPane.add(tfSenha);
		
		JButton btnNewButton = new JButton("SING UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(98, 98, 98));
		btnNewButton.setBounds(147, 193, 116, 31);
		contentPane.add(btnNewButton);
	}

}
