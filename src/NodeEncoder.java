import java.util.ArrayList;

public class NodeEncoder{
	
	private Noeud noeudRacine;
	private ArrayList<Character> texteAEncoderList;
	private String encodeStringTemp="";
	private String encodeString="";
	
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
			encodeString += encodeStringTemp;
				
		}
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
