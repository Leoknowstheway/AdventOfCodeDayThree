import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
public class runner {

	public static void main(String[] args) {
		
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		File file = new File("input.txt");
		try {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNext()) {
				//read in 2 ints per iteration
				int first= scanner.nextInt();
				int second = scanner.nextInt();
				
				//add the two numbers to their respective lists
				left.add(first);
				right.add(second);
			}
			
			//for testing only
			// 1) perform a sequential search in the left list to look for the smallest element
			int sum = 0;
			
			while(left.size() > 0) {
				int smallest = left.get(0);
				int smallestIndex = 0;
			
			
			//look for something smaller than current
			for(int i = 0; i < left.size(); i++) {
				if(left.get(i) < smallest) {
					smallest = left.get(i);
					smallestIndex = i;
				}
			}
			
			//remove the smallest value you found!
			left.remove(smallestIndex); 
			
			//System.out.println(smallest);
			
			
			while(right.size() > 0) {
				int smallestr = right.get(0);
				int smallestIndexr = 0;
				
				
				//look for something smaller than current
				for(int i = 0; i < right.size(); i++) {
					if(right.get(i) < smallestr) {
						smallestr = right.get(i);
						smallestIndexr = i;
					}
				}
				//remove the smallest value you found!
				right.remove(smallestIndexr); 
				
				
				//find the absolute value difference between the
				//smallest from left and right list
				System.out.println("difference is " + Math.abs(( smallest)));
				sum += Math.abs(smallestr - smallest);
				
				
			}
			
			}
			System.out.println("sum is " +sum);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
}
