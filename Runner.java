import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
public class Runner {

	public static void main(String[] args) {
		File file = new File("input.txt");
		try {
			Scanner scanner = new Scanner(file);
			scanner.nextLine(); //move forward to next line
			while(scanner.hasNextLine()) 
			{
				String row = scanner.nextLine();
				System.out.println(row);
				
				//split the row into columns as an array
				String[] cols = row.split(",");
				int year = Integer.parseInt(cols[0]);	
				double percent = Double.parseDouble(cols[2]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
	}
}
