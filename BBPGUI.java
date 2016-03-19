import javax.swing.*;

import java.awt.*;

public class BBPGUI extends JFrame{
	
	public static Container cPane;
	public static TextArea players = new TextArea();
	
	public JMenuBar    menuBar  = new JMenuBar();
	/**
	 * Creats GUI based on title, height and width passed in from main program.
	 * @param title Title of GUI
	 * @param height Height of GUI
	 * @param width Width of GUI
	 */
	public BBPGUI(String title, int height, int width) {
		setTitle(title);
		setSize(height,width);
		setLocation  (400,200);
		createFileMenu();
		createDisplayMenu();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	} //SSNGUI

	private void createFileMenu( ) {
		JMenuItem   item;
		
		JMenu       fileMenu = new JMenu("File");
		FileMenuHandler fmh  = new FileMenuHandler(this);

		item = new JMenuItem("Open");    //Open...
		item.addActionListener( fmh );
		fileMenu.add( item );

		fileMenu.addSeparator();           //add a horizontal separator line
	
		item = new JMenuItem("Quit");       //Quit
		item.addActionListener( fmh );
		fileMenu.add( item );

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
	} 
	
	private void createDisplayMenu( ) {
		JMenuItem   item;
		
		JMenu       fileMenu = new JMenu("Display");
		DisplayMenuHandler fmh  = new DisplayMenuHandler(this);

		item = new JMenuItem("All");    //All...
		item.addActionListener( fmh );
		fileMenu.add( item );

		fileMenu.addSeparator();           //add a horizontal separator line
	
		item = new JMenuItem("Fielders");       //Fielders
		item.addActionListener( fmh );
		fileMenu.add( item );
		
		fileMenu.addSeparator();           //add a horizontal separator line
		
		item = new JMenuItem("Pitchers");       //Pitchers
		item.addActionListener( fmh );
		fileMenu.add( item );

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
	} 
	
}
