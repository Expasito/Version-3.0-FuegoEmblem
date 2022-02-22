package main;

import java.util.ArrayList;

import Stage.*;

public class Main {
	
	public static int blockSize=48;
	public static int cols=40;
	public static int rows=15;
	public static int dataDisHeight = 300;
	public static int screenWidth=blockSize*cols;
	public static int screenHeight=blockSize*rows+dataDisHeight;
	public static int battleHeight=blockSize*rows;
	public static ArrayList<Stage> stages = new ArrayList<Stage>();
	public static Frame frame = new Frame();
	
	public static void main(String[] args) throws InterruptedException {
		Stage1 stage1 = new Stage1();
		Stage2 stage2 = new Stage2();
		Stage3 stage3 = new Stage3();
		stages.add(stage1);
		stages.add(stage2);
		stages.add(stage3);
		stages.add(stage1);
		stages.add(stage2);
		stages.add(stage3);
		stages.add(stage1);
		stages.add(stage2);
		stages.add(stage3);
		
		TitleScreen title = new TitleScreen();
		frame.add(title);
		while(!title.close) {
//			title.repaint();
			System.out.println(title.close);
		}
		frame.remove(title);
		frame.repaint();
		System.out.println("heere");
		LevelSelection levelSelection = new LevelSelection();
		frame.add(levelSelection);
		while(!levelSelection.selected) {
			levelSelection.repaint();
			Thread.sleep(10);
//			System.out.println("here");
		}
		frame.remove(levelSelection);
		frame.repaint();
		BattleScreen battleScreen = new BattleScreen(stages.get(levelSelection.cursor));
		DataScreen dataScreen = new DataScreen();
		frame.add(battleScreen);
		frame.add(dataScreen);
		while(!battleScreen.finished) {
			
			Thread.sleep(10);
			battleScreen.repaint();
			dataScreen.repaint();
//			System.out.println("here2");
		}
	}

}
