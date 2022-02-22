package Entity;

import Weapon.*;

public class Villager extends Entity {
	public Villager(int x, int y, int lvl, String affil, Weapon weapon) {
		this.x=x;
		this.y=y;
		this.name="Villager";
		this.mvt=4;
		this.inf=true;
		this.fly=false;
		this.lvl=lvl;
		this.affil=affil;
		this.weapon=weapon;
		this.str=5;
		this.dfns=3;
		this.spd=5;
		this.skl=1;
		this.lck=2;
		this.hp=30;
		double[] growth= {1.2,1.1,1.3,1.1,1.3,1.1};
		this.growths = growth;
		initLvlUp();
	}

}
