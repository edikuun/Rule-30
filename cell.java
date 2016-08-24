import java.util.Scanner;
public class cell {
	public static void main(String[] args){
		int l;
		System.out.println("Enter size of cell: "); //asks for number of cells
		Scanner in =  new Scanner(System.in); // gets input
		l = in.nextInt();
		int[] length = new int [l]; //set values
		int[] width = new int [l]; //set values
		length[(l/2)] = 1; // put 1 on the seed
		
		fill(length); //prints first row
		
		for (int y = 0; y < l-1; ++y){ //increments to check neighbors
			for (int x = 0; x < l; ++x){
				int left = length[(x+l-1)%l];
				int right = length[(x+1)%l];
				int middle = length[x];
				//if ((left == right && x == 0))
					//left = 0;
				if (x == 0){
					if (left == right)
						left = 0;
					else if (left == middle && left == 1)
						left = 0;
				}
				//if ((left == right && x == l))
					//right = 0;
					if (x == l-1){
						if (left == right)
							right = 0;
						else if (left == middle){
							right = 0;
							//System.out.println("BOGO");
						}
					}
				
					
				width[x] = (middle | right) ^ left; //check if neighbors indicates 1 or 0
			}
			fill(width); //print next row
			
			int[] store = length; //update rows so that it will check on the preceding row
			length = width; 
			width = store;
		}
	}
	public static void fill(int[] fill){ //function for printing 1 and 0
		for (int x = 0; x < fill.length; ++x){
			if (fill[x] == 0)
				System.out.print ("0");
			else
				System.out.print ("1");
		}
		System.out.println();
	}
	
}
