package net.codewave.telas;

import dev.langchain4j.data.document.Document;
import net.codewave.classes_de_conexao.Ai;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.File;
import java.util.Objects;

import static dev.langchain4j.data.document.FileSystemDocumentLoader.loadDocument;

public class Tela_import extends JFrame {

	private JPanel contentPane;
	public static File arquivoSelecionado;
	public static Document doc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_import frame = new Tela_import();
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
	public Tela_import() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnImport = new JButton("ASK YOUR QUESTION");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	               
	                // Crie uma instância da janela Tela_Search
	                Tela_Search telaSearch = new Tela_Search();
	                telaSearch.setVisible(true);

			}
		});
		btnImport.setForeground(new Color(255, 255, 255));
		btnImport.setBackground(new Color(128, 128, 128));
		btnImport.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnImport.setBounds(119, 242, 198, 46);
		contentPane.add(btnImport);
		
//		JButton btnRecords = new JButton("RECORDS");
//		btnRecords.setForeground(new Color(255, 255, 255));
//		btnRecords.setBackground(new Color(128, 128, 128));
//		btnRecords.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnRecords.setBounds(24, 401, 107, 29);
//		contentPane.add(btnRecords);
		
		JLabel lblImport = new JLabel("IMPORT YOUR FILE");
		lblImport.setForeground(new Color(255, 255, 255));
		lblImport.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblImport.setBounds(119, 11, 198, 35);
		contentPane.add(lblImport);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		textPane.setBounds(138, 127, 160, 29);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Tela_import.this.dispose(); 
			
			Tela_login frame = new Tela_login();
			frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(357, 404, 67, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SELECT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF,TXT","pdf","txt");
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.addChoosableFileFilter(filter);

				int repostDoFileChooser = fileChooser.showOpenDialog(null);

				if(repostDoFileChooser == JFileChooser.APPROVE_OPTION){
					arquivoSelecionado = fileChooser.getSelectedFile();
					textPane.setText(arquivoSelecionado.getName());
					doc = loadDocument(Objects.requireNonNull(Ai.limparArquivo(arquivoSelecionado.getPath())));
					System.out.println(doc);
				}else {
					System.out.println("Nenhum arquivo encontrado");
				}

			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(24, 128, 107, 28);
		contentPane.add(btnNewButton_1);

	}
}
