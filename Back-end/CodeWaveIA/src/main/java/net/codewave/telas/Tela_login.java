package net.codewave.telas;

import net.codewave.classes_de_conexao.Conexao;

import java.awt.EventQueue;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Tela_login extends JFrame {

	public static String usuario;

	private JPanel contentPane;
	private JTextField tfUser;
	private JPasswordField pfSenha;
	private JButton btnCadastrar;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_login frame = new Tela_login();
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
	public Tela_login() {
		setResizable(false);
		setTitle("Tela login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUser.setBounds(51, 70, 71, 39);
		contentPane.add(lblUser);
		
		JLabel lblSenha = new JLabel("Password:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(31, 120, 91, 39);
		contentPane.add(lblSenha);
		
		tfUser = new JTextField();
		tfUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUser.setBounds(132, 75, 139, 29);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(132, 127, 139, 29);
		contentPane.add(pfSenha);
		
		JButton btnEntrar = new JButton("Sign in");
		btnEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
				    Connection con = Conexao.faz_conexao();
				    
				    String sql ="select *from dados_senhas where user=? and senha=?";
				    
				    PreparedStatement stmt = con.prepareStatement(sql);
				    
				    stmt.setString(1, tfUser.getText());
				    stmt.setString(2,new String(pfSenha.getPassword()));
				    
				    ResultSet rs = stmt.executeQuery();
				    
				    if(rs.next()) {
		   				usuario = tfUser.getText();
				    	Tela_import exibir = new Tela_import();
				    	exibir.setVisible(true);
				    	setVisible(false);
				    	
				    }else {
				    	JOptionPane.showMessageDialog(null, "Incorrect password/user.");
				    }
				    stmt.close();
				    con.close();
				
				
				
				} catch (SQLException e) {
					// TODO Auto-renerated catch block
					e.printStackTrace();
					
				} catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
		});
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(128, 128, 128));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntrar.setBounds(82, 190, 115, 29);
		contentPane.add(btnEntrar);
		
		btnCadastrar = new JButton("Sign up");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela_cadastro exibir = new Tela_cadastro();
		    	exibir.setVisible(true);
		    	setVisible(false);
		    
			
			}
		});
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrar.setBackground(new Color(128, 128, 128));
		btnCadastrar.setBounds(218, 190, 115, 29);
		contentPane.add(btnCadastrar);
		
		btnNewButton = new JButton("QUIT");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(176, 76, 76));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela_login.this.dispose();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(359, 238, 65, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Code Wave");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 24));
		lblNewLabel.setBounds(132, 11, 264, 39);
		contentPane.add(lblNewLabel);
	}
}
