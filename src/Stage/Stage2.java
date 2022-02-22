package Stage;


import java.util.ArrayList;

import GroundTypes.Ground;
import GroundTypes.Plains;
import GroundTypes.Wall;

public class Stage2 extends Stage{
	public Stage2() {
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
		this.number=2;
		this.name="An Early Morning Ambush";
//		this.entities= new ArrayList<>();
//		this.entities.add("Solder");
//		this.entities.add("Assassin");
//		this.entities.add("Paladin");
	}

}