/**
 * Within this class i will be making the Enigma 
 * I will also be adding graphical user interface (GUI) for the ease of use 
 * @author Parth Sharma
 *
 */

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class EnigmaGUI extends JFrame {

	private Enigma enigma;

	public EnigmaGUI() {

		getContentPane().setBackground(UIManager.getColor(""));
		initialize();
	}

	// JLabels Initialization 

	private JLabel lblAuthor = new JLabel("By Parth Sharma U1559939");
	private JLabel lblWwiiEnigmaMachine = new JLabel("WWII Enigma Machine Simulator");
	private JLabel lblIMessage = new JLabel("Input Message");
	private JLabel lblOMessage = new JLabel("Output Message");
	private JLabel lblPlugboardSettings = new JLabel("Plugboard Settings");
	private JLabel lblLeftRotor = new JLabel("Left Rotor");
	private JLabel lblMiddleRotor = new JLabel("Middle Rotor");
	private JLabel lblRightRotor = new JLabel("Right Rotor");
	private JLabel lblRotorSettings = new JLabel("Rotor Settings");
	private JLabel lblStartingPositionL = new JLabel("Starting Position L R:");
	private JLabel lblStartingPositionM = new JLabel("Starting Position M R:");
	private JLabel lblStartingPositionR = new JLabel("Starting Position R R:");
	private JLabel lblChooseReflector = new JLabel("Choose Reflector");
	private JLabel lblReflectorType = new JLabel("Reflector Type:");
	private JLabel lblPlugExplanation = new JLabel("Please enter the Plugboard Settings below (E.G AB, CD, EF...etc)");

	// JSpinner Initialization 

	private JSpinner spinnerLR = new JSpinner();
	private JSpinner spinnerMR = new JSpinner();
	private JSpinner spinnerRR = new JSpinner();

	// JComboBox Initialization 

	private JComboBox comboBoxStartPosL = new JComboBox();
	private JComboBox comboBoxStartPosM = new JComboBox();
	private JComboBox comboBoxStartPosR = new JComboBox();
	private JComboBox comboBoxReflector = new JComboBox();
	
	//JButtons

	private JButton btnConfiguration = new JButton("Configuration");
	private JButton btnReset = new JButton("Reset");
	private JButton btnEncrypt = new JButton("Encrypt");
	private JButton btnDecrypt = new JButton("Decrypt");

	// JTextFields Initialization 

	private JTextField textFieldInput;
	private final JTextField textFieldOutput = new JTextField();
	private JTextField textFieldPlugboardSetting;



	private void initialize() {

		//Making the Enigma GUI

		getContentPane().setLayout(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		enigma = new Enigma(Enigma.I, Enigma.II, Enigma.III, Enigma.B);

		//Creating the graphical parts of the Enigma 

		// JLabels

		lblAuthor.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAuthor.setBounds(10, 543, 259, 17);
		getContentPane().add(lblAuthor);
		
		lblWwiiEnigmaMachine.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWwiiEnigmaMachine.setBounds(260, 11, 274, 20);
		getContentPane().add(lblWwiiEnigmaMachine);
		
		lblIMessage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIMessage.setBounds(351, 315, 91, 14);
		getContentPane().add(lblIMessage);
		
		lblOMessage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOMessage.setBounds(342, 393, 110, 14);
		getContentPane().add(lblOMessage);

		lblPlugboardSettings.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPlugboardSettings.setBounds(10, 222, 125, 14);
		getContentPane().add(lblPlugboardSettings);

		lblLeftRotor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLeftRotor.setBounds(20, 75, 68, 14);
		getContentPane().add(lblLeftRotor);

		lblMiddleRotor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMiddleRotor.setBounds(235, 75, 68, 14);
		getContentPane().add(lblMiddleRotor);

		lblRightRotor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRightRotor.setBounds(450, 75, 68, 14);
		getContentPane().add(lblRightRotor);

		lblRotorSettings.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRotorSettings.setBounds(10, 43, 110, 14);
		getContentPane().add(lblRotorSettings);

		lblStartingPositionL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStartingPositionL.setBounds(20, 118, 125, 14);
		getContentPane().add(lblStartingPositionL);

		lblStartingPositionM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStartingPositionM.setBounds(235, 118, 125, 14);
		getContentPane().add(lblStartingPositionM);

		lblStartingPositionR.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStartingPositionR.setBounds(450, 118, 125, 14);
		getContentPane().add(lblStartingPositionR);

		lblChooseReflector.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChooseReflector.setBounds(10, 158, 110, 14);
		getContentPane().add(lblChooseReflector);

		lblReflectorType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReflectorType.setBounds(20, 183, 91, 14);
		getContentPane().add(lblReflectorType);

		lblPlugExplanation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPlugExplanation.setBounds(20, 247, 375, 17);
		getContentPane().add(lblPlugExplanation);

		// JSpinner

		spinnerLR.setBounds(98, 73, 29, 20);
		spinnerLR.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		getContentPane().add(spinnerLR);

		spinnerMR.setBounds(313, 73, 29, 20);
		spinnerMR.setModel(new SpinnerNumberModel(2, 1, 5, 1));
		getContentPane().add(spinnerMR);

		spinnerRR.setBounds(528, 73, 29, 20);
		spinnerRR.setModel(new SpinnerNumberModel(3, 1, 5, 1));
		getContentPane().add(spinnerRR);

		// JComboBox
		
		comboBoxStartPosL.setModel(new DefaultComboBoxModel(new String [] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
		comboBoxStartPosL.setSelectedIndex(0);
		comboBoxStartPosL.setMaximumRowCount(26);
		comboBoxStartPosL.setBounds(144, 115, 41, 20);
		getContentPane().add(comboBoxStartPosL);

		comboBoxStartPosM.setModel(new DefaultComboBoxModel(new String [] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
		comboBoxStartPosM.setSelectedIndex(0);
		comboBoxStartPosM.setMaximumRowCount(26);
		comboBoxStartPosM.setBounds(359, 115, 41, 20);
		getContentPane().add(comboBoxStartPosM);

		comboBoxStartPosR.setModel(new DefaultComboBoxModel(new String [] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
		comboBoxStartPosR.setSelectedIndex(0);
		comboBoxStartPosR.setMaximumRowCount(26);
		comboBoxStartPosR.setBounds(571, 115, 41, 20);
		getContentPane().add(comboBoxStartPosR);

		comboBoxReflector.setModel(new DefaultComboBoxModel(new String[] {"B", "C"}));
		comboBoxReflector.setSelectedIndex(0);
		comboBoxReflector.setBounds(121, 181, 41, 20);
		getContentPane().add(comboBoxReflector);

		// JTextFields

		textFieldInput = new JTextField();
		textFieldInput.setBounds(10, 340, 774, 42);
		getContentPane().add(textFieldInput);
		
		textFieldInput.setColumns(10);
		textFieldOutput.setEditable(false);
		textFieldOutput.setColumns(10);
		textFieldOutput.setBounds(10, 418, 774, 42);
		getContentPane().add(textFieldOutput);

		

		textFieldPlugboardSetting = new JTextField();
		textFieldPlugboardSetting.setColumns(10);
		textFieldPlugboardSetting.setBounds(10, 275, 481, 26);
		getContentPane().add(textFieldPlugboardSetting);
		
		//Buttons

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetEnigma();
			}
		});
		btnReset.setBounds(619, 500, 89, 23);
		getContentPane().add(btnReset);

		btnEncrypt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String input = textFieldInput.getText().toUpperCase().toString().trim();
				String finalOutput = enigma.inputText(input).trim();

				textFieldOutput.setText(finalOutput);

			}
		});
		btnEncrypt.setBounds(86, 500, 89, 23);
		getContentPane().add(btnEncrypt);

		btnDecrypt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String input = textFieldInput.getText().toUpperCase().toString().trim();
				String finalOutput = enigma.inputText(input).trim();

				textFieldOutput.setText(finalOutput);

			}
		});
		btnDecrypt.setBounds(261, 500, 89, 23);
		getContentPane().add(btnDecrypt);
		
		btnConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldInput.setText("");
				textFieldOutput.setText("");
				getPlugboard();
				LRStart();
				RRStart();
				MRStart();
				reflectorSelected();
			}
		});
		btnConfiguration.setBounds(423, 500, 110, 23);
		getContentPane().add(btnConfiguration);

	}

	//Setting values

	public void LRStart() {

		int LR = (int) spinnerLR.getValue();

		String LRStart = comboBoxStartPosL.getSelectedItem().toString();

		char LRStartChar = LRStart.charAt(0);

		// Select Left Rotor

		if (LR == 1) {

			enigma.getSlowRotor().setRotor(Enigma.I);
		} 

		else if (LR == 2) {

			enigma.getSlowRotor().setRotor(Enigma.II);
		}

		else if (LR == 3) {

			enigma.getSlowRotor().setRotor(Enigma.III);
		} 

		else if (LR == 4) {

			enigma.getSlowRotor().setRotor(Enigma.IV);

		} 

		else if (LR == 5) {

			enigma.getSlowRotor().setRotor(Enigma.V);
		} 

		else {

			System.out.println("ERROR");
		}

		enigma.getSlowRotor().setRotorHead(LRStartChar);
	}


	public void RRStart() {

		int RR = (int) spinnerRR.getValue();

		String RRStart = comboBoxStartPosR.getSelectedItem().toString();

		char RRStartChar = RRStart.charAt(0);

		// Select Right Rotor

		if (RR == 1) {

			enigma.getFastRotor().setRotor(Enigma.I);
		} 

		else if (RR == 2) {

			enigma.getFastRotor().setRotor(Enigma.II);
		}

		else if (RR == 3) {

			enigma.getFastRotor().setRotor(Enigma.III);
		} 

		else if (RR == 4) {

			enigma.getFastRotor().setRotor(Enigma.IV);

		} 

		else if (RR == 5) {

			enigma.getFastRotor().setRotor(Enigma.V);
		} 

		else {

			System.out.println("ERROR");
		}

		enigma.getFastRotor().setRotorHead(RRStartChar);
	}


	public void MRStart() {

		int MR = (int) spinnerMR.getValue();

		String MRStart = comboBoxStartPosM.getSelectedItem().toString();

		char MRStartChar = MRStart.charAt(0);

		// Select Middle Rotor

		if (MR == 1) {

			enigma.getMediumRotor().setRotor(Enigma.I);
		} 

		else if (MR == 2) {

			enigma.getMediumRotor().setRotor(Enigma.II);
		}

		else if (MR == 3) {

			enigma.getMediumRotor().setRotor(Enigma.III);
		} 

		else if (MR == 4) {

			enigma.getMediumRotor().setRotor(Enigma.IV);

		} 

		else if (MR == 5) {

			enigma.getMediumRotor().setRotor(Enigma.V);
		} 

		else {

			System.out.println("ERROR");
		}

		enigma.getMediumRotor().setRotorHead(MRStartChar);
	}

	// Choose Reflectgor

	public void reflectorSelected() {

		int reflector = comboBoxReflector.getSelectedIndex();

		if (reflector == 0) {

			enigma.getReflector().setReflector(enigma.B);
		} 

		else {

			enigma.getReflector().setReflector(enigma.C);
		}

	}

	public void getPlugboard() {

		enigma.resetPlugboard();
		Scanner scan = new Scanner(textFieldPlugboardSetting.getText());

		while(scan.hasNext()) {

			String wire = scan.next();

			if(wire.length() == 2) {

				char from = wire.charAt(0);
				char to = wire.charAt(1);

				if(!enigma.isPlugged(from) && !enigma.isPlugged(to) && from != to)

					enigma.plugboardWire(from, to);
			}
		}
		scan.close();
	}

	// Reset the Enigma Simulator 

	public void resetEnigma() {

		enigma.restart();
		enigma.resetPlugboard();

		textFieldPlugboardSetting.setText("");
		textFieldInput.setText("");
		textFieldOutput.setText("");
	}
}

