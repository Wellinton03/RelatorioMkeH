package Medias;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Gastos extends JFrame {

	// Relação com o problema
	private JTextField cliente;
	private JTextField cidade;
	private JTextField dataProblema;
	private JTextField tempSolucao;
	private JTextField descricaoProblema;
	private JTextField acoesCorretivas;

	// Km e Combustivel
	double custoCombustivel = 5.50;
	double mediaConsumo = 12.00;
	double gasolinaTlGasto;
	double consumoPorKm;
	private JTextField distancia;
	private JTextField custoMateriaPrima;

	// Sobre Funcionários
	private JTextField nomeFunEnvol;
	private JTextField hrFuncionario;
	private JTextField hrFuncionario2;
	private JTextField hrsTrabalhadas;
	private JTextField hrsTrabalhadas2;
	double totalDeHoras;
	double gastoTotal;
	String resultado;

	public Gastos() {
		super("Calculadora de Gastos");
		setSize(1320, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
	

		
			JPanel panelHk = new JPanel(new GridBagLayout());
			GridBagConstraints gbcHk = new GridBagConstraints();
			gbcHk.insets = new Insets(5, 5, 10, 5);
			
			
			JLabel clienteTxt = new JLabel("Qual o nome do(a) Cliente?");
			clienteTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 1;
			gbcHk.gridy = 6;
			panelHk.add(clienteTxt, gbcHk);

			cliente = new JTextField(20);
			gbcHk.gridx = 1;
			gbcHk.gridy = 7;
			panelHk.add(cliente, gbcHk);
			
			JLabel cidadeTxt = new JLabel("Qual o nome da cidade do ocorrido?");
			cidadeTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 1;
			gbcHk.gridy = 8;
			panelHk.add(cidadeTxt, gbcHk);

			cidade = new JTextField(20);
			gbcHk.gridx = 1;
			gbcHk.gridy = 9;
			panelHk.add(cidade, gbcHk);
			
			JLabel dataProblemaTxt = new JLabel("Qual a data do ocorrido? (xx/xx/xxxx)");
			dataProblemaTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 1;
			gbcHk.gridy = 10;
			panelHk.add(dataProblemaTxt, gbcHk);

			dataProblema = new JTextField(20);
			gbcHk.gridx = 1;
			gbcHk.gridy = 11;
			panelHk.add(dataProblema, gbcHk);
			
			JLabel tempSolucaoTxt = new JLabel("Dias necessários para solução:");
			tempSolucaoTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 1;
			gbcHk.gridy = 12;
			panelHk.add(tempSolucaoTxt, gbcHk);

			tempSolucao = new JTextField(20);
			gbcHk.gridx = 1;
			gbcHk.gridy = 13;
			panelHk.add(tempSolucao, gbcHk);
			
			JLabel acoesCorretivasTxt = new JLabel("Qual a ação foi tomada?");
			acoesCorretivasTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 1;
			gbcHk.gridy = 14;
			panelHk.add(acoesCorretivasTxt, gbcHk);
			
			acoesCorretivas = new JTextField(20);
			gbcHk.gridx = 1;
			gbcHk.gridy = 15;
			panelHk.add(acoesCorretivas, gbcHk);
			
			JLabel descricaoProblemaTxt = new JLabel("Descreva o problema:");
			descricaoProblemaTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 1;
			gbcHk.gridy = 16;
			panelHk.add(descricaoProblemaTxt, gbcHk);

			descricaoProblema = new JTextField(20);
			gbcHk.gridx = 1;
			gbcHk.gridy = 17;
			panelHk.add(descricaoProblema, gbcHk);
			
			JLabel custoMateriaPrimaTxt = new JLabel("Insira os custos da matéria prima adicional:");
			custoMateriaPrimaTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 1;
			gbcHk.gridy = 18;
			panelHk.add(custoMateriaPrimaTxt, gbcHk);

			custoMateriaPrima = new JTextField(20);
			gbcHk.gridx = 1;
			gbcHk.gridy = 19;
			panelHk.add(custoMateriaPrima, gbcHk);
			

			JLabel nomeFunTxt = new JLabel("Qual o nome do(s) Funcionário(s)?");
			nomeFunTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 3;
			gbcHk.gridy = 6;
			panelHk.add(nomeFunTxt, gbcHk);

			nomeFunEnvol = new JTextField(20);
			gbcHk.gridx = 3;
			gbcHk.gridy = 7;
			panelHk.add(nomeFunEnvol, gbcHk);

			JLabel hrFuncionarioTxt = new JLabel("Qual é o valor hora do 1º funcionário?");
			hrFuncionarioTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 3;
			gbcHk.gridy = 8;
			panelHk.add(hrFuncionarioTxt, gbcHk);

			hrFuncionario = new JTextField(20);
			gbcHk.gridx = 3;
			gbcHk.gridy = 9;
			panelHk.add(hrFuncionario, gbcHk);
			
			JLabel hrFuncionarioTxt2 = new JLabel("Qual é o valor hora do 2º funcionário?");
			hrFuncionarioTxt2.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 3;
			gbcHk.gridy = 10;
			panelHk.add(hrFuncionarioTxt2, gbcHk);

			hrFuncionario2 = new JTextField(20);
			gbcHk.gridx = 3;
			gbcHk.gridy = 11;
			panelHk.add(hrFuncionario2, gbcHk);

			JLabel hrsTrabalhadasTxt = new JLabel("Horas trabalhadas pelo 1º funcionário:");
			hrsTrabalhadasTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 3;
			gbcHk.gridy = 12;
			panelHk.add(hrsTrabalhadasTxt, gbcHk);

			hrsTrabalhadas = new JTextField(20);
			gbcHk.gridx = 3;
			gbcHk.gridy = 13;
			panelHk.add(hrsTrabalhadas, gbcHk);
			
			JLabel hrsTrabalhadasTxt2 = new JLabel("Horas trabalhadas pelo 2º funcionário:");
			hrsTrabalhadasTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 3;
			gbcHk.gridy = 14;
			panelHk.add(hrsTrabalhadasTxt2, gbcHk);

			hrsTrabalhadas2 = new JTextField(20);
			gbcHk.gridx = 3;
			gbcHk.gridy = 15;
			panelHk.add(hrsTrabalhadas2, gbcHk);

			JLabel distanciaTxt = new JLabel("Insira a distância percorrida em quilômetros:");
			distanciaTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 3;
			gbcHk.gridy = 16;
			panelHk.add(distanciaTxt, gbcHk);

			distancia = new JTextField(20);
			gbcHk.gridx = 3;
			gbcHk.gridy = 17;
			panelHk.add(distancia, gbcHk);
			
			JLabel resultadoFuncionarios = new JLabel();
			gbcHk.gridx = 4;
			gbcHk.gridy = 5;
			panelHk.add(resultadoFuncionarios, gbcHk);
			
			JLabel resultadoGastoTotal = new JLabel();
			gbcHk.gridx = 4;
			gbcHk.gridy = 6;
			panelHk.add(resultadoGastoTotal, gbcHk);

			JLabel resultadoGastosHoras = new JLabel();
			gbcHk.gridx = 4;
			gbcHk.gridy = 7;
			panelHk.add(resultadoGastosHoras, gbcHk);

			JLabel resultadoGastosCombustivel = new JLabel();
			gbcHk.gridx = 4;
			gbcHk.gridy = 8;
			panelHk.add(resultadoGastosCombustivel, gbcHk);

			JLabel resultadoGastosMateriaPrima = new JLabel();
			gbcHk.gridx = 4;
			gbcHk.gridy = 9;
			panelHk.add(resultadoGastosMateriaPrima, gbcHk);
			
			JButton buttonHk = new JButton("CALCULAR");
			Dimension buttonSizeHk = new Dimension(150, 30);
			buttonHk.setPreferredSize(buttonSizeHk);
			buttonHk.setFont(new Font("Arial", Font.BOLD, 11));
			buttonHk.setForeground(new Color(255, 250, 250));
			buttonHk.setBackground(new Color(34, 139, 34));
			gbcHk.gridx = 3;
			gbcHk.gridy = 19;
			panelHk.add(buttonHk, gbcHk);
			
			JButton buttonReset = new JButton("LIMPAR");
			Dimension buttonResetSize = new Dimension(150,30);
			buttonReset.setPreferredSize(buttonResetSize);
			buttonReset.setFont(new Font("Arial", Font.BOLD, 11));
			buttonReset.setForeground(new Color(255, 250, 250));
			buttonReset.setBackground(new Color(34, 139, 34));
			gbcHk.gridx = 3;
			gbcHk.gridy = 20;
			panelHk.add(buttonReset, gbcHk);
			
			JButton button = new JButton("CRISTAL ESQUADRIAS (RS) - Aberturas de alto padrão em VIDRO, ALUMÍNIO e PVC.");
			button.setFont(new Font("Arial", Font.BOLD, 11));
			button.setForeground(new Color(255, 250, 250));
			button.setBackground(new Color(34, 139, 34));
			gbcHk.gridy = 24;
			add(button, BorderLayout.SOUTH);
			
			buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        limparCamposTexto();
		    }
			});
			
			buttonHk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						double hrFuncionarioDouble = Double.parseDouble(hrFuncionario.getText());
						double hrFuncionarioDouble2 = Double.parseDouble(hrFuncionario2.getText());
						double hrsTrabalhadasDouble = Double.parseDouble(hrsTrabalhadas.getText());
						double distanciaDouble = Double.parseDouble(distancia.getText());
						double hrsTrabalhadasDouble2 = Double.parseDouble(hrsTrabalhadas.getText());
					    double custoMateriaPrimaDouble = Double.parseDouble(custoMateriaPrima.getText());
					    DecimalFormat df = new DecimalFormat("#.##");
					    gasolinaTlGasto = gastoCombustivel(distanciaDouble, mediaConsumo, custoCombustivel);
					    gastoTotal = calculoTotal(consumoPorKm,custoCombustivel,distanciaDouble,mediaConsumo, custoMateriaPrimaDouble, hrFuncionarioDouble, hrFuncionarioDouble2, hrsTrabalhadasDouble, hrsTrabalhadasDouble2);
					    String gasolinaFormatada = df.format(gasolinaTlGasto);
					    String gastoTotalFormatado = df.format(gastoTotal);					    
					    resultadoFuncionarios.setText("<html>O(s) funcionários(s) " + nomeFunEnvol.getText() + " percorreram uma distância total de " + distancia.getText() + "km <br> "
					    		+ "para ir e vir da cidade de "
					            + cidade.getText()   + " vistar o cliente " + cliente.getText() + " na data " + dataProblema.getText() + ",<br>"
					            		+ " por causa do problema " + descricaoProblema.getText() + " <br> "
					            				+ " a solução para este problema foi" + acoesCorretivas.getText() + " <br>"
					            						+ " levaram" + tempSolucao.getText() + " dias e " + totalDeHoras + " horas para resolver</html>");
					    resultadoGastosHoras.setText("Os gastos com horas foi R$" + totalDeHoras + " reais");
					    resultadoGastosCombustivel.setText("Os gastos com Combustível foi R$" + gasolinaFormatada + " reais");
					    resultadoGastosMateriaPrima.setText("Os gastos com Matéria prima foi R$" + custoMateriaPrimaDouble + " reais");
					    resultadoGastoTotal.setText("O gasto total foi de R$" + gastoTotalFormatado + " reais");
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(Gastos.this, "Por favor, insira valores numéricos válidos.",
								"Erro", JOptionPane.ERROR_MESSAGE);
					
					}
				}

					});
			

			add(panelHk, BorderLayout.WEST);
			revalidate();
			repaint();
	}

