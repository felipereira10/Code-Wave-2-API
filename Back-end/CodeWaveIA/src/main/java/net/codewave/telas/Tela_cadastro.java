package net.codewave.telas;

import net.codewave.classes_de_conexao.Conexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 308);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUser.setBounds(41, 70, 66, 31);
		contentPane.add(lblUser);
		
		JLabel lblSenha = new JLabel("Password:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(23, 133, 84, 31);
		contentPane.add(lblSenha);
		
		JLabel lblCreateAcconunt = new JLabel("CREATE ACCOUNT");
		lblCreateAcconunt.setForeground(new Color(255, 255, 255));
		lblCreateAcconunt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCreateAcconunt.setBounds(135, 11, 206, 48);
		contentPane.add(lblCreateAcconunt);
		
		tfUser = new JTextField();
		tfUser.setBounds(117, 70, 172, 27);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(117, 133, 172, 27);
		contentPane.add(tfSenha);
		
		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
try {
					
				    Connection con = Conexao.faz_conexao();
				    
				    String sql ="INSERT INTO dados_senhas(user, senha) VALUES(?, ?);";
				    
				    PreparedStatement stmt = con.prepareStatement(sql);
				    
				    stmt.setString(1, tfUser.getText()); stmt.setString(2, tfSenha.getText());
				    
				    stmt.execute();
				    
				    stmt.close();
				    
				    con.close();
				    
				    JOptionPane.showMessageDialog(null, "you're signed up!");
				    
				    
		   
				    	Tela_login exibir = new Tela_login();
				    	exibir.setVisible(true);
				    	setVisible(false);
	
				
				} catch (SQLException e) {
					// TODO Auto-renerated catch block
					e.printStackTrace();
					
				} catch (ClassNotFoundException e) {
    throw new RuntimeException(e);
}

            }
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(98, 98, 98));
		btnNewButton.setBounds(147, 193, 116, 31);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("BACK");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(128, 128, 128));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela_cadastro.this.dispose();
				
				Tela_login frame = new Tela_login();
				frame.setVisible(true);
			}
		});
		btnExit.setBounds(355, 238, 79, 23);
		contentPane.add(btnExit);
	}

}
