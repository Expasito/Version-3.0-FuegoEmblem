package Stage;

import java.util.ArrayList;

import GroundTypes.Ground;
import GroundTypes.Plains;
import GroundTypes.Wall;

public class Stage3 extends Stage {
	public Stage3() {
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
		this.number=3;
		this.name="Preparing For An Invasion";
//		this.entities= new ArrayList<String>();
//		this.entities.add("Solder");
//		this.entities.add("Soldier");
//		this.entities.add("Soldier");
//		this.entities.add("Soldier");
//		this.entities.add("Soldier");
//		this.entities.add("Paladin");
//		this.entities.add("Paladin");
//		this.entities.add("Paladin");
//		this.entities.add("Paladin");
//		this.entities.add("Paladin");
//		this.entities.add("Warrior");
//		this.entities.add("Warrior");
//		this.entities.add("Warrior");
	}

}
