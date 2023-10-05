package classes_de_conexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class Tela_import extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnImport = new JButton("IMPORT");
		btnImport.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnImport.setBounds(24, 85, 117, 29);
		contentPane.add(btnImport);
		
		JButton btnRecords = new JButton("RECORDS");
		btnRecords.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRecords.setBounds(24, 145, 117, 29);
		contentPane.add(btnRecords);
		
		JLabel lblImport = new JLabel("IMPORT OR FILE");
		lblImport.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblImport.setBounds(143, 11, 143, 35);
		contentPane.add(lblImport);
	}

}
