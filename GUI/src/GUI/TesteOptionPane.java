package GUI;

import javax.swing.JOptionPane;

public class TesteOptionPane {
	public static void main(String[] args) {
		JOptionPane painel = new JOptionPane();
		double a = Double.valueOf(JOptionPane.showInputDialog("Digite o primeiro numero"));
		double b = Double.valueOf(JOptionPane.showInputDialog("Digite o segundo numero"));
		String[] opcoes  = new String[] {"Soma","Subtracao","Multiplicao","Divisao"};
		
		int indiceOpcao = JOptionPane.showOptionDialog(null, "Selecione uma operacao", null, 0, 0, null, opcoes,opcoes[0]);
		
		double c = 0;
		switch (indiceOpcao) {
		case 0:
			c=a+b;
			JOptionPane.showMessageDialog(null, "A+b = " + c);
			break;
		case 1:
			c=a-b;
			JOptionPane.showMessageDialog(null, "A-b = " + c);
			break;
		case 2:
			c=a*b;
			JOptionPane.showMessageDialog(null, "AxB = " + c);
			break;
		case 3:
			if (b!= 0) {
				c = a/b;
				JOptionPane.showMessageDialog(null, "A/B = " + c);
				
			}else {
				JOptionPane.showInternalMessageDialog(null, "B=0, divisao invalida ");	
			}
			break;
		}
		
		
	}

}
