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
    	BufferedReader commandRead = new BufferedReader(new InputStreamReader(System.in));
    	
    	
        System.out.println("Hello! Please input the file you wish to compress! :");
        
        String filename = commandRead.readLine(); // Reading a string input
        System.out.println(filename);
        System.out.println("Reading File ... "+filename);
        
        FrequencyTableReader ftr = new FrequencyTableReader(filename); // Reading the path and creating the frequency table
        //FrequencyTableReader ftr = new FrequencyTableReader("C:\\Users\\Simon\\Documents\\LOG320_TEST\\test1.txt");
        ftr.readFile();
        
        
        
        BinaryTree bt = new BinaryTree(ftr);
        
        
        
        //NodeEncoder ne = new NodeEncoder(bt.encodeTree(),ftr.textFileCharactersList);
        final Map<Character, String> charCode = NodeEncoder.genererCharCode(ftr.getFreqTable().keySet(),bt.encodeTree());
        System.out.println(charCode);
        //ne.encodeNode();
        
        StringBuilder headerStringBuilder = new StringBuilder();
        for (Map.Entry<Character, String> entry : charCode.entrySet())
        {
            //System.out.println(entry.getKey() + "," + entry.getValue());
            headerStringBuilder.append(entry.getKey() + "," + entry.getValue()+",");
            headerStringBuilder.toString();
        }
        headerStringBuilder.deleteCharAt(headerStringBuilder.length()-1);
        System.out.println(headerStringBuilder.toString());
        
        final String encodedMessage = NodeEncoder.encoderMessage(charCode, ftr.getTextFileString());
        NodeEncoder.createFile(encodedMessage,filename,headerStringBuilder.toString());
        //System.out.println(encodedMessage);
        //System.out.println(ftr.textFileCharactersList);
        //System.out.println(bt.entryList);

        

    
    }
}
