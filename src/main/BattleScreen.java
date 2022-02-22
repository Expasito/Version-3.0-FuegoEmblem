package main;

import javax.swing.JPanel;

import Entity.*;
import Stage.Stage;
import functions.*;
import java.awt.*;
import java.util.ArrayList;

public class BattleScreen extends JPanel {
	public static boolean selected=false;
	public static boolean nextAction=false;
	public static int selX=0,selY=0;
	public static int index=-1;
	public static boolean finished=false;
	public static Stage stage;
	public static Entity hovered;
	public static int curX=0,curY=0;
	public static int gridX=0,gridY=0;
	public static int selectedEntity=-1;


	public static boolean actioned=false;
	public static boolean pressed=false;
	public static boolean released=true;
	public static ArrayList<ArrayList<Integer>> area= new ArrayList<ArrayList<Integer>>();
	public BattleScreen(Stage stage) {
		setVisible(true);
		setSize(Main.screenWidth,Main.battleHeight+1);
		setLocation(0,0);
		this.stage=stage;
	}
	
	public void paint(Graphics g) {
		g.clearRect(0,0,Main.screenWidth,Main.screenHeight);
		
		
		for(int i=0;i<stage.map.length;i++) {
			for(int j=0;j<stage.map[i].length;j++) {
				if(stage.map[i][j].name=="Plains") {
					g.setColor(Color.green);
				}
				if(stage.map[i][j].name=="Wall") {
					g.setColor(Color.gray);
				}
				g.fillRect(i*Main.blockSize,j*Main.blockSize,Main.blockSize,Main.blockSize);
			}
		}
		g.setColor(Color.black);
		for(int i=0;i<=Main.cols;i++) {
			g.drawLine(i*Main.blockSize,0,i*Main.blockSize,Main.blockSize*Main.rows);
		}
		for(int i=0;i<=Main.rows;i++) {
			g.drawLine(0,i*Main.blockSize,Main.blockSize*Main.cols,i*Main.blockSize);
		}
		for(Entity e : stage.entities) {
			g.fillRect(e.y*Main.blockSize,e.x*Main.blockSize,Main.blockSize,Main.blockSize);
		}
		
		
		try {
			curX=this.getMousePosition().x;
			curY=this.getMousePosition().y;
			gridY=(int)(curX/Main.blockSize);
			gridX=(int)(curY/Main.blockSize);
			
		} catch(Exception e) {
			
		}
		if(BattleScreen.selected && BattleScreen.index!=-1) {

			BattleScreen.stage.entities.get(index).x=gridX;
			BattleScreen.stage.entities.get(index).y=gridY;
			
		}
		//get movable area
		if(!selected && !actioned && !nextAction) {
			area.clear();
			for(int i=0;i<BattleScreen.stage.entities.size();i++) {
				Entity entity=BattleScreen.stage.entities.get(i);
				if(entity.x==BattleScreen.gridX && entity.y==BattleScreen.gridY) {
					 area=MovCalc.getMov(stage.map,entity,stage.entities);
				}
			}
		}
		
		
		for(ArrayList<Integer> i:area) {
			g.setColor(Color.YELLOW);
			
			g.drawRect(i.get(0)*Main.blockSize+1,i.get(1)*Main.blockSize+1,Main.blockSize-2,Main.blockSize-2);
			g.drawRect(i.get(0)*Main.blockSize+2,i.get(1)*Main.blockSize+2,Main.blockSize-4,Main.blockSize-4);
		}
		
		if(selected && selectedEntity!=-1) {
			stage.entities.get(selectedEntity).y=gridY;
			stage.entities.get(selectedEntity).x=gridX;
		}
//		System.out.println(curX + " " + curY);
//		System.out.println(gridX + " " + gridY);
		

	}

}
