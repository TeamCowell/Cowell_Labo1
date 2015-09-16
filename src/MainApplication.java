import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;


/*********
 * 
 * @author 
 *
 */

public class MainApplication {

    public static void main ( String [] arguments) throws IOException
    {
        System.out.println("Hello! Please input the file you wish to compress! :");
        String filename =(new Scanner(System.in).next());
        System.out.println(filename);
        FrequencyTableReader ftr = new FrequencyTableReader("C:\\Users\\Simon\\Documents\\LOG320_TEST\\" + filename);
        ftr.readFile();
    }
    
	
}
