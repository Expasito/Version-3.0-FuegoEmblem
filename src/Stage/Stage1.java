package Stage;

import java.util.ArrayList;

import Entity.*;
import GroundTypes.*;
import Weapon.*;

public class Stage1 extends Stage{
	public Stage1() {
		Ground[][] mappo = new Ground[50][20];
		for(int i=0;i<mappo.length;i++) {
			for(int j=0;j<mappo[i].length;j++) {
				mappo[i][j] = new Plains();
			}
		}
		
		mappo[5][5] = new Wall();
		mappo[6][5] = new Wall();
		mappo[7][5] = new Wall();
		mappo[6][6] = new Wall();
		
		this.map=mappo;
		this.number=1;
		this.name="Training Practice";
		this.entities= new ArrayList<Entity>();
		this.entities.add(new Villager(1,1,10,"Player", new IronSword()));
		this.entities.add(new Villager(2,1,1,"Player", new IronBow()));
//		this.entities.add(new Villager(1,5,1,"Enemy"));
	}

}
