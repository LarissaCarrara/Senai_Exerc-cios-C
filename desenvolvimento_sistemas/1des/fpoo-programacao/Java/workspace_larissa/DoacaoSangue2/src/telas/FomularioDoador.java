package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.DoadorDAO;
import modelos.Doador;

public class FomularioDoador extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2L;
	JPanel painel;
	JLabel lbNome, lbIdade, lbSexo, lbPeso, lbResult;
	JTextField tfNome, tfIdade, tfSexo, tfPeso;
	JButton btAdicionar, btLimpar;
	JTextArea taResult;
	String saidaTela = "";
	String saidaArquivo = "";
	DoadorDAO dd = new DoadorDAO();

	FomularioDoador() {
		setTitle("Doação de Sangue");
		setBounds(500, 200, 640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel = new JPanel();
		setContentPane(painel);
		setLayout(null);

		lbNome = new JLabel("Nome:");
		lbNome.setBounds(10, 10, 100, 30);
		painel.add(lbNome);

		lbIdade = new JLabel("Idade:");
		lbIdade.setBounds(10, 40, 100, 30);
		painel.add(lbIdade);

		lbSexo = new JLabel("Sexo:");
		lbSexo.setBounds(10, 70, 100, 30);
		painel.add(lbSexo);

		lbPeso = new JLabel("Peso:");
		lbPeso.setBounds(300, 70, 100, 30);
		painel.add(lbPeso);

		tfNome = new JTextField();
		tfNome.setBounds(110, 10, 500, 30);
		painel.add(tfNome);

		tfIdade = new JTextField();
		tfIdade.setBounds(110, 40, 500, 30);
		painel.add(tfIdade);

		tfSexo = new JTextField();
		tfSexo.setBounds(110, 70, 100, 30);
		painel.add(tfSexo);

		tfPeso = new JTextField();
		tfPeso.setBounds(400, 70, 210, 30);
		painel.add(tfPeso);

		lbResult = new JLabel("Resultado:");
		lbResult.setBounds(10, 100, 100, 30);
		painel.add(lbResult);

		btAdicionar = new JButton("Adicionar");
		btAdicionar.setBounds(400, 100, 105, 30);
		painel.add(btAdicionar);
		btAdicionar.addActionListener(this);

		btLimpar = new JButton("Limpar");
		btLimpar.setBounds(505, 100, 105, 30);
		painel.add(btLimpar);
		btLimpar.addActionListener(this);

		taResult = new JTextArea();
		taResult.setBounds(10, 130, 600, 300);
		taResult.setEditable(false);
		painel.add(taResult);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btLimpar) {
			tfNome.setText("");
			tfIdade.setText("");
			tfSexo.setText("");
			tfPeso.setText("");
			taResult.setText("");
		}
		if (e.getSource() == btAdicionar) {
			if (tfNome.getText().length() > 0 && tfIdade.getText().length() > 0 && tfSexo.getText().length() > 0
					&& tfPeso.getText().length() > 0) {
				Doador d = new Doador(tfNome.getText(), tfIdade.getText(), tfSexo.getText(), tfPeso.getText());
				saidaTela += d + "\n";
				saidaArquivo += d.toCSV();	
				taResult.setText(saidaTela);
				dd.salvar(saidaTela);
			
			} else {
				JOptionPane.showMessageDialog(this, "Favor preencher todos os campos");
			}
		}
	}

	public static void main(String[] args) {
		new FomularioDoador().setVisible(true);
	}

}