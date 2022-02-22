package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends JPanel {
	public static ArrayList<Integer> targets = new ArrayList<Integer>();
	File fil = new File("src/Main/VillagerPortrait.png");
	BufferedImage img=null;
	
	public Panel() throws IOException {
		setVisible(true);
		setLocation(0,0);
		setSize(500,500);
		img = ImageIO.read(fil);
	}
	
	public void paint(Graphics g) {
		
		g.clearRect(0,0,500,500);
		g.drawImage(img, 100, 100,null);
		g.setColor(Color.black);
		for(int i=0;i<20;i++) {
			g.drawLine(0, i*48, 1000, i*48);
			g.drawLine(i*48, 0, i*48, 1000);
		}
//		g.drawString("hello", 100,100);
		if(Main.cur==0) {
//			g.setColor(Color.red);
		}else if(Main.cur==1) {
//			g.setColor(Color.green);
		}
//		g.setColor(Color.black);
		for(Square sq: Main.entities) {
			g.fillRect(sq.x,sq.y,sq.size,sq.size);
//			System.out.println(sq.x+ " " + sq.y);
		}
		if(Main.confirm) {
			targets.clear();
//			System.out.println("hello we just started the loop");
			for(int i=0;i<Main.entities.get(Main.index).range.size();i++) {
				for(int j=0;j<Main.entities.size();j++) {
					System.out.println("I: " + Main.entities.get(Main.index).range.get(i) + " "+Math.abs(Main.entities.get(j).x-Main.entities.get(Main.index).x) + "  " + Math.abs(Main.entities.get(j).y-Main.entities.get(Main.index).y));
					if(j!=Main.index && Math.abs(Main.entities.get(j).x-Main.entities.get(Main.index).x)<=Main.entities.get(Main.index).range.get(i)*48 && Math.abs(Main.entities.get(j).y-Main.entities.get(Main.index).y)<=Main.entities.get(Main.index).range.get(i)*48) {
						targets.add(j);
//						Square sq = Main.entities.get(j);
//						g.setColor(Color.orange);
//						g.fillRect(sq.x,sq.y,sq.size-10,sq.size-10);
//						System.out.println("hello this worked "+ Main.entities.get(j).x/48 + " " +Main.entities.get(j).y/48);
					}
				}
			}
			ArrayList<Integer> fixedTargets = new ArrayList<Integer>();
			for(Integer i :targets) {
				if(!fixedTargets.contains(i)) {
					fixedTargets.add(i);
				}
			}
			targets=fixedTargets;
			System.out.println("\n\n");
			for(int i=0;i<targets.size();i++) {
				Square sq = Main.entities.get(targets.get(i));
				g.setColor(Color.orange);
				if(i==Main.cur) {
					g.setColor(Color.pink);
				}
				g.fillRect(sq.x,sq.y,sq.size-10,sq.size-10);
//				System.out.println(sq.x+" "+sq.y);
			}

		}
		
		if(Main.nextAction) {
			g.setColor(Color.black);
			g.drawString("Select Action:",100,100);
			g.drawString("Attack",120,120);
			g.drawString("Wait",120,140);
			g.setColor(Color.yellow);
			g.fillRect(100,110+Main.cur*20,10,10);
		}
	}

}
