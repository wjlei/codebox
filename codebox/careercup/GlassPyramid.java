package careercup;

import java.util.Scanner;
import java.util.regex.Pattern;

//There are some glasses with equal volume 1 litre. The glasses kept as follows
//                 1
//		         2   3
//		      4    5    6
//		    7    8    9   10
//You can put water to only top glass. If you put more than 1 litre water to 1st glass, 
//water overflow and fill equally both 2nd and 3rd glass.
// Glass 5 will get water from both 2nd glass and 3rd glass and so on.. 
//If you have X litre of water and you put that water in top glass, 
//so tell me how much water contained by jth glass in ith row. 
//Example. If you will put 2 litre on top. 

class GlassStatus {
	float heldVolume;
	float overflownVolume;
}

public class GlassPyramid {

	static int ipRowNum, ipGlassNum, ipVolume;
	public static float computeWaterAt(float volume, int level, GlassStatus[] previousRows) {

		if (volume <= 0)
			return 0;
		
		GlassStatus[] rows = new GlassStatus[level + 1];
		float overflow1 = 0, overflow2 = 0, inflow = 0, tempVol = 0;
		
		for (int i = 0, prev = i-1, next = i; i <= level; i++, prev++, next++) {
			
			rows[i] = new GlassStatus();
			
			if (prev < 0) {
				overflow1 = 0;
			} else {
				overflow1 = previousRows[prev].overflownVolume/2;
			}
			
			if (next >= level) {
				overflow2 = 0;
			} else {
				overflow2 = previousRows[next].overflownVolume/2;
			}
			if (level == 0) {
				inflow = volume;
			} else {
				inflow = overflow1 + overflow2;
			}
			
			tempVol += rows[i].heldVolume = Math.min(1, inflow);
			rows[i].overflownVolume = inflow - rows[i].heldVolume; 			
		}
		
		if (level == ipRowNum) {
			return rows[ipGlassNum].heldVolume; 
		} else {
			return computeWaterAt(volume - tempVol, level + 1, rows);
		}
	}

	public static void readInput() {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(System.getProperty("line.separator"));
		Pattern delimiters = Pattern.compile(System.getProperty("line.separator")+"|\\s");
		scanner.useDelimiter(delimiters);
		
		System.out.println("Input row#:");
		ipRowNum = scanner.nextInt();
		
		System.out.println("Input glass#:");
		ipGlassNum = scanner.nextInt();
		
		System.out.println("Input volume:");
		ipVolume = scanner.nextInt();
				
	}
	
	public static void main(String[] args) {
		readInput();
		System.out.println("Volume in the glass=" + computeWaterAt(ipVolume, 0, new GlassStatus[] {}));
	}

}
