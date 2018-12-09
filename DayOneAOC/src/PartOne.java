import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartOne {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("src/input"));
		
		int sum = 0;
		
		while (in.hasNextLine())
			sum += in.nextInt();

		System.out.println(sum);
		
		in.close();

	}

}
