package main;

import javax.swing.JPanel;

import Stage.*;

import java.awt.*;

public class LevelSelection extends JPanel {
	public static int cursor=0;
	public static boolean selected=false;
	public LevelSelection() {
		setVisible(true);
		setSize(Main.screenWidth,Main.screenHeight);
		setLocation(0,0);
	}
	public void paint(Graphics g) {
		g.clearRect(0, 0, 500, 500);
		g.drawString("Select a Map:",30,50);
		int counter=0;
		for(Stage s:Main.stages) {
			counter++;
			g.drawString(s.number + ". " + s.name, 50, 50+(20*counter));
			
		}
		g.setColor(Color.yellow);
		g.fillRect(30,40+((cursor+1)*20),10,10);
	}

}
