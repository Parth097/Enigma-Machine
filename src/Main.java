/**
 * Within this class i will be launching the EnigmaGUI class
 * This will be the main class 
 * @author Parth Sharma
 *
 */

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Setting integers for height and width of the main frame (GUI)
		int Width = 800;
		int Height = 600;

		//Initializing the main GUI		
		EnigmaGUI window = new EnigmaGUI();
		window.setTitle("Enigma Simulator");
		window.setVisible(true);
		window.setSize(Width, Height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
