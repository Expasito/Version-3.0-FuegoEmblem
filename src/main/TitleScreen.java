package main;

import javax.swing.*;
import java.awt.*;

public class TitleScreen extends JPanel {
	public Font titleFont = new Font(Font.SERIF,Font.PLAIN, 80);
	public static boolean close=false;
	public TitleScreen() {
		setVisible(true);
		setSize(Main.screenWidth,Main.screenHeight);
		setLocation(0,0);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.setFont(titleFont);
		g.drawString("Fuego Emblem",Main.screenWidth/2-(6*80/2),Main.screenHeight/2 - 40);
		g.setColor(Color.blue);
//		g.fillRect(0,0,200,100);
		
	}

}
