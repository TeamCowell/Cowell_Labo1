import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
/*****
 * 
 * 
 * @author 
 *
 */
public class FrequencyTableReader{
	String path;
	HashMap<Character, Integer> freqTable 
		= new HashMap<Character, Integer>();
	
	
	public FrequencyTableReader(String path){
		this.path = path;
	}
	
	public void readFile() throws IOException{
//		System.out.println(path);
		FileReader fr = new FileReader(path);
		BufferedReader reader = new BufferedReader(fr);
//		System.out.println(reader.read());
		int car;
		int i;
		while( ( car = reader.read() ) != (-1)){
			System.out.println((char)car);
			if(freqTable.containsKey( (Character)(char)car )){ 	//char existe
				//incrementer le int
				i = freqTable.get((Character)(char)car);
				i++;
				freqTable.put((char)car, i);
//				freqTable.put((char)car, freqTable.get(car)+ 1);
				
			} else{
				//ajouter le char et mettre le int a 1
				freqTable.put((char) car, 1);
			}
		}
		System.out.println(freqTable);
		freqTable = (HashMap<Character, Integer>) sortByValue(freqTable);
		System.out.println(freqTable);
		
		reader.close();
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> 
	sortByValue( Map<K, V> map )
	{
		Map<K,V> result = new LinkedHashMap<>();
		Stream <Entry<K,V>> st = map.entrySet().stream();

		st.sorted(Comparator.comparing(e -> e.getValue()))
		.forEach(e ->result.put(e.getKey(),e.getValue()));

		return result;
}

}

//class ValueComparator implements Comparator {
//    Map base;
//
//    public ValueComparator(Map base) {
//        this.base = base;
//    }
//
//    // Note: this comparator imposes orderings that are inconsistent with
//    // equals.
//    @Override
//    public int compare(Object a, Object b) {
//        if (base.get((String)a) >= base.get((String)b)) {
//            return -1;
//        } else {
//            return 1;
//        } // returning 0 would merge keys
//    }
//
//	}
//}
