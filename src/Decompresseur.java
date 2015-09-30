import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Decompresseur {
	
	private String path;
	
	
	public Decompresseur(String path){
		this.path = path;
	}
	
	public void readFile() throws IOException{
		LinkedHashMap<String,String> map = null;
		String message = null;
		String line;
		boolean readBitset = false;
		String legendString = "";
	    InputStream fis = new FileInputStream(this.path);
	    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
	    BufferedReader br = new BufferedReader(isr);
	    int bitSetSize=0;
	    int k=0;
	    while ((line = br.readLine()) != null) {
	    	        
	    	/*
	    	if(k==0){
	    		System.out.println(line);
	    		//ici on mets le code pour legende a map
	    		map = legendeToMap(line);
	    		
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
					message = decodeMessage(this.path,line,bitSetSize);
					System.out.println("message: "+message);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}

	    	k++;*/
	    	
	        if(readBitset){
		    	if(k==0){
		    		bitSetSize = Integer.parseInt(line);
		    		//System.out.println(line);
		    	}
		    	
		    	if(k==1){
	        		//System.out.println(line);
	        		line = line.substring(1, line.length()-1);
	        		//System.out.println(line);
					try {
						message = decodeMessage(this.path,line,bitSetSize);
						System.out.println("message: "+message);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
			k++;
	        }else{
	        	legendString += "\n"+line;
		        if(line.subSequence(line.length()-3, line.length()).equals(";;;")){
		            readBitset = true;
		        	map = legendeToMap(legendString);
		        }
		       //System.out.println(line);
	        }

	    }
		System.out.println(translateMessage(map, message));		
		
		PrintWriter outpw = new PrintWriter(path.substring(0, path.length()-3) + "txt");
		outpw.print(translateMessage(map, message));
		outpw.close();
		fis.close();
	}
	
	private static LinkedHashMap<String,String> legendeToMap(String l){
		l = l.substring(0, l.length()-3);
		//System.out.println(l);
		List<String> myList = new ArrayList<String>(Arrays.asList(l.split(",")));
		//System.out.println(myList);
		myList.set(0, myList.get(0).substring(myList.get(0).length()-1, myList.get(0).length())) ;
        //System.out.println(myList);
        LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
        for(int i=0; i<myList.size(); i=i+2){
//        	map.put(key, value)
        	map.put(myList.get(i+1), myList.get(i));
        	//System.out.println("\""+myList.get(i) + "\" " + myList.get(i+1));
        }
        return map;
	}
	private static String translateMessage(LinkedHashMap<String,String> map, String message){
		
		StringBuilder resultat  = new StringBuilder();
		while(message.length() > 0){
			for (Map.Entry<String, String> entry : map.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				// now work with key and value...
				//System.out.println("going thru map with key " + key);
				if(message.startsWith(key)){
					resultat.append(value);
					message = message.substring(key.length());
				}

			}
		}
		return resultat.toString();
	}
	
	
	
	private static String decodeMessage(String path, String l,int size) throws FileNotFoundException, IOException, ClassNotFoundException {
        //try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            //final BitSet bitSet =  EncodeurNoeud.getBitSet(l);
            String bitSetString = "";
            List<String> myList = new ArrayList<String>(Arrays.asList(l.split("\\s*,\\s*")));
            //System.out.println(myList);
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
            //System.out.println(myList.size());
            System.out.println("true mess: "+bitSetString);
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
            return bitSetString;
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