private void limparCamposTexto() {
    cliente.setText("");
    cidade.setText("");
    dataProblema.setText("");
    tempSolucao.setText("");
    descricaoProblema.setText("");
    acoesCorretivas.setText("");
    distancia.setText("");
    custoMateriaPrima.setText("");
    nomeFunEnvol.setText("");
    hrFuncionario.setText("");
    hrFuncionario2.setText("");
    hrsTrabalhadas.setText("");
    hrsTrabalhadas2.setText("");
}

	public double calculoTotal(double distancia, double consumoPorKm, double custoCombustivel,double mediaConsumo, double custoMateriaPrima,
			double hrFuncionario, double hrFuncionario2, double hrsTrabalhadas, double hrsTrabalhadas2) {
		
		gasolinaTlGasto = gastoCombustivel(distancia, mediaConsumo, custoCombustivel);
		 totalDeHoras = calculoDeHoras(hrFuncionario, hrsTrabalhadas, hrFuncionario2, hrsTrabalhadas2);
		 double gastoTotal = gasolinaTlGasto + totalDeHoras + custoMateriaPrima;

		return gastoTotal;

	}

	public double calculoDeHoras(double hrFuncionario, double hrsTrabalhadas, double hrFuncionario2,
			double hrsTrabalhadas2) {
		double totalDeHoras = hrFuncionario * hrsTrabalhadas + hrFuncionario2 * hrsTrabalhadas2;
		return totalDeHoras;
	}

	public double gastoCombustivel(double distancia, double mediaConsumo, double custoCombustivel) {
		consumoPorKm = distancia / mediaConsumo;
		gasolinaTlGasto = consumoPorKm * custoCombustivel;
		return gasolinaTlGasto;
	}

	public static void main(String[] args) {
		new Gastos().setVisible(true);
	}
}