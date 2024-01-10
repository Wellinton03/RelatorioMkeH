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
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Gastos extends JFrame {

	private JTextField decisao;
	private JTextField distancia;
	private JTextField nomeFun;
	double custoGasolina = 5.50;
	double mediaConsumo = 12.00;
	double gasolinaTlGasto;
	double consumoPorKm;
	private JTextField hrFuncionario;
	private JTextField hrsTrabalhadas;
	double totalDeHoras;
	String opcao;
	String resultado;

	public Gastos() {
		super("Calculadora de Gastos");
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());

		JLabel texto = new JLabel(
				"<html>KM - para quilometragem<br>Hora - para horas extras<br>HK - para ambos<br><br>O que será calculado?</html>");
		texto.setFont(new Font("Arial", Font.BOLD, 12));

		decisao = new JTextField(20);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 0, 10, 0);
		panel.add(texto, gbc);

		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.NORTH;
		panel.add(decisao, gbc);

		add(panel, BorderLayout.NORTH);

		JButton button = new JButton("CRISTAL.INC");
		button.setFont(new Font("Arial", Font.BOLD, 11));
		button.setForeground(new Color(255, 250, 250));
		button.setBackground(new Color(34, 139, 34));
		gbc.gridy = 2;
		add(button, BorderLayout.SOUTH);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				processarEntradas();
			}
		});
	}

	private void processarEntradas() {
		String opcao = decisao.getText();
		JLabel resultado = new JLabel();

		if (opcao.equalsIgnoreCase("KM")) {
			JPanel panelKm = new JPanel(new GridBagLayout());
			GridBagConstraints gbcKm = new GridBagConstraints();
			gbcKm.insets = new Insets(5, 5, 10, 5);

			JLabel nomeFunTxt = new JLabel("Qual o nome do Funcionário?");
			nomeFunTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcKm.gridx = 0;
			gbcKm.gridy = 0;
			panelKm.add(nomeFunTxt, gbcKm);

			nomeFun = new JTextField(20);
			gbcKm.gridy = 1;
			panelKm.add(nomeFun, gbcKm);

			JLabel distanciaTxt = new JLabel("Insira a distância percorrida em quilômetros:");
			distanciaTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcKm.gridy = 2;
			panelKm.add(distanciaTxt, gbcKm);

			distancia = new JTextField(20);
			gbcKm.gridy = 3;
			panelKm.add(distancia, gbcKm);

			JButton buttonKm = new JButton("CALCULAR");
			buttonKm.setFont(new Font("Arial", Font.BOLD, 11));
			buttonKm.setForeground(new Color(255, 250, 250));
			buttonKm.setBackground(new Color(34, 139, 34));
			gbcKm.gridy = 4;
			buttonKm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						double distanciaDouble = Double.parseDouble(distancia.getText());
						gasolinaTlGasto = gastoCombustivel(distanciaDouble, consumoPorKm, custoGasolina);
						DecimalFormat df = new DecimalFormat("#.##");
						String gasolinaFormatada = df.format(gasolinaTlGasto);
						System.out.println("O funcionário(a) " + nomeFun.getText() + " teve um gasto de "
								+ gasolinaFormatada + " reais com combustível");
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(Gastos.this, "Por favor, insira uma distância válida.", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			gbcKm.gridy = 5;
			panelKm.add(buttonKm, gbcKm);

			add(panelKm, BorderLayout.CENTER);
			panelKm.revalidate();
			panelKm.repaint();

		} else if (opcao.equalsIgnoreCase("Hora")) {
			JPanel panelHora = new JPanel(new GridBagLayout());
			GridBagConstraints gbcHora = new GridBagConstraints();
			gbcHora.insets = new Insets(5, 5, 10, 5);

			JLabel nomeFunTxt = new JLabel("Qual o nome do Funcionário?");
			nomeFunTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHora.gridx = 0;
			gbcHora.gridy = 0;
			panelHora.add(nomeFunTxt, gbcHora);

			nomeFun = new JTextField(20);
			gbcHora.gridy = 1;
			panelHora.add(nomeFun, gbcHora);

			JLabel hrFuncionarioTxt = new JLabel("Qual é o valor hora deste funcionário?");
			hrFuncionarioTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHora.gridy = 2;
			panelHora.add(hrFuncionarioTxt, gbcHora);

			hrFuncionario = new JTextField(20);
			gbcHora.gridy = 3;
			panelHora.add(hrFuncionario, gbcHora);

			JLabel hrsTrabalhadasTxt = new JLabel("Quantas horas foram trabalhadas?");
			hrsTrabalhadasTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHora.gridy = 4;
			panelHora.add(hrsTrabalhadasTxt, gbcHora);

			hrsTrabalhadas = new JTextField(20);
			gbcHora.gridy = 5;
			panelHora.add(hrsTrabalhadas, gbcHora);

			JButton buttonHora = new JButton("CALCULAR");
			buttonHora.setFont(new Font("Arial", Font.BOLD, 11));
			buttonHora.setForeground(new Color(255, 250, 250));
			buttonHora.setBackground(new Color(34, 139, 34));
			gbcHora.gridy = 6;
			buttonHora.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						double hrFuncionarioDouble = Double.parseDouble(hrFuncionario.getText());
						double hrsTrabalhadasDouble = Double.parseDouble(hrsTrabalhadas.getText());
						totalDeHoras = CalculoDeHoras(hrFuncionarioDouble, hrsTrabalhadasDouble);
						DecimalFormat df = new DecimalFormat("#.##");
						String totalDeHorasFormatada = df.format(totalDeHoras);
						System.out.println("O funcionário(a) " + nomeFun.getText() + " teve um Gasto de " + totalDeHorasFormatada
								+ " de reais sobre as horas trabalhadas");
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(Gastos.this, "Por favor, insira valores numéricos válidos.",
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			gbcHora.gridy = 7;
		    panelHora.add(buttonHora, gbcHora);

			add(panelHora, BorderLayout.CENTER);
			revalidate();
			repaint();

		} else if (opcao.equalsIgnoreCase("Hk")) {
			JPanel panelHk = new JPanel(new GridBagLayout());
			GridBagConstraints gbcHk = new GridBagConstraints();
			gbcHk.insets = new Insets(5, 5, 10, 5);

			JLabel nomeFunTxt = new JLabel("Qual o nome do Funcionário?");
			nomeFunTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridx = 0;
			gbcHk.gridy = 0;
			panelHk.add(nomeFunTxt, gbcHk);

			nomeFun = new JTextField(20);
			gbcHk.gridy = 1;
			panelHk.add(nomeFun, gbcHk);

			JLabel hrFuncionarioTxt = new JLabel("Qual é o valor hora deste funcionário?");
			hrFuncionarioTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridy = 2;
			panelHk.add(hrFuncionarioTxt, gbcHk);

			hrFuncionario = new JTextField(20);
			gbcHk.gridy = 3;
			panelHk.add(hrFuncionario, gbcHk);

			JLabel hrsTrabalhadasTxt = new JLabel("Quantas horas foram trabalhadas?");
			hrsTrabalhadasTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridy = 4;
			panelHk.add(hrsTrabalhadasTxt, gbcHk);

			hrsTrabalhadas = new JTextField(20);
			gbcHk.gridy = 5;
			panelHk.add(hrsTrabalhadas, gbcHk);

			JButton buttonHora = new JButton("CALCULAR");
			buttonHora.setFont(new Font("Arial", Font.BOLD, 11));
			buttonHora.setForeground(new Color(255, 250, 250));
			buttonHora.setBackground(new Color(34, 139, 34));
			gbcHk.gridy = 6;

			JLabel distanciaTxt = new JLabel("Insira a distância percorrida em quilômetros:");
			distanciaTxt.setFont(new Font("Arial", Font.BOLD, 12));
			gbcHk.gridy = 7;
			panelHk.add(distanciaTxt, gbcHk);

			distancia = new JTextField(20);
			gbcHk.gridy = 8;
			panelHk.add(distancia, gbcHk);

			JButton buttonKm = new JButton("CALCULAR");
			buttonKm.setFont(new Font("Arial", Font.BOLD, 11));
			buttonKm.setForeground(new Color(255, 250, 250));
			buttonKm.setBackground(new Color(34, 139, 34));
			gbcHk.gridy = 9;
			buttonHora.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						double hrFuncionarioDouble = Double.parseDouble(hrFuncionario.getText());
						double hrsTrabalhadasDouble = Double.parseDouble(hrsTrabalhadas.getText());
						double distanciaDouble = Double.parseDouble(distancia.getText());
						gasolinaTlGasto = gastoCombustivel(distanciaDouble, consumoPorKm, custoGasolina);
						totalDeHoras = CalculoDeHoras(hrFuncionarioDouble, hrsTrabalhadasDouble);
						DecimalFormat df = new DecimalFormat("#.##");
						String totalDeHorasFormatada = df.format(totalDeHoras);
						String gasolinaFormatada = df.format(gasolinaTlGasto);
						JLabel resultado = new JLabel ("O funcionário(a) " +nomeFun.getText() + " teve um Gasto de R$" +totalDeHorasFormatada+ " de reais sobre as horas trabalhadas" + " e teveum gasto de R$" + gasolinaFormatada + " reais com combustivel");

						System.out.println("O funcionário(a) " + nomeFun.getText() + " teve um Gasto de R$"
								+ totalDeHorasFormatada + " de reais sobre as horas trabalhadas"
								+ " e teve um gasto de R$" + gasolinaFormatada + " reais com combustível");
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(Gastos.this, "Por favor, insira valores numéricos válidos.",
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			gbcHk.gridy = 10;
			panelHk.add(buttonHora, gbcHk);

			add(panelHk, BorderLayout.CENTER);
			revalidate();
			repaint();

		} else {
			System.out.println("<html>KM - para quilometragem<br>Hora - para horas extras<br>HK - para ambos");
		}

	}

	private void limparCamposTexto() {
		nomeFun.setText("");
		hrFuncionario.setText("");
		hrsTrabalhadas.setText("");
		distancia.setText("");
		decisao.setText("");

		decisao.requestFocus();
	}

	public double CalculoDeHoras(double hrFuncionario, double hrsTrabalhadas) {
		double totalDeHoras = hrFuncionario * hrsTrabalhadas;
		return totalDeHoras;
	}

	public double gastoCombustivel(double distancia, double consumoPorLitro, double custoCombustivel) {
		consumoPorKm = distancia / mediaConsumo;
		gasolinaTlGasto = consumoPorKm * custoGasolina;
		return gasolinaTlGasto;
	}

	public static void main(String[] args) {
		new Gastos().setVisible(true);
	}
}
