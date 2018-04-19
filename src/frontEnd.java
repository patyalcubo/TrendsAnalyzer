
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class frontEnd {
	// Codigo Paty
	
	//public static String[] ignoredValues = {"is", "and","your", "the","above", "about", "across", "against", "along", "among", "around", "at", "before", "behind", "below", "beneath", "beside", "between", "beyond", "by", "down", "during", "except", "for", "from", "in", "inside", "into", "like", "near", "of", "off", "on", "since", "to", "toward", "through", "under", "until", "up", "upon", "with", "within"};

	public static void main(String[] args) {
		String fileNameDefined = "src/example.csv";
		File file = new File(fileNameDefined);

		Map<String, Integer> valores = new HashMap();

		try {
			Scanner inputStream = new Scanner(file);
			int  i = 0;
			while (inputStream.hasNext() & i < 10) {
				String data = inputStream.next();
				String name[];
				name = data.split(",");
				//if (!Arrays.asList(ignoredValues).contains(name[0])){
				if (Character.isUpperCase(name[0].charAt(0))){
					valores.put(name[0], Integer.parseInt(name[1]));
				}
			}
			
			Map<String, Integer> valoresSorted = sortByValues(valores);
			System.out.println(valores);
			System.out.println("");
			System.out.println(valoresSorted);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static HashMap<String, Integer> sortByValues(Map<String, Integer> map) { 
		List list = new LinkedList(map.entrySet());
	    // Defined Custom Comparator here
	    Collections.sort(list, new Comparator() {
	         public int compare(Object o1, Object o2) {
	            return -((Comparable) ((Map.Entry) (o1)).getValue())
	               .compareTo(((Map.Entry) (o2)).getValue());
	         }
	    });

	    // Here I am copying the sorted list in HashMap
	    // using LinkedHashMap to preserve the insertion order
	    HashMap sortedHashMap = new LinkedHashMap();
	    for (Iterator it = list.iterator(); it.hasNext();) {
	           Map.Entry entry = (Map.Entry) it.next();
	           sortedHashMap.put(entry.getKey(), entry.getValue());
	    } 
	    return sortedHashMap;
	}
	
}





