package gui;

import javax.swing.JOptionPane;

public class TesteOptionPane {
	public static void main(String[] args) {
		double a, b;
		a = Double.valueOf(JOptionPane.showInputDialog("Digite o primeiro operando:"));
		b = Double.valueOf(JOptionPane.showInputDialog("Digite o segundo operando:"));
		String[] opcoes = new String[] { "soma", "sub", "mult", "div" };
		int indiceOpcao = JOptionPane.showOptionDialog(null, "Selecione uma operação:", null, 0, 0, null, opcoes,
				opcoes[1]);

		double c = 0;
		switch (indiceOpcao) {
		case 0: // soma
			c = a + b;
			JOptionPane.showMessageDialog(null, "A + B = " + c);
			break;
		case 1: // sub
			c = a - b;
			JOptionPane.showMessageDialog(null, "A - B = " + c);
			break;
		case 2: // mult
			c = a * b;
			JOptionPane.showMessageDialog(null, "A * B = " + c);
			break;
		case 3:
			if (b != 0) {
				c = a / b;
				JOptionPane.showMessageDialog(null, "A / B = " + c);
			} else {
				JOptionPane.showMessageDialog(null, "B = 0, divisão inválida!");
			}
			break;
		}

	}
}
