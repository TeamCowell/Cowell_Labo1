import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Hashtable;


/*********
 * 
 * @author 
 *
 */

public class MainApplication {
	
    public static void main ( String [ ] arguments) throws IOException
    {
    	BufferedReader commandRead = new BufferedReader(new InputStreamReader(System.in));
    	
    	
        System.out.println("Hello! Please input the file you wish to compress! :");
        
        String text = commandRead.readLine();
        
        System.out.println("Reading File ... "+text);
        
        Charset encoding = Charset.defaultCharset();
        
        File file = new File(text);
        handleFile(file, encoding);
                           
    }
    
    private static void handleFile(File file, Charset encoding)
            throws IOException {
        try (InputStream in = new FileInputStream(file);
             Reader reader = new InputStreamReader(in, encoding);
             // buffer for efficiency
             Reader buffer = new BufferedReader(reader)) {
            handleCharacters(buffer);
        }
       
    }

    private static void handleCharacters(Reader reader)
            throws IOException {
        int r;
        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            System.out.println("Do something with " + ch);
            //methode tableau de frequence
            createFrequencyTable(ch);
            
        }
    }
    private static void createFrequencyTable(char ch){
    
    	
    }
	
}
