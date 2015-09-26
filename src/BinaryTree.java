import java.util.ArrayList;
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
		
		boolean firstTime = true;
		

		List<Entry<Character, Integer>> entryList =
			    new ArrayList<Map.Entry<Character, Integer>>(table.getFreqTable().entrySet());
		System.out.println(entryList.get(entryList.size()-1));
		//System.out.println(entryList.get(entryList.size()-2));
		// /Users/Phil/Desktop/test_log320
		//System.out.println(entryList.get(entryList.size()-1).getKey());
		//System.out.println(entryList.get(entryList.size()-1).getValue());
		
		
		if(firstTime){
		listNoeud.add(new Noeud(entryList.get(entryList.size()-1).getKey().charValue(),entryList.get(entryList.size()-1).getValue().intValue()));
		listNoeud.add(new Noeud(entryList.get(entryList.size()-2).getKey().charValue(),entryList.get(entryList.size()-2).getValue().intValue()));
		
		listNoeud.add(new Noeud(' ',entryList.get(entryList.size()-1).getValue().intValue()+entryList.get(entryList.size()-2).getValue().intValue(),listNoeud.get(1),listNoeud.get(0)));
		}
		else{
			
		}
		Noeud theFusionNoeud = listNoeud.get(listNoeud.size()-1);
		
		entryList.remove(entryList.size()-1);
		entryList.remove(entryList.size()-2);
		
		//entryList.add(entryList.size()-1, new cMap.Entry<Character, Integer>(theFusionNoeud.getValeur(), theFusionNoeud.getFrequence()));
		
		/*table.freqTable.remove(entryList.get(entryList.size()-1).getKey().charValue());
		table.freqTable.remove(entryList.get(entryList.size()-2).getKey().charValue());
		System.out.println(theFusionNoeud.getFrequence());
		table.freqTable.put(theFusionNoeud.getValeur(),theFusionNoeud.getFrequence());*/
		
		System.out.println(table.freqTable);
		
		//System.out.println(listNoeud);
		
//		System.out.println(table.getFreqTable().get(1).toString());
//		System.out.println(table.getFreqTable().get(table.getFreqTable().size()-2).toString());
		
		return null;
	} 
	
	

}
