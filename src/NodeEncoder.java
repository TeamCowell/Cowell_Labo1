import java.util.ArrayList;

public class NodeEncoder{
	
	private Noeud noeudRacine;
	private ArrayList<Character> texteAEncoderList;
	private String encodeString="";
	
	public NodeEncoder(Noeud noeud,ArrayList<Character> texteAEncoderList){
		this.noeudRacine = noeud;
		this.texteAEncoderList = texteAEncoderList;
	}
	
	public String encodeNode(){
		
		System.out.println(searchNodes('c',noeudRacine));
		
		System.out.println(encodeString);
		
		/*for(Character car : texteAEncoderList){
			
			System.out.println(car);
			searchNodes(car.charValue(),noeudRacine);
			
			
			
		}*/
		
		return null;
	}
	
	private Noeud searchNodes(char c, Noeud noeud)
	{
		Noeud result = null;
	    if (noeud == null){
	        return null;
	    }
	    if (noeud.getValeur() == c){
	        return noeud;
	    }
	    if (noeud.getGauche() != null){
	        result = searchNodes(c,noeud.getGauche());
	    }
	    if (result == null){
	        result = searchNodes(c,noeud.getDroite());
	    }
	    
	    return result;

	}
	
	
	
	
}
