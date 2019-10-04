/**
 * Within this class i will be dealing with the rotors part of the Enigma. 
 * @author Parth Sharma
 *
 */

public class Rotor {
	
	private	int rotorOutput[] = new int[26]; // Output
	private int rotorInput[] = new int[26]; // Input
	private int rotorHead; // Starting Position
	private int ringHead; 
	private char notch; // Turning point of each rotor
	private int rotate; // Rotating the rotor      
	

	public Rotor(String rotor,char notch) {
		
		this.setRotor(new String [] {rotor, notch+""}); 
	}

	//input index of a character is parsed through the method, giving the output index
	
	public int getOutputIndexInput(int pos) {
		
		int rotorRingDifference;
		
		if (rotorHead >= ringHead) {
	
			rotorRingDifference = rotorHead - ringHead; 
			} 
		
		else {
	
			rotorRingDifference = (26- ringHead + rotorHead);
		}
		
		int indexOutput = (pos + rotorOutput[(pos + rotate + rotorRingDifference) % 26]) % 26;
		
		return indexOutput;
	}
	

	public int getInputIndexOutput(int position) {
	
		int rotorRingDifference;
		int positionJump;

		if (rotorHead >= ringHead) {

			rotorRingDifference = rotorHead - ringHead;
		} 
		
		else {
	
			rotorRingDifference = (26 - ringHead + rotorHead);
		}
		
		positionJump = position - rotorInput [(position + rotate + rotorRingDifference) % 26];
		
		if (positionJump > 0) {
			
			return (positionJump % 26);
		} 
		
		else {

			return ((26 + positionJump) % 26);
		}
	}
	
	// Return the Notch
	
	public char getRotorNotch() {
		
		return notch;
	}
	
	public char getRotorHead(){

		char rotorHeadTaken = (char) ('A' + (rotorHead + rotate) % 26);
		
		return rotorHeadTaken;
	}
	
	//Rotate the rotor by 1
	
	public void rotate() {

		rotate = (rotate + 1) % 26;
	}
	
	public void setRotorHead(char inputHead) {
		
		if(inputHead < 'A' || inputHead > 'Z') {
			
			System.out.println("Error: Please use only capital letters");
		}
		
		rotorHead = inputHead - 'A';
		
		rotate = 0;
	}
	
	// Setting the rotor according to the given array by the user, by using the ASCII values of the character
	
	public void setRotor(String[] rotor) {
		
		this.notch = rotor[1].charAt(0);

		for (int i = 0; i < 26; i++){

			int from = (char) ('A' + i);

			int to = rotor[0].charAt(i);

			if(from<to) {
				
				rotorOutput[i] = to - from;
				
			}
			
			else {
				
				rotorOutput[i] = (26-(from-to) %26);
			}
			
			rotorInput[ (i + rotorOutput[i]) % 26] = rotorOutput[i];
		}
	}
	
	//reset the rotors
	
	public void reset() {
		
		rotate = 0;
	}
	
	public static void main(String[] args) {

		String[] I = {"EKMFLGDQVZNTOWYHXUSPAIBRCJ", "Q"};
		
		String[] II = {"AJDKSIRUXBLHWTMCQGZNPYFVOE", "E"};
		
		String[] III = {"BDFHJLCPRTXVZNYEIWGAKMUSQO", "V"};
		
		Rotor rotor = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'B');
		
		rotor.setRotor(I);
		
		System.out.println(rotor.getInputIndexOutput(4));
		System.out.println(rotor.getOutputIndexInput(0));

	}
}
