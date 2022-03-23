package RangeFinder;

import java.util.ArrayList;
import java.util.Arrays;

class Entity{
	int close;
	int far;
	int x,y;
	
	public Entity(int close, int far, int x, int y) {
		this.close=close;
		this.far=far;
		this.x=x;
		this.y=y;
	}
}


public class Find {
	public static ArrayList<Integer[]> range = new ArrayList<Integer[]>();
	

	public static void main(String[] args) {
		Entity a = new Entity(2,2,5,5);
		getRange(a);
		

	}
	public static void getRange(Entity e) {
		int x,y;
		int rng = e.far-e.close+1;
		System.out.println(rng);
		for(int i=e.close;i<rng+e.close;i++) {
//			//covers bottom right
			for(int j=-e.far/2;j<=rng;j++) {
				if(e.x+i-Math.abs(j)<e.x) {
					break;
//					int[] loc3 = {e.y+j,e.x+i-j};
//					Find.range.add(loc3);
				}else {
					Integer[] loc3 = {e.y+j,e.x+i-Math.abs(j)};
					range.add(loc3);
				}
				
			}
			
			//top right
			for(int j=-e.far/2;j<=rng;j++) {
				if(e.x+i-Math.abs(j)<e.x) {
					break;
//					int[] loc3 = {e.y+j,e.x+i-j};
//					Find.range.add(loc3);
				}else {
					Integer[] loc3 = {e.x-i+Math.abs(j),e.y+j};
					range.add(loc3);
				}
				
			}
			
			//top bottom left
			for(int j=-e.far/2;j<=rng;j++) {
				if(e.x+i-Math.abs(j)<e.x) {
					break;
//					int[] loc3 = {e.y+j,e.x+i-j};
//					Find.range.add(loc3);
				}else {
					Integer[] loc3 = {e.x+i-Math.abs(j),e.y-j};
					range.add(loc3);
				}
				
			}
			
			
			//top top left
			for(int j=-e.far/2;j<=rng;j++) {
				if(e.x+i-Math.abs(j)<e.x) {
					break;
//					int[] loc3 = {e.y+j,e.x+i-j};
//					Find.range.add(loc3);
				}else {
					Integer[] loc3 = {e.x-j,e.y-i+Math.abs(j)};
					range.add(loc3);
				}
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			for(int j=0;j<rng;j++) {
//				if(e.x+i-j<e.x) {
//					break;
////					int[] loc3 = {e.y+j,e.x+i-j};
////					Find.range.add(loc3);
//				}else {
//					int[] loc3 = {e.y-j,e.x-i+j};
//					Find.range.add(loc3);
//				}
//				
//			}
//			for(int j=0;j<rng;j++) {
//				if(e.x+i-j<e.x) {
//					break;
////					int[] loc3 = {e.y+j,e.x+i-j};
////					Find.range.add(loc3);
//				}else {
//					int[] loc3 = {e.y-j,e.x+i-j};
//					Find.range.add(loc3);
//				}
//				
//			}
//			for(int j=0;j<rng;j++) {
//				if(e.x+i-j<e.x) {
//					break;
////					int[] loc3 = {e.y+j,e.x+i-j};
////					Find.range.add(loc3);
//				}else {
//					int[] loc3 = {e.y-j,e.x+i-j};
//					Find.range.add(loc3);
//				}
//				
//			}
//			for(int j=0;j<rng;j++) {
//				if(e.x+i-j<e.x) {
//					break;
////					int[] loc3 = {e.y+j,e.x+i-j};
////					Find.range.add(loc3);
//				}else {
//					int[] loc3 = {e.y-j,e.x-i-j};
//					Find.range.add(loc3);
//				}
//				
//			}
			
//			for(int j=0;j<3;j++) {
//				int[] loc3 = {e.y+j,e.x+i-j};
//				Find.range.add(loc3);
//			}
//			int[] loc = {e.y,e.x+i};
//			Find.range.add(loc);
//			
//			int[] loc2 = {e.y+1,e.x+i-1};
//			Find.range.add(loc2);
//			
//			int[] loc3 = {e.y+2,e.x+i-2};
//			Find.range.add(loc3);
//			for(int j=0;j<rng+1;j++) {
//				int[] loc = {e.y-j,e.x+i};
//				Find.range.add(loc);
//			}
			
//			for(int j=0;j<rng+e.close;j++) {
//				int[] loc = {e.x+i-j+2,e.y+e.close+j-1};
//				Find.range.add(loc);
//			}
			
//			System.out.println("here");
//			for(int j=0;j<rng;j++) {
//				int[] loc = {e.x+i,e.y+e.close+j};
//				Find.range.add(loc);
//				System.out.println("here");
//			}
//			Find.range.add(1);
		}
		
		ArrayList<Integer[]> newMap = new ArrayList<Integer[]>();
		for(int i=0;i<range.size();i++) {
			boolean check=false;
			for(int j=0;j<newMap.size();j++) {
//				System.out.println(range.get(i)[0]==newMap.get(j)[0] && range.get(i)[1]==newMap.get(j)[1]);
				if(range.get(i)[0]==newMap.get(j)[0] && range.get(i)[1]==newMap.get(j)[1]) {
					check=true;
				}
			}
			if(!check) {
				newMap.add(range.get(i));
			}
		}
//		range=newMap;
//		ArrayList<Integer[]> newList = new ArrayList<Integer[]>();
//		for(Integer[] element:range) {
//			if(!newList.contains(element)) {
//				newList.add(element);
//				System.out.println(element[0] + " " + element[1]);
//			}
//		}
		
//		Arrays.deepToString(newList);
		
		//display range
//		for(Integer[] a:newList) {
//			System.out.println(a[0] + " " + a[1]);
//		}
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				boolean check=false;
				for(Integer[] a:newMap) {
					if(i==a[0] && j==a[1]) {
						System.out.print("# ");
						check=true;
						
					}
				}
				if(!check) {
					if(i==e.x && j==e.y) {
						System.out.print("H ");
					}else
						System.out.print("_ ");
				}
				
			}
			System.out.println("");
		}
	}
	

}
