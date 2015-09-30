import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.List;

public class Decompresseur {
	
	private String path;
	
	public Decompresseur(String path){
		this.path = path;
	}
	
	public void readFile() throws IOException{
		String line;
		boolean readBitset = false;
	    InputStream fis = new FileInputStream(this.path);
	    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
	    BufferedReader br = new BufferedReader(isr);
	    int bitSetSize=0;
	    int k=0;
	    while ((line = br.readLine()) != null) {
	    	
	    	if(k==0){
	    		System.out.println(line);
	    		
	    	}
	    	if(k==1){
	    		bitSetSize = Integer.parseInt(line);
	    		System.out.println(line);
	    	}
	    	
	    	if(k==2){
        		System.out.println(line);
        		line = line.substring(1, line.length()-1);
        		System.out.println(line);
				try {
					System.out.println(decodeMessage(this.path,line,bitSetSize));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	k++;
	    	
	        /*if(readBitset){
	        	try {
	        		System.out.println(line);
	        		line = line.substring(1, line.length()-1);
	        		System.out.println(line);
					System.out.println(decodeMessage(this.path,line));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }else{
		        if(line.subSequence(line.length()-3, line.length()).equals(";;;")){
		        	readBitset = true;
		        }
		        System.out.println(line);
	        }*/

	    }
		
		fis.close();
	}
	
	private static String decodeMessage(String path, String l,int size) throws FileNotFoundException, IOException, ClassNotFoundException {
        //try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            //final BitSet bitSet =  EncodeurNoeud.getBitSet(l);
            String bitSetString = "";
            List<String> myList = new ArrayList<String>(Arrays.asList(l.split("\\s*,\\s*")));
            System.out.println(myList);
            int j =0;
            for(int i=0; i<size;i++){
            	
            	if(j<myList.size() && i == Integer.parseInt(myList.get(j))){
            		j++;
            		bitSetString += "1";
            	}
            	else{
            		bitSetString += "0";
            	}
            }
            System.out.println(myList.size());
            System.out.println(bitSetString);
            final StringBuilder stringBuilder = new StringBuilder();
            
            //System.out.println(Integer.toBinaryString(toByteArray(bitSet)[0]));
            
           /* for (int i = 0; i < (bitSet.length() - 1);) {
                Noeud temp = node;
                
                while (temp.getGauche() != null) {
                    if (!bitSet.get(i)) {
                        temp = temp.getGauche();
                    } else {
                        temp = temp.getDroite();
                    }
                    i = i + 1;
               }
                stringBuilder.append(temp.valeur);
            }*/
            return stringBuilder.toString();
       // }
    }

	public static byte[] toByteArray(BitSet bitSet) {
	     ByteArrayOutputStream baos = new ByteArrayOutputStream(bitSet.size());
	     try {
	       ObjectOutputStream oos = new ObjectOutputStream(baos);
	       oos.writeObject(bitSet);
	     }
	     catch (Exception ex) {
	       ex.printStackTrace();
	     }
	     return baos.toByteArray();
	  }
	
	
}
