package main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Entity.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class DataScreen extends JPanel {
	Font f = new Font("Serrif",Font.PLAIN,15);
	File file = new File("src/Villager.png");
	BufferedImage img = null;
	public DataScreen() {
		setVisible(true);
		setSize(Main.screenWidth+500,Main.dataDisHeight);
		setLocation(0,Main.battleHeight+1);
		
		try {
			img=ImageIO.read(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		}
	}
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.setFont(f);
		g.fillRect(0,0,Main.screenWidth,Main.dataDisHeight);
		g.setColor(Color.black);
		g.drawLine(400,0,400,500);
		Entity e = null;
		if(BattleScreen.selected || BattleScreen.nextAction) {
			e=BattleScreen.stage.entities.get(BattleScreen.index);
		}else {
			
			for(int i=0;i<BattleScreen.stage.entities.size();i++) {
				if(BattleScreen.stage.entities.get(i).x==BattleScreen.gridX && BattleScreen.stage.entities.get(i).y==BattleScreen.gridY) {
					e=BattleScreen.stage.entities.get(i);
					break;
				}
			}
		}
		//e!=null
		if(e!=null) {
			g.setColor(Color.white);
			g.drawImage(img,48,12,null);
			g.drawString("Name: " + e.name,48,12+24+96);
			g.drawString("Lvl:" + e.lvl, 48, 132+24);
			g.drawString("Atk: "+ (int)(e.str+e.weapon.mgt),48*4,24);
			g.drawString("Hit: "+ (int)(e.skl*5+e.weapon.hit),48*4,48);
			g.drawString("As: "+ (int)(e.spd-e.weapon.wght),48*4,48+24);
			g.drawString("Avo: "+ (int)((e.spd+e.skl)*2),48*4,96);
			g.drawString("Crit: "+ ((int)(e.lck+e.skl)/2+e.weapon.crit),48*4,96+24);
			g.drawString("Crit Avo: "+ (int)(e.lck),48*4,96+48);
			if(e.weapon.close-e.weapon.far==0) {
				g.drawString("Rng: "+ (e.weapon.close),48*4,96+48+24);
			}else {
				g.drawString("Rng: "+ (e.weapon.close+ "-"+e.weapon.far),48*4,96+48+24);
			}
//			
			g.drawString("Str: " + (int)e.str, 48,132+24+24);
			g.drawString("Skl: " + (int)e.skl, 48,132+24+24+24);
			g.drawString("Dfns: " + (int)e.dfns, 48,132+24+24+24+24);
			g.drawString("Lck: " + (int)e.lck, 48,132+24+24+24+24+24);
		}
		if(BattleScreen.nextAction) {
			g.setColor(Color.black);
			g.drawString("Actions:",700,40);

		}
		
		
		
		
		
	}

}
