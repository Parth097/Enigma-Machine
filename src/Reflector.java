/**
 * Within this class i will be dealing with the reflectors which i have implemented wihtin the enigma.
 * @author Parth Sharma
 *
 */

public class Reflector {
	
	private int rotorOutput[] = new int[26];
	

	protected Reflector(String reflector) {
	
		this.setReflector(reflector);
	}
	
	protected int getOutput(int position) {
		
		int outputIndex = ((position + rotorOutput[position]) % 26);
		
		return outputIndex;
	}
	
	public int getOutputWire(int position) {
		
		return (rotorOutput[position] + position ) % 26;
	}
	
	// take a string of characters for the reflector, which will then be used to configure and map on character with another
	
	public void setReflector(String reflector) {
		
		for (int i = 0; i < 26; i++) {

			int from = (char) ('A' + i);
			
 			int to = reflector.charAt(i);
	
			if (from<to) {
		
				rotorOutput[i] = (to-from);
			} 
			
			else{
				
				rotorOutput[i] = (26-(from-to))%26;
			}
		}
	}
}
