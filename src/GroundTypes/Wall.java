package GroundTypes;

public class Wall extends Ground {
	public Wall() {
		this.name="Wall";
		this.movCost=1;
		this.avo=0;
		this.def=0;
		this.res=0;
		this.hp=0;
		this.standable=false;
		this.flyable=true;
	}
}
