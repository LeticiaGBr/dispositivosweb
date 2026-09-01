package GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Janela extends JFrame{

	public Janela() {
		super("Minha Janlea");
	setSize(400, 200);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	JPanel painel = new JPanel();
	getContentPane().add(painel);

	JLabel label1 = new JLabel("Boa Noite ADS");
	painel.add(label1);
	JTextField Texto = new JTextField(30);
	painel.add(Texto);
	
	JButton button = new JButton("New button");
	painel.add(button);
	JTextField Texto2 = new JTextField(30);
	painel.add(Texto2);
	JTextField texto3 = new JTextField(30);
	painel.add(texto3);
	Texto.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			double soma = Double.valueOf(Texto.getText() +Double.valueOf(Texto2.getText()));
			texto3.setText(String.valueOf(soma));
		}
	});
Texto2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			double soma = Double.valueOf(Texto.getText() +Double.valueOf(Texto2.getText()));
			texto3.setText(String.valueOf(soma));
		}
	});
	}
}
