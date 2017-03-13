import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadText{
	static Scanner sc;

	public static void initialize(String filnavn){
		try{
			File fil = new File(filnavn);
			sc = new Scanner(fil);
		} catch(FileNotFoundException fnfe){
			System.out.println("Mangler fil");
			System.exit(0);
		}
	}

	public static String les(int start, int slutt) throws Exception{

		String linjer = "";
		for(int i = 0; sc.hasNextLine() && i < slutt; i++){
			String s = sc.nextLine();

			if(i >= start && i < slutt){
				linjer += s;
			}
		}

		return linjer;
	}
}