import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BinaryTree {
	
	FrequencyTableReader table;
	ArrayList<Noeud> listNoeud = new ArrayList<Noeud>();
	
	BinaryTree(FrequencyTableReader table){
		this.table = table;
	}
	
	public Noeud encodeTree(){
		

		List<Entry<Character, Integer>> entryList =
			    new ArrayList<Map.Entry<Character, Integer>>(table.getFreqTable().entrySet());
		
		listNoeud = entryListToNoeudArrayList(entryList);

		//System.out.println(entryList.get(entryList.size()-2));
		// /Users/Phil/Desktop/test_log320
		//System.out.println(entryList.get(entryList.size()-1).getKey());
		//System.out.println(entryList.get(entryList.size()-1).getValue());
	
		
		System.out.println(listNoeud);

		System.out.println(listNoeud.get(listNoeud.size()-1));
		System.out.println(listNoeud.get(listNoeud.size()-2));
		
		listNoeud.add(new Noeud('\0',
				listNoeud.get(listNoeud.size()-1).getFrequence()+
				listNoeud.get(listNoeud.size()-2).getFrequence(),
				listNoeud.get(listNoeud.size()-2),
				listNoeud.get(listNoeud.size()-1)
				));
		listNoeud.remove(listNoeud.size()-2);
		listNoeud.remove(listNoeud.size()-2);
		
		System.out.println(listNoeud);
		listNoeud = sortDescendingNoeudArrayList(listNoeud);

		
		System.out.println(listNoeud);
		
		System.out.println(listNoeud.size());
		
		while(listNoeud.size() != 1){
			listNoeud.get(listNoeud.size()-1);
			listNoeud.add(new Noeud('\0',
					listNoeud.get(listNoeud.size()-1).getFrequence()+
					listNoeud.get(listNoeud.size()-2).getFrequence(),
					listNoeud.get(listNoeud.size()-2),
					listNoeud.get(listNoeud.size()-1)
					));
			listNoeud.remove(listNoeud.size()-2);
			listNoeud.remove(listNoeud.size()-2);
			listNoeud = sortDescendingNoeudArrayList(listNoeud);
			
		}
		System.out.println(listNoeud.size());
		
		System.out.println(listNoeud);
		
//		System.out.println(table.getFreqTable().get(1).toString());
//		System.out.println(table.getFreqTable().get(table.getFreqTable().size()-2).toString());
		
		return listNoeud.get(0);
	}

	private ArrayList<Noeud> entryListToNoeudArrayList(List<Entry<Character, Integer>> entryList) {
		
		ArrayList<Noeud> listNoeuds = new ArrayList<Noeud>();
		
		for(int i=0; i<entryList.size();i++){
			listNoeuds.add(new Noeud(entryList.get(i).getKey().charValue(),entryList.get(i).getValue().intValue()));
		}
		
		return listNoeuds;
	} 
	
	private ArrayList<Noeud> sortDescendingNoeudArrayList(ArrayList<Noeud> list){
		
		Collections.sort(list, new Comparator<Noeud>()
		{
			public int compare(Noeud n1, Noeud n2)
			{
			      int resultat = 2;
			      if (n1.getFrequence() > n2.getFrequence())
			         resultat = -1;
			      if (n1.getFrequence() < n2.getFrequence())
			         resultat = 1;
			      if (n1.getFrequence() == n2.getFrequence())
			         resultat = 0;
			      return resultat;
			}
			
		});
		
		return list;
	}
	

	

}
