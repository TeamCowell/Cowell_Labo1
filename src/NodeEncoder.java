import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Hashtable;

public class NodeEncoder{
	
	private Noeud noeudRacine;
	private ArrayList<Character> texteAEncoderList;
	private String encodeStringTemp="";
	private String encodeString = "";
	private Byte[] byteArray;
	private String decodingString = "";
	private String stringEncodedData;
	
	
	public NodeEncoder(Noeud noeud,ArrayList<Character> texteAEncoderList){
		this.noeudRacine = noeud;
		this.texteAEncoderList = texteAEncoderList;
	}
	
	public String encodeNode(){
		
		//System.out.println(searchNodes('b',noeudRacine));
		
		//System.out.println(encodeString);
		
		for(Character car : texteAEncoderList){
			
			//System.out.println(car);
			encodeStringTemp = "";
			searchNodes(car.charValue(),noeudRacine);
			System.out.println(encodeStringTemp);
			if(decodingString.indexOf(car.charValue()) == -1){
				decodingString += car.charValue()+encodeStringTemp + ",";
			}
			encodeString += encodeStringTemp;
				
		}
		System.out.println(decodingString);
		//byteArray = encodeString.getBytes(Charset.forName("UTF-8"));
		
		/*short a = Short.parseShort(encodeString, 2);
		ByteBuffer bytes = ByteBuffer.allocate(2).putShort(a);

		byte[] array = bytes.array();
		
		for(int i=0; i< array.length;i++){
			System.out.println("SIMON__"+array[i]);
		}
		for (byte b : array) {
		    System.out.println(Integer.toBinaryString(b & 255 | 256).substring(1));
		}*/
		
		System.out.println(encodeString);
		
		return null;
	}
	
	private Noeud searchNodes(char c, Noeud noeud)
	{
		Noeud result = null;
	    if (noeud == null){
	    	encodeStringTemp = "";
	        return null;
	    }
	    if (noeud.getValeur() == c){
	    	//encodeString += "b";
	        return noeud;
	    }
	    if (noeud.getGauche() != null){
	    	encodeStringTemp += "0";
	        result = searchNodes(c,noeud.getGauche());
	        //encodeString = "";
	    }
	    if (result == null){
	    	encodeStringTemp += "1";
	    	if(noeud.getDroite() != null){
	    		if(noeud.getDroite().getValeur() == c){
	    			encodeStringTemp += "1";
	    		}
	    	}
	        result = searchNodes(c,noeud.getDroite());
	       // encodeString = "";
	    }
	    
	    return result;
	}
	
	
	
	
}
