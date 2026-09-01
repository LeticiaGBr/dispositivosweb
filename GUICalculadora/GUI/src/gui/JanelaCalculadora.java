package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaCalculadora extends JFrame {

	JTextField operando1;
	JTextField operando2;
	JTextField resultado;
	
	public JanelaCalculadora() {
		super("Minha janela");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel painel = new JPanel();
		add(painel);
		
		operando1 = new JTextField(10);
		painel.add(operando1);
		operando2 = new JTextField(10);
		painel.add(operando2);
		resultado = new JTextField(10);
		painel.add(resultado);
		JButton soma = new JButton("Soma");
		JButton sub = new JButton("Subtração");
		JButton div = new JButton("Divisão");
		JButton mult = new JButton("Multiplicação");
		JButton Limpar = new JButton("Limpar");
		painel.add(soma);
		painel.add(sub);
		painel.add(div);
		painel.add(mult);
		painel.add(Limpar);
		Limpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				operando1.setText(" ");
				operando2.setText(" " );
				resultado.setText("");
			}
		});
		
		
		soma.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					double soma = Double.valueOf(operando1.getText()) + Double.valueOf(operando2.getText());
					resultado.setText(String.valueOf(soma));
			}
		});
		sub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double sub = Double.valueOf(operando1.getText()) - Double.valueOf(operando2.getText());
				resultado.setText(String.valueOf(sub));				
			}
		});
		
		mult.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double mult = Double.valueOf(operando1.getText()) * Double.valueOf(operando2.getText());
				resultado.setText(String.valueOf(mult));						
			}
		});
		
		div.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Double b = Double.valueOf(operando2.getText());
				Double a = Double.valueOf(operando1.getText());
				Double c = 0.0;
				if (b!=0) {
					c = a/b;
					resultado.setText(String.valueOf(c));	

				}else {
					JOptionPane.showMessageDialog(null, "B = 0, divisão inválida!");

				}
			
			}
		});
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// continuacao
	
	
	class Acao implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			double soma = Double.valueOf(
					operando1.getText()) 
				+ Double.valueOf(operando2.getText());
			resultado.setText(String.valueOf(soma));
		}
	}
}
	

	
	
	

