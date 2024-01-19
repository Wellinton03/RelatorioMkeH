package Medias;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Gastos extends JFrame {

	// Relação com o problema
	private JTextField cliente;
	private JTextField cidade;
	private JTextField dataProblema;
	private JTextField tempSolucao;
	private JTextArea descricaoProblema;
	private JTextArea acoesCorretivas;

	// Km e Combustivel
	double custoCombustivel = 5.50;
	double mediaConsumo = 12.00;
	double gasolinaTlGasto;
	double consumoPorKm;
	private JTextField distancia;
	private JTextField custoMateriaPrima;

	// Sobre Funcionários
	private JTextField nomeFunEnvol;
	private JTextField setor;
	private JTextField hrFuncionario;
	private JTextField hrFuncionario2;
	private JTextField hrsTrabalhadas;
	private JTextField hrsTrabalhadas2;
	double totalDeHoras;
	double gastoTotal;
	String resultado;

	public Gastos() {
		super("Calculadora de Gastos");
		setSize(900, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());

		JPanel panelHk = new JPanel(new GridBagLayout());
		GridBagConstraints gbcHk = new GridBagConstraints();
		gbcHk.insets = new Insets(5, 5, 10, 5);

		JLabel clienteTxt = new JLabel("Qual o nome do(a) Cliente?");
		clienteTxt.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 1;
		gbcHk.gridy = 4;
		panelHk.add(clienteTxt, gbcHk);

		cliente = new JTextField(20);
		gbcHk.gridx = 1;
		gbcHk.gridy = 5;
		panelHk.add(cliente, gbcHk);

		JLabel cidadeTxt = new JLabel("Qual o nome da cidade do ocorrido?");
		cidadeTxt.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 1;
		gbcHk.gridy = 6;
		panelHk.add(cidadeTxt, gbcHk);

		cidade = new JTextField(20);
		gbcHk.gridx = 1;
		gbcHk.gridy = 7;
		panelHk.add(cidade, gbcHk);

		JLabel dataProblemaTxt = new JLabel("Qual a data do ocorrido? (dd/mm/aaaa)");
		dataProblemaTxt.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 1;
		gbcHk.gridy = 8;
		panelHk.add(dataProblemaTxt, gbcHk);

		dataProblema = new JTextField(20);
		gbcHk.gridx = 1;
		gbcHk.gridy = 9;
		panelHk.add(dataProblema, gbcHk);

		JLabel tempSolucaoTxt = new JLabel("Dias necessários para solução:");
		tempSolucaoTxt.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 1;
		gbcHk.gridy = 10;
		panelHk.add(tempSolucaoTxt, gbcHk);

		tempSolucao = new JTextField(20);
		gbcHk.gridx = 1;
		gbcHk.gridy = 11;
		panelHk.add(tempSolucao, gbcHk);

		JLabel distanciaTxt = new JLabel("Distância percorrida:");
		distanciaTxt.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 1;
		gbcHk.gridy = 12;
		panelHk.add(distanciaTxt, gbcHk);

		distancia = new JTextField(20);
		gbcHk.gridx = 1;
		gbcHk.gridy = 13;
		panelHk.add(distancia, gbcHk);

		JLabel custoMateriaPrimaTxt = new JLabel("Custos da matéria prima adicional:");
		custoMateriaPrimaTxt.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 1;
		gbcHk.gridy = 14;
		panelHk.add(custoMateriaPrimaTxt, gbcHk);

		custoMateriaPrima = new JTextField(20);
		gbcHk.gridx = 1;
		gbcHk.gridy = 15;
		panelHk.add(custoMateriaPrima, gbcHk);

		JLabel descricaoProblemaTxt = new JLabel("Descreva o problema:");
		descricaoProblemaTxt.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 1;
		gbcHk.gridy = 16;
		panelHk.add(descricaoProblemaTxt, gbcHk);

		descricaoProblema = new JTextArea(5, 20);
		descricaoProblema.setLineWrap(true);
		descricaoProblema.setWrapStyleWord(true);
		gbcHk.gridx = 1;
		gbcHk.gridy = 17;
		panelHk.add(new JScrollPane(descricaoProblema), gbcHk);

		JLabel nomeFunTxt = new JLabel("Qual o nome do(s) Funcionário(s)?");
		nomeFunTxt.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 3;
		gbcHk.gridy = 4;
		panelHk.add(nomeFunTxt, gbcHk);

		nomeFunEnvol = new JTextField(20);
		gbcHk.gridx = 3;
		gbcHk.gridy = 5;
		panelHk.add(nomeFunEnvol, gbcHk);

		JLabel setorTxt = new JLabel("Setor dos funcionários envolvidos:");
		setorTxt.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 3;
		gbcHk.gridy = 6;
		panelHk.add(setorTxt, gbcHk);

		setor = new JTextField(20);
		gbcHk.gridx = 3;
		gbcHk.gridy = 7;
		panelHk.add(setor, gbcHk);

		JLabel hrFuncionarioTxt = new JLabel("Qual é o valor hora do 1º funcionário(a)?");
		hrFuncionarioTxt.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 3;
		gbcHk.gridy = 8;
		panelHk.add(hrFuncionarioTxt, gbcHk);

		hrFuncionario = new JTextField(20);
		gbcHk.gridx = 3;
		gbcHk.gridy = 9;
		panelHk.add(hrFuncionario, gbcHk);

		JLabel hrsTrabalhadasTxt = new JLabel("Horas trabalhadas 1º funcionário(a):");
		hrsTrabalhadasTxt.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 3;
		gbcHk.gridy = 10;
		panelHk.add(hrsTrabalhadasTxt, gbcHk);

		hrsTrabalhadas = new JTextField(20);
		gbcHk.gridx = 3;
		gbcHk.gridy = 11;
		panelHk.add(hrsTrabalhadas, gbcHk);

		JLabel hrFuncionarioTxt2 = new JLabel("Qual é o valor hora do 2º funcionário(a)?");
		hrFuncionarioTxt2.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 3;
		gbcHk.gridy = 12;
		panelHk.add(hrFuncionarioTxt2, gbcHk);

		hrFuncionario2 = new JTextField(20);
		gbcHk.gridx = 3;
		gbcHk.gridy = 13;
		panelHk.add(hrFuncionario2, gbcHk);

		JLabel hrsTrabalhadasTxt2 = new JLabel("Horas trabalhadas 2º funcionário(a):");
		hrsTrabalhadasTxt.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 3;
		gbcHk.gridy = 14;
		panelHk.add(hrsTrabalhadasTxt2, gbcHk);

		hrsTrabalhadas2 = new JTextField(20);
		gbcHk.gridx = 3;
		gbcHk.gridy = 15;
		panelHk.add(hrsTrabalhadas2, gbcHk);

		JLabel acoesCorretivasTxt = new JLabel("Qual a ação foi tomada?");
		acoesCorretivasTxt.setFont(new Font("Arial", Font.BOLD, 12));
		gbcHk.gridx = 3;
		gbcHk.gridy = 16;
		panelHk.add(acoesCorretivasTxt, gbcHk);

		acoesCorretivas = new JTextArea(5, 20);
		acoesCorretivas.setLineWrap(true);
		acoesCorretivas.setWrapStyleWord(true);
		gbcHk.gridx = 3;
		gbcHk.gridy = 17;
		panelHk.add(new JScrollPane(acoesCorretivas), gbcHk);

		JLabel resultadoCliente = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 5;
		panelHk.add(resultadoCliente, gbcHk);

		JLabel resultadoCidade = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 6;
		panelHk.add(resultadoCidade, gbcHk);

		JLabel resultadoDistancia = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 7;
		panelHk.add(resultadoDistancia, gbcHk);

		JLabel resultadoDataProblema = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 8;
		panelHk.add(resultadoDataProblema, gbcHk);

		JLabel resultadoFuncionarios = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 9;
		panelHk.add(resultadoFuncionarios, gbcHk);

		JLabel resultadoSetor = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 10;
		panelHk.add(resultadoSetor, gbcHk);

		JLabel resultadoDescricaoProblema = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 11;
		panelHk.add(resultadoDescricaoProblema, gbcHk);

		JLabel resultadoSolucaoProblema = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 12;
		panelHk.add(resultadoSolucaoProblema, gbcHk);

		JLabel resultadoTempoDeSolucao = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 13;
		panelHk.add(resultadoTempoDeSolucao, gbcHk);

		JLabel resultadoHorasTrabalhadas = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 14;
		panelHk.add(resultadoHorasTrabalhadas, gbcHk);

		JLabel resultadoGastosMateriaPrima = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 15;
		panelHk.add(resultadoGastosMateriaPrima, gbcHk);

		JLabel resultadoGastosHoras = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 16;
		panelHk.add(resultadoGastosHoras, gbcHk);

		JLabel resultadoGastosCombustivel = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 17;
		panelHk.add(resultadoGastosCombustivel, gbcHk);

		JLabel resultadoGastoTotal = new JLabel();
		gbcHk.gridx = 5;
		gbcHk.gridy = 18;
		panelHk.add(resultadoGastoTotal, gbcHk);

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
		Dimension buttonResetSize = new Dimension(150, 30);
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
				limparCamposTexto(resultadoCliente, resultadoFuncionarios, resultadoDistancia, resultadoCidade,
						resultadoDataProblema, resultadoDescricaoProblema, resultadoSolucaoProblema,
						resultadoTempoDeSolucao, resultadoHorasTrabalhadas, resultadoGastosHoras,
						resultadoGastosCombustivel, resultadoGastosMateriaPrima, resultadoGastoTotal, resultadoSetor);
			}
		});

		buttonHk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					double hrFuncionarioDouble = parseDoubleOrDefault(hrFuncionario.getText(), 0);
					double hrFuncionarioDouble2 = parseDoubleOrDefault(hrFuncionario2.getText(), 0);
					double hrsTrabalhadasDouble = parseDoubleOrDefault(hrsTrabalhadas.getText(), 0);
					double hrsTrabalhadasDouble2 = parseDoubleOrDefault(hrsTrabalhadas2.getText(), 0);
					double distanciaDouble = Double.parseDouble(distancia.getText());
					double custoMateriaPrimaDouble = Double.parseDouble(custoMateriaPrima.getText());
					DecimalFormat df = new DecimalFormat("#.##");
					double totalTrabalhado = horasReais(hrsTrabalhadasDouble, hrsTrabalhadasDouble2);
					gasolinaTlGasto = gastoCombustivel(distanciaDouble, mediaConsumo, custoCombustivel);
					gastoTotal = calculoTotal(distanciaDouble, consumoPorKm, custoCombustivel, mediaConsumo,
							custoMateriaPrimaDouble, hrFuncionarioDouble, hrFuncionarioDouble2, hrsTrabalhadasDouble,
							hrsTrabalhadasDouble2);
					totalDeHoras = calculoDeHoras(hrFuncionarioDouble, hrsTrabalhadasDouble, hrFuncionarioDouble2,
							hrsTrabalhadasDouble2);
					String gastoTotalFormatado = df.format(gastoTotal);
					String gasolinaTlFormatada = df.format(gasolinaTlGasto);
					String totalTrabalhadoFormatado = df.format(totalTrabalhado);
					String totalDeHorasFormatado = df.format(totalDeHoras);

					resultadoCliente.setText("Cliente: " + cliente.getText());
					resultadoFuncionarios.setText("Funcionários(as) envolvido(as): " + nomeFunEnvol.getText());
					resultadoSetor.setText("Setor: " + setor.getText());
					resultadoDistancia.setText("Distância percorrida: " + distancia.getText() + "km");
					resultadoCidade.setText("Cidade de destino: " + cidade.getText());
					resultadoDataProblema.setText("Data do ocorrido: " + dataProblema.getText());
					resultadoDescricaoProblema.setText("Descrição do problema:" + " (enviado para o relatório)");
					resultadoSolucaoProblema.setText("Solução:" + " (enviado para o relatório)");
					resultadoTempoDeSolucao.setText("Dias para solucionar o problema: " + tempSolucao.getText());
					resultadoHorasTrabalhadas.setText(
							"Hora(s) trabalhada(s): " + totalTrabalhadoFormatado + "hr(s)");
					resultadoGastosHoras.setText("Gastos com horas: R$" + totalDeHorasFormatado + " reais");
					resultadoGastosCombustivel.setText("Gastos com combustível: R$" + gasolinaTlFormatada + " reais");
					resultadoGastosMateriaPrima
							.setText("Gastos com matéria prima: R$" + custoMateriaPrimaDouble + " reais");
					resultadoGastoTotal.setText("Gasto total: R$" + gastoTotalFormatado + " reais");

					String desktopPath = System.getProperty("user.home") + "/Desktop/";
					File outputFile = new File(desktopPath + "Relatorio.txt");

					try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
						writer.write("Cliente: " + cliente.getText() + "\n");
						writer.write("Funcionários(as) envolvido(as): " + nomeFunEnvol.getText() + "\n");
						writer.write("Setor: " + setor.getText() + "\n");
						writer.write("Distância percorrida: " + distancia.getText() + "km\n");
						writer.write("Cidade de destino: " + cidade.getText() + "\n");
						writer.write("Data do ocorrido: " + dataProblema.getText() + "\n");
						writer.write("Descrição do problema: " + descricaoProblema.getText() + "\n");
						writer.write("Solução: " + acoesCorretivas.getText() + "\n");
						writer.write("Dias para solucionar o problema: " + tempSolucao.getText() + "\n");
						writer.write(
								"Hora(s) trabalhada(s): " + totalTrabalhadoFormatado + "hr(s)\n");
						writer.write("\n");
						writer.write("GASTOS:");
						writer.write("\n");
						writer.write("Gastos com horas: R$" + totalDeHorasFormatado + " reais\n");
						writer.write("Gastos com Combustível: R$" + gasolinaTlFormatada + " reais\n");
						writer.write("Gastos com Matéria prima: R$" + custoMateriaPrimaDouble + " reais\n");
						writer.write("Gasto total: R$" + gastoTotalFormatado + " reais\n\n");
						writer.write("---------------------------------------------------------------------");
						writer.write("\n");
						writer.close();
						JOptionPane.showMessageDialog(Gastos.this, "Relatório salvo com sucesso!", "Sucesso",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(Gastos.this, "Erro ao salvar o arquivo.", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(Gastos.this, "Por favor, insira valores numéricos válidos.", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			private double parseDoubleOrDefault(String input, double defaultValue) {
				try {
					return input.isEmpty() ? defaultValue : Double.parseDouble(input);
				} catch (NumberFormatException e) {
					return defaultValue;
				}
			}
		});

		add(panelHk, BorderLayout.WEST);
		revalidate();
		repaint();
	}

	private void limparCamposTexto(JLabel resultadoCliente, JLabel resultadoFuncionarios, JLabel resultadoDistancia,
			JLabel resultadoCidade, JLabel resultadoDataProblema, JLabel resultadoDescricaoProblema,
			JLabel resultadoSolucaoProblema, JLabel resultadoTempoDeSolucao, JLabel resultadoHorasTrabalhadas,
			JLabel resultadoGastosHoras, JLabel resultadoGastosCombustivel, JLabel resultadoGastosMateriaPrima,
			JLabel resultadoGastoTotal, JLabel resultadoSetor) {

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
		setor.setText("");
		hrFuncionario2.setText("");
		hrsTrabalhadas.setText("");
		hrsTrabalhadas2.setText("");

		resultadoCliente.setText("");
		resultadoFuncionarios.setText("");
		resultadoSetor.setText("");
		resultadoDistancia.setText("");
		resultadoCidade.setText("");
		resultadoDataProblema.setText("");
		resultadoDescricaoProblema.setText("");
		resultadoSolucaoProblema.setText("");
		resultadoTempoDeSolucao.setText("");
		resultadoHorasTrabalhadas.setText("");
		resultadoGastosHoras.setText("");
		resultadoGastosCombustivel.setText("");
		resultadoGastosMateriaPrima.setText("");
		resultadoGastoTotal.setText("");
	}

	public double calculoTotal(double distancia, double consumoPorKm, double custoCombustivel, double mediaConsumo,
			double custoMateriaPrima, double hrFuncionario, double hrFuncionario2, double hrsTrabalhadas,
			double hrsTrabalhadas2) {

		gasolinaTlGasto = gastoCombustivel(distancia, mediaConsumo, custoCombustivel);
		totalDeHoras = calculoDeHoras(hrFuncionario, hrsTrabalhadas, hrFuncionario2, hrsTrabalhadas2);
		double gastoTotal = gasolinaTlGasto + totalDeHoras + custoMateriaPrima;

		return gastoTotal;

	}

	public double horasReais(double hrsTrabalhadas, double hrsTrabalhadas2) {

		double totalTrabalhado = hrsTrabalhadas + hrsTrabalhadas2;
		return totalTrabalhado;
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