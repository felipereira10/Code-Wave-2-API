package classes_de_conexao;

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
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Tela_login extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	private JPasswordField pfSenha;
	private JButton btnCadastrar;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUser.setBounds(51, 35, 71, 39);
		contentPane.add(lblUser);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(51, 120, 71, 39);
		contentPane.add(lblSenha);
		
		tfUser = new JTextField();
		tfUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUser.setBounds(132, 37, 139, 39);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(132, 122, 139, 39);
		contentPane.add(pfSenha);
		
		JButton btnEntrar = new JButton("Entrar");
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
		   
				    	Tela_import exibir = new Tela_import();
				    	exibir.setVisible(true);
				    	setVisible(false);
				    	
				    }else {
				    	JOptionPane.showMessageDialog(null, "Usuario/Senha incorreto");
				    }
				    stmt.close();
				    con.close();
				
				
				
				} catch (SQLException e) {
					// TODO Auto-renerated catch block
					e.printStackTrace();
					
				}
				
			}
		});
		btnEntrar.setForeground(UIManager.getColor("Button.highlight"));
		btnEntrar.setBackground(new Color(98, 98, 98));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntrar.setBounds(82, 190, 115, 29);
		contentPane.add(btnEntrar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela_cadastro exibir = new Tela_cadastro();
		    	exibir.setVisible(true);
		    	setVisible(false);
		    
			
			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrar.setBackground(new Color(98, 98, 98));
		btnCadastrar.setBounds(218, 190, 115, 29);
		contentPane.add(btnCadastrar);
	}
}
