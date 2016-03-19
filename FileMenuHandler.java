import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener {
	static JFrame jframe;
	public static TextFileInput inFile;
	public FileMenuHandler (JFrame jf) {
		jframe = jf;
	}
	
	public static StringTokenizer myTokens;
	public static PlayerList list = new PlayerList();
	public static PlayerList fielder = new PlayerList();
	public static PlayerList pitcher = new PlayerList();
	
	public void actionPerformed(ActionEvent event) {
		String  menuName;
		menuName = event.getActionCommand();
		if (menuName.equals("Open"))
		openFile( ); 
		else if (menuName.equals("Quit"))
		System.exit(0);
		
	} //actionPerformed
	
	//private
	/**
	 * Uses a JFileChooser to select a file from your computer. Calls on readSource and readFromFile.
	 */
	public void openFile( ) {
		JFileChooser chooser;
		int          status;
		chooser = new JFileChooser( );
		status = chooser.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION) {
		readSource(chooser.getSelectedFile());
		
		readFromFile(FileMenuHandler.inFile);
		}
		else 
		JOptionPane.showMessageDialog(null, "Open File dialog canceled");
	} //openFile
    
	//private
	/**
	 * Reads the chosen file line by line and prints it onto the GUI.
	 * @param chosenFile File that was selected through JFileChooser. Follows its absolute path.
	 */
	private void readSource(File chosenFile) {
		inFile = new TextFileInput(chosenFile.getAbsolutePath());
		String line;
		
		BBPGUI.cPane = jframe.getContentPane();
		BBPGUI.players = new TextArea();
		BBPGUI.cPane.add(BBPGUI.players);

		line = inFile.readLine();
		while (line != null) {
			BBPGUI.players.append(line+"\n");
			line = inFile.readLine();
		} //while
		
		inFile.close();
		inFile = new TextFileInput(chosenFile.getAbsolutePath());
		
		jframe.setVisible(true);  
	}
	
	/**
	 * Reads in and tokenizes each line one by one. Stores in appropriate LinkedList in order by player number.
	 * @param inFile
	 */
	public void readFromFile(TextFileInput inFile){
		String line = inFile.readLine();
		
		while(line != null){
			myTokens = new StringTokenizer(line,",\n");
			
			if((line.charAt(0) == 'P') && (myTokens.countTokens() != 6)){
				System.out.println(line);
				line = inFile.readLine();
				myTokens = new StringTokenizer(line,",\n");
			}
			
			if((line.charAt(0) == 'F') && (myTokens.countTokens() != 5)){
				System.out.println(line);
				line = inFile.readLine();
				myTokens = new StringTokenizer(line,",\n");
			}
			
			/*if((line.charAt(0) != 'P') || (line.charAt(0) != 'F')){
				System.out.println(line);
				line = inFile.readLine();
				myTokens = new StringTokenizer(line,",\n");
			}*/
			
			while(myTokens.hasMoreTokens()){
				String position = myTokens.nextToken();

				if (position.equals("P")){
					int b = Integer.parseInt(myTokens.nextToken());
					String c = myTokens.nextToken();
					String d = myTokens.nextToken();
					Float e = Float.parseFloat(myTokens.nextToken());
					float f = Float.parseFloat(myTokens.nextToken()); 
					try{
						Pitcher p = new Pitcher(b,c,d,e,f);
						list.insertPlayer(p);
						Pitcher pSorted = new Pitcher(b,c,d,e,f);
						pitcher.insertPlayer(pSorted);
					}
					catch (IllegalPlayerException ipe){
						System.out.println(line);
					}
				}//if close
				
				if (position.equals("F")){
					int b = Integer.parseInt(myTokens.nextToken());
					String c = myTokens.nextToken();
					String d = myTokens.nextToken();
					Float e = Float.parseFloat(myTokens.nextToken());
					try{
						Fielder f = new Fielder(b,c,d,e);
						list.insertPlayer(f);
						Fielder fSorted = new Fielder(b,c,d,e);
						fielder.insertPlayer(fSorted);
					}
					catch (IllegalPlayerException ipe){
						System.out.println(line);
					}
				}//if close
				
			}//while close
			
			line = inFile.readLine();
		}//while close
		
		inFile.close();
	}
}