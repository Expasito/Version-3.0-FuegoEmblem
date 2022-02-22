package main;

import javax.swing.*;

import Entity.Entity;

import java.awt.event.*;

public class Frame extends JFrame implements KeyListener, MouseListener {
	public static int width=Main.screenWidth;
	public static int height = Main.screenHeight;
	
	public Frame() {
		addKeyListener(this);
		addMouseListener(this);
		
		setSize(width+17,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setUndecorated(true);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		if(e.getKeyChar()==' ') {
//			TitleScreen.close=true;
//		}
		if(e.getKeyChar()=='s') {
			if(LevelSelection.cursor<Main.stages.size()-1) {
				LevelSelection.cursor++;
			}
			

		}
		if(e.getKeyChar()=='w') {
			if(LevelSelection.cursor>0) {
				LevelSelection.cursor--;
			}
			

		}
		if(e.getKeyChar() == ' ') {
			if(TitleScreen.close) {
				LevelSelection.selected=true;
			}else {
				TitleScreen.close=true;
			}
			if(BattleScreen.nextAction) {
				BattleScreen.nextAction=false;
			}
			
		}
		//if esc key, just leave the program
		if(e.getKeyChar() == 27) {
			System.exit(0);
		}
		System.out.println(e.getKeyChar());
		if(e.getKeyChar()=='f') {
			if((BattleScreen.selected || BattleScreen.nextAction)&& BattleScreen.index!=-1) {
				BattleScreen.stage.entities.get(BattleScreen.index).x=BattleScreen.selX;
				BattleScreen.stage.entities.get(BattleScreen.index).y=BattleScreen.selY;
			}
			BattleScreen.selected=false;
			BattleScreen.nextAction=false;
			BattleScreen.index=-1;
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("here)");

		if(BattleScreen.selected) {
			BattleScreen.selected=false;
			BattleScreen.nextAction=true;
		}else if(!BattleScreen.nextAction){
			BattleScreen.selected=false;
			for(int i=0;i<BattleScreen.stage.entities.size();i++) {
				Entity sq = BattleScreen.stage.entities.get(i);
				System.out.println(sq.y + " "+ BattleScreen.gridY);
				if(BattleScreen.gridY==sq.y && BattleScreen.gridX==sq.x) {
					BattleScreen.selected=true;
					BattleScreen.index=i;
					BattleScreen.selX=sq.x;
					BattleScreen.selY=sq.y;
					System.out.println("hello this right here works perfeclty andkflajnkdlsf;a ");

					break;
				}
			}
			
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
