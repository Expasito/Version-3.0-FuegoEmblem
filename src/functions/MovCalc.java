package functions;
import GroundTypes.*;
import Entity.*;
import java.util.ArrayList;
public class MovCalc {
	public static ArrayList<ArrayList<Integer>> getMov(Ground[][] map, Entity e, ArrayList<Entity> entities) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> things = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> partial = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> startLoc = new ArrayList<Integer>();
		startLoc.add(e.y);
		startLoc.add(e.x);
		results.add(startLoc);
		
		
		for(int i=0;i<e.mvt;i++) {
			for(ArrayList<Integer> ints:results) {
				if(e.inf) {
					if(ints.get(1)>0 && map[ints.get(0)][ints.get(1)-1].standable) {
						ArrayList<Integer> adder = new ArrayList<Integer>();
						adder.add(ints.get(0));
						adder.add(ints.get(1)-1);
						adder.add(map[ints.get(0)][ints.get(1)-1].movCost);
						adder.add(1);
						adder.add(0);
						things.add(adder);
					}
					if(ints.get(1)+1<map[0].length && map[ints.get(0)][ints.get(1)+1].standable) {
						ArrayList<Integer> adder = new ArrayList<Integer>();
						adder.add(ints.get(0));
						adder.add(ints.get(1)+1);
						adder.add(map[ints.get(0)][ints.get(1)+1].movCost);
						adder.add(1);
						adder.add(1);
						things.add(adder);

					}
					if(ints.get(0)>0 && map[ints.get(0)-1][ints.get(1)].standable) {
						ArrayList<Integer> adder = new ArrayList<Integer>();
						adder.add(ints.get(0)-1);
						adder.add(ints.get(1));
						adder.add(map[ints.get(0)-1][ints.get(1)].movCost);
						adder.add(1);
						adder.add(2);
						things.add(adder);

					}
					if(ints.get(0)+1<map.length && map[ints.get(0)+1][ints.get(1)].standable) {
						ArrayList<Integer> adder = new ArrayList<Integer>();
						adder.add(ints.get(0)+1);
						adder.add(ints.get(1));
						adder.add(map[ints.get(0)+1][ints.get(1)].movCost);
						adder.add(1);
						adder.add(3);
						things.add(adder);

					}
				}
			}
			
			//check to make sure tile is not ocupied by enemy
			ArrayList<ArrayList<Integer>> things2 = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> location: things) {
				boolean check=false;
				for(Entity entity2 : entities) {
					//add once affiliation is added
					
				}
				if(!check) {
					//add tile to things2
					things2.add(location);
				}
			}
			things=things2;
			

			
			//add to results if tile is fully full
			
			for(ArrayList<Integer> ints2: things) {
				ArrayList<Integer> adder2 = new ArrayList<Integer>();
				if(e.fly) {
					
					adder2.add(ints2.get(0));
					adder2.add(ints2.get(1));
					results.add(adder2);
				} else if(ints2.get(2)==ints2.get(3)) {
					adder2.add(ints2.get(0));
					adder2.add(ints2.get(1));
					results.add(adder2);
				} else {
					if(partial.size()<=0) {
						partial.add(ints2);

					}else {
						boolean check=false;
						for(ArrayList<Integer> p: partial) {
							if(p.get(0)==ints2.get(0) && p.get(1)==ints2.get(1) && p.get(4)!=ints2.get(4)) {
								check=true;
							}
						}
						if(!check) {
							partial.add(ints2);
						}
					}
				}
			}

			
			
			ArrayList<ArrayList<Integer>> newOnes = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> rep = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> in2 : results) {
				if(newOnes.size()<=0) {
					rep.add(in2);
				}
				else {
					boolean check=true;
					for(ArrayList<Integer> in3:newOnes) {
						if(in2.get(0)==in3.get(0) && in2.get(1)==in3.get(1)) {
							check=false;
						}else {
							
						}
					}
					if(check) {
						rep.add(in2);
					}
					
				}
				for(ArrayList<Integer> in4: rep) {
					newOnes.add(in4);
				}
				rep.clear();
			}
			results=newOnes;
			things.clear();
			
			
			//add new partials
			
			ArrayList<ArrayList<Integer>> newPartials = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> partials: partial) {
				int counter=0;
				for(ArrayList<Integer> partials2:partial) {
					if(partials.get(0)==partials2.get(0) && partials.get(1)==partials2.get(1)) {
						counter+=1;

					}
				}

				if(partials.get(2)==counter) {

					boolean check=false;
					for(ArrayList<Integer> a: results) {
						if(a.get(0)==partials.get(0) && a.get(1)==partials.get(1)) {
							check=true;
						}
					}
					if(!check) {
						ArrayList<Integer> re=new ArrayList<Integer>();
						re.add(partials.get(0));
						re.add(partials.get(1));
						results.add(re);

					}
				}
				else {

					ArrayList<Integer> newerPartial = partials;
					newerPartial.set(3, counter);
					newPartials.add(newerPartial);

				}
			}

			partial.clear();
			for(ArrayList<Integer> pa:newPartials) {

				partial.add(pa);
			}

			newPartials.clear();

			
		}
		ArrayList<ArrayList<Integer>> results2 = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> location: results) {
			boolean check=false;
			for(Entity entity2:entities) {
				if(entity2.x==e.x && entity2.y==e.y) {
					
				}
				else {
					if(location.get(1)==entity2.x && location.get(0)==entity2.y) {
						check=true;
					}
				}
			}
			if(!check) {
				results2.add(location);
			}
		}
		return results2;
	}

}
