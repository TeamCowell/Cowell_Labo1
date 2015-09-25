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
		
		List<Entry<Character, Integer>> entryList =
			    new ArrayList<Map.Entry<Character, Integer>>(table.getFreqTable().entrySet());
		System.out.println(entryList.get(entryList.size()-1));
		System.out.println(entryList.get(entryList.size()-2));
//		System.out.println(table.getFreqTable().get(1).toString());
//		System.out.println(table.getFreqTable().get(table.getFreqTable().size()-2).toString());
		return null;
	} 
	
	

}
