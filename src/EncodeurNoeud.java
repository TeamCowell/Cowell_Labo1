import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class EncodeurNoeud{
	
	public static Noeud noeudRacine;
	private ArrayList<Character> texteAEncoderList;
	private String encodeStringTemp="";
	private String encodeString = "";
	private Byte[] byteArray;
	private String decodingString = "";
	private String stringEncodedData;
	private String outputFileName;
	
	
	public EncodeurNoeud(Noeud noeud,ArrayList<Character> texteAEncoderList){
		this.noeudRacine = noeud;
		this.texteAEncoderList = texteAEncoderList;
	}
	
	 public EncodeurNoeud() {
		// TODO Auto-generated constructor stub
	}

	public static Map<Character, String> genererCharCode(Set<Character> chars, Noeud node) {
	       final Map<Character, String> map = new HashMap<Character, String>();
	       doCode(node, map, "");
	       return map;
	    }


	    private static void doCode(Noeud noeud, Map<Character, String> map, String s) {
	        if (noeud.gauche == null && noeud.droite == null) {
	            map.put(noeud.valeur, s);
	            return;
	        }    
	        doCode(noeud.gauche, map, s + '0');
	        doCode(noeud.droite, map, s + '1' );
	    }
	
	public static String encoderMessage(Map<Character, String> charCode, String textFileString) {
		final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < textFileString.length(); i++) {
            stringBuilder.append(charCode.get(textFileString.charAt(i)));
        }
        return stringBuilder.toString();
	}
	
	 public static void createFile(String message, String filename,String header) throws IOException {
	        final BitSet bitSet = getBitSet(message);
	        //System.out.println(bitSet.size());
	        //header += ";;;";
	        String outputFileName = filename.substring(0, filename.length()-3) + "sap";

	        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outputFileName))){

	        	outputStream.writeObject(header + System.getProperty("line.separator") + bitSet.previousSetBit(bitSet.size()) + System.getProperty("line.separator") +  bitSet);
	        	
	        	System.out.println("The file has been created under the name "+outputFileName);
	        } 
	        
	    }
	 
	    public static BitSet getBitSet(String message) {
	        final BitSet bitSet = new BitSet();
	        int i = 0;
	        for (i = 0; i < message.length(); i++) {
	            if (message.charAt(i) == '0') {
	                bitSet.set(i, false);
	            } else {
	                bitSet.set(i, true);
	            }
	        }
	        bitSet.set(i, true); // dummy bit set to know the length 
	        return bitSet;
	    }
	
	
	
}
