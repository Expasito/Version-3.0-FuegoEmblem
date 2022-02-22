package Entity;

import Weapon.*;

public class Entity {
	public int mvt;
	public String name;
	public int x, y;
	public boolean inf;
	public boolean fly;
	public String affil;
	public int lvl;
	public Weapon weapon;
	public double str, dfns,spd,skl,lck,hp;
	//hp, str, spd, dfns, skl, lck
	public double[] growths;
	public Entity() {
		
	}
	public void lvlUp() {
		
	}
	public void initLvlUp() {
		this.hp+=growths[0]*this.lvl;
		this.str+=growths[1]*this.lvl;
		this.spd+=growths[2]*this.lvl;
		this.dfns+=growths[3]*this.lvl;
		this.skl+=growths[4]*this.lvl;
		this.lck+=growths[5]*this.lvl;
	}
}
