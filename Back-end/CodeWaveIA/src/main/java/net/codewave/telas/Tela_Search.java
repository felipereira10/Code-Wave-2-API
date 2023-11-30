package net.codewave.telas;

import net.codewave.classes_de_conexao.Ai;
import net.codewave.classes_de_conexao.Conexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static dev.langchain4j.data.document.FileSystemDocumentLoader.loadDocument;

public class Tela_Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Search frame = new Tela_Search();
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
	public Tela_Search() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSearch = new JButton("Ask");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRegistro(Tela_login.usuario,Tela_import.arquivoSelecionado.getName(), LocalDate.now());
				System.out.println("Mensagem Enviada: " + textField.getText());
				textField_1.setText(Ai.loadIntoHugging(Tela_import.doc,textField.getText()));
				System.out.println("Mensagem Recebida: " + textField_1.getText());
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(Color.GRAY);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(140, 96, 168, 34);
		contentPane.add(btnSearch);
		
		textField = new JTextField();
		textField.setBounds(87, 51, 285, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(JTextField.LEFT);
		textField_1.setAutoscrolls(true);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 156, 414, 143);
		contentPane.add(textField_1);
		
		JButton btnExit = new JButton("BACK");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.GRAY);
		btnExit.setBounds(335, 327, 89, 23);
		contentPane.add(btnExit);
	}
	private static void AddRegistro(String nome, String titulo, LocalDate data){
		String sql = "insert into registro (user,documento,data_registro) values (?,?,?)";
		try{
			Connection connection = Conexao.faz_conexao();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,nome);
			stmt.setString(2,titulo);
			stmt.setDate(3, Date.valueOf(data));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
