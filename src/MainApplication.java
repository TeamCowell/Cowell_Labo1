import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

/*********
 * 
 * @author 
 *
 */

public class MainApplication {
	
    public static void main ( String [ ] arguments) throws IOException
    {
    	String filename;
    	String clientChoice;
    	BufferedReader commandRead = new BufferedReader(new InputStreamReader(System.in));
    	
    	System.out.println("Hello! Would you like to compress or decompress a file? (c for compress, d for decompress) :");
    	clientChoice = commandRead.readLine();
    	while(!clientChoice.equals("c") && !clientChoice.equals("d") && !clientChoice.equals("C") && !clientChoice.equals("D")){
        	System.out.println("Please enter a valid character !\nWould you like to compress or decompress a file? (c for compress, d for decompress) :");
        	clientChoice = commandRead.readLine();
    	}
    	
    	if(clientChoice.equals("c") || clientChoice.equals("C") ){
    	//Compress

        System.out.println("Please input the file you wish to compress! :");
        
        filename = commandRead.readLine(); // Reading a string input
        System.out.println(filename);
        System.out.println("Reading File ... "+filename);
        
        FrequencyTableReader ftr = new FrequencyTableReader(filename); // Reading the path and creating the frequency table
        //FrequencyTableReader ftr = new FrequencyTableReader("C:\\Users\\Simon\\Documents\\LOG320_TEST\\test1.txt");
        ftr.readFile();

        BinaryTree bt = new BinaryTree(ftr);

        //NodeEncoder ne = new NodeEncoder(bt.encodeTree(),ftr.textFileCharactersList);
        final Map<Character, String> charCode = EncodeurNoeud.genererCharCode(ftr.getFreqTable().keySet(),bt.encodeTree());
       // System.out.println(charCode);
        
        StringBuilder headerStringBuilder = new StringBuilder();
        for (Map.Entry<Character, String> entry : charCode.entrySet())
        {
            //System.out.println(entry.getKey() + "," + entry.getValue());
            headerStringBuilder.append(entry.getKey() + "," + entry.getValue()+",");
            headerStringBuilder.toString();
        }
        headerStringBuilder.deleteCharAt(headerStringBuilder.length()-1);
        
        final String encodedMessage = EncodeurNoeud.encoderMessage(charCode, ftr.getTextFileString());
        EncodeurNoeud.createFile(encodedMessage,filename,headerStringBuilder.toString());
    	}
        //End Of Compress
    	
    	else if (clientChoice.equals("d") || clientChoice.equals("D")){ 
        //Decompress
        System.out.println("Please input the file you wish to decompress! :");
        
        filename = commandRead.readLine(); // Reading a string input
        
        System.out.println(filename);
        System.out.println("Reading File ... "+filename);
        
        Decompresseur decomp = new Decompresseur(filename);
        
        decomp.readFile();
    	}
    	//End of Decompress
    
    }

}
