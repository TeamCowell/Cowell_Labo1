
public class Noeud {
	public int frequence;
	public int valeur;
	public Noeud gauche;
	public Noeud droite;
	
	public Noeud(){
		
	}
	
	public Noeud(int valeur, int frequence){
		
	}
	
	public Noeud(int valeur, int frequence, Noeud gauche, Noeud droite){
		this.valeur = valeur;
		this.frequence = frequence;
		this.gauche = gauche;
		this.droite = droite;
	}
	
	public int compareTo(Noeud unNoeud){
		return frequence - unNoeud.frequence;
	}

	@Override
	public String toString() {
		return "Noeud [frequence=" + frequence + ", valeur=" + valeur + "]";
	}
	
	
	

}
