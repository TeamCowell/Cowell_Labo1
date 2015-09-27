
public class Noeud{
	public int frequence;
	public char valeur;
	public Noeud gauche;
	public Noeud droite;
	
	public Noeud(){
		
	}
	
	public Noeud(char valeur, int frequence){
		this(valeur,frequence,null,null);
	}

	public Noeud(char valeur, int frequence, Noeud gauche, Noeud droite){
		this.valeur = valeur;
		this.frequence = frequence;
		this.gauche = gauche;
		this.droite = droite;
	}
	
	/*public int compareTo(Noeud unNoeud){
		return frequence - unNoeud.frequence;
	}*/
	
	public Noeud highestFrequenceCompareTo(Noeud autrenoeud) {
	      Noeud resultat = this ;
	      if (this.frequence > autrenoeud.frequence)
	         resultat = this;
	      if (this.frequence < autrenoeud.frequence)
	         resultat = autrenoeud;
	      if (this.frequence == autrenoeud.frequence)
	         resultat = this;
	      return resultat;
	}
	
	

	public int getFrequence() {
		return frequence;
	}

	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}

	public char getValeur() {
		return valeur;
	}

	public void setValeur(char valeur) {
		this.valeur = valeur;
	}

	public Noeud getGauche() {
		return gauche;
	}

	public void setGauche(Noeud gauche) {
		this.gauche = gauche;
	}

	public Noeud getDroite() {
		return droite;
	}

	public void setDroite(Noeud droite) {
		this.droite = droite;
	}

	@Override
	public String toString() {
		return "Noeud [frequence=" + frequence + ", valeur=" + valeur +
				", gauche=" + gauche +", droite=" + droite +"]";
	}

}
