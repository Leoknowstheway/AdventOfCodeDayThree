import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
public class Runner {
	//Extract the next multiplication command from the given line
	//returns an empty string if non exists
	public String extractMult(String line) {
		if(line.indexOf("mul") == -1) {
			return "";
		}else {
			int start = line.indexOf("mul(");
			int end = line.indexOf(")");
			//stop! if there is no closing ")" then
			//this is not the one we want :)
			
					return line.substring(start, end);
		}
		
	}

	public static void main(String[] args) {
		File file = new File("input.txt");
		try {
			Scanner scanner = new Scanner(file);
			int count = 0;
			scanner.nextLine(); //move forward to next line
			while(scanner.hasNextLine()) 
			{
				String row = scanner.nextLine();
				System.out.println(row);
				//split the row into columns as an array
				System.out.println(scanner.next());
				System.out.println("----------");
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
	}
}
