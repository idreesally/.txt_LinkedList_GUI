import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

public class DisplayMenuHandler implements ActionListener{
	JFrame jframe;
	
	
	
	public DisplayMenuHandler (JFrame jf) {
		jframe = jf;
		
	}

	public void actionPerformed(ActionEvent event) {
		String  menuName;
		menuName = event.getActionCommand();
		
		if (menuName.equals("All")){
			BBPGUI.players.setText(FileMenuHandler.list.toString());
		}
	
		if (menuName.equals("Fielders")){
			BBPGUI.players.setText(FileMenuHandler.fielder.toString());
		}
		
		if(menuName.equals("Pitchers")){
			BBPGUI.players.setText(FileMenuHandler.pitcher.toString());
		}
		
		jframe.setVisible(true);
	} //actionPerformed
}