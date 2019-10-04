/**
 * Within this class i will be linking together 2 of the most important classes of the enigma simulator.
 * Firstly the Rotor class, which contains all the information about the rotors.
 * Secondly the reflector class which has the information about the different reflectors. 
 * This class will also contain the main algorithm for the enigma simulator. 
 * @author Parth Sharma
 *
 */

public class Enigma {
	
	//Rotors
	
	private Rotor fastRotor; // fast rotor of the enigma machine (Right Rotor)
	private Rotor mediumRotor; // medium rotor of the enigma machine (Middle Rotor)		
	private Rotor slowRotor; // slow rotor of the enigma machine (Left Rotor)
	private Reflector reflector; // the reflector of the enigma machin
	private int[] plugboard; // the plugboard of the machine

	// Rotor Substitutions 
	
	public static final String[] I = {"EKMFLGDQVZNTOWYHXUSPAIBRCJ", "Q"};
	public static final String[] II = {"AJDKSIRUXBLHWTMCQGZNPYFVOE", "E"};
	public static final String[] III = {"BDFHJLCPRTXVZNYEIWGAKMUSQO", "V"};
	public static final String[] IV = {"ESOVPZJAYQUIRHXLNFTGKDCMWB", "J"};
	public static final String[] V = {"VZBRGITYUPSDNHLXAWMJQOFECK", "Z"};

	//Reflector options
	
	public static final String B = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
	public static final String C = "FVPJIAOYEDRZXWGCTKUQSBNMHL";
	
	//Enigma Constructor
	
	public Enigma(String[] slow,String[] medium,String[] fast,String reflector){
		
	//Rotor subsitutions string, as well as the notch value
		
	this.slowRotor = new Rotor(slow[0], slow[1].charAt(0)); 
	this.mediumRotor = new Rotor(medium[0], medium[1].charAt(0)); 
	this.fastRotor = new Rotor(fast[0], fast[1].charAt(0)); 
	this.reflector = new Reflector(reflector); 
		
	//Initialize Plugboard
	this.plugboard = new int [26];
	
	resetPlugboard();
	}
	
	//The method below will allow me to encrypt every character within a string the user enters
	public String inputText (String inputText) {
		String output = ""; //Storing the string
		
		// for loop for all the characters within the entered string
		
		for (int i=0; i < inputText.length(); i++) {
			
			if (inputText.charAt(i) >= 'A' && inputText.charAt(i) <= 'Z') {
				
				//Characters go through the encryption method, and displayed on the output box
				
				output += encrypt(inputText.charAt(i));
			}
			
			//ignoring any spaces and new lines
			
			else if (inputText.charAt(i) == ' ' || inputText.charAt(i) == '\n') {
				output += inputText.charAt(i);
			}
			
			// Show error message if other characters have been input
			
			else {
				throw new RuntimeException ("Error: Please enter onmly capital letters");
			}
		}
		
		return output;
	}
	
	// Encryption method
	
	private char encrypt (char c) {
		
		//Rotate the fast rotor each time a character passes through
		
		fastRotor.rotate();
		
		//rotate the middle rotor if the notch is in position
		
		if (fastRotor.getRotorNotch() == fastRotor.getRotorHead()) {
			
			mediumRotor.rotate();
		}
		
		//rotate the slow rotor if the notch is in position
		
		if (mediumRotor.getRotorNotch() == mediumRotor.getRotorHead()) {
			
			slowRotor.rotate();
			mediumRotor.rotate();
		}
		
		// static wheel will be mapping the characters in an integer
		
		int input = c - 'A';
		
		//Check to see if the plugboard is in use
		
		if (plugboard [input] != -1) {
			
			input = plugboard [input];
		}
		
		int outputFastRotor = fastRotor.getOutputIndexInput(input); //index of right rotor
		int outputMediumRotor = mediumRotor.getOutputIndexInput(outputFastRotor); // index of middle rotor
		int outputSlowRotor = slowRotor.getOutputIndexInput(outputMediumRotor);//index of left rotor
		
		// reflector is used to output the index of the left rotor, allowing the reflected character to be output
		
		int outputReflector = reflector.getOutput(outputSlowRotor);
		
		int inputSlowRotor = slowRotor.getInputIndexOutput(outputReflector); // index of output index of the right rotor
		int inputMediumRotor = mediumRotor.getInputIndexOutput(inputSlowRotor); // index of output index of the left rotor
		int inputFastRotor = fastRotor.getInputIndexOutput(inputMediumRotor); // index of output index of the middle rotor

		//Check to see if the plugboard is connected
		
		if (plugboard [inputFastRotor] != -1) {
			inputFastRotor = plugboard[inputFastRotor];
		}
		
		char encryptedChar = (char) (inputFastRotor + 'A');
		
		return encryptedChar;
	}
	
	public Rotor getSlowRotor () {
		return slowRotor;
	}
	
	public Rotor getMediumRotor () {
		return mediumRotor;
	}
	
	public Rotor getFastRotor () {
		return fastRotor;
	}
	
	public Reflector getReflector () {
		return reflector;
	}
	
	// creating plugboard wires
	
	public void plugboardWire (char X, char Y) {
		
		this.plugboard [X - 'A'] = Y - 'A';
		
		this.plugboard[ Y - 'A' ] = X - 'A';
	}
	
	public int getPlugboardOf(int a) {
		
		return this.plugboard[a];
	}
	
	// reset the plugboard 
	
	public void resetPlugboard() {
		
		for (int wire = 0; wire < 26; wire++)
			
			this.plugboard[ wire ] = -1;
	}
	
	public boolean isPlugged(char c) {
		
		return plugboard[c - 'A'] != -1;
	}
	
	// reset enigma simulator 
	
	public void restart( ){
		
		slowRotor.reset();
		
		mediumRotor.reset();
		
		fastRotor.reset();
	}
	
}
