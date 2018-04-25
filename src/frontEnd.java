
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
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
	
	static boolean debug = false;
	// Codigo Paty

	// public static String[] ignoredValues = {"is", "and","your",
	// "the","above", "about", "across", "against", "along", "among", "around",
	// "at", "before", "behind", "below", "beneath", "beside", "between",
	// "beyond", "by", "down", "during", "except", "for", "from", "in",
	// "inside", "into", "like", "near", "of", "off", "on", "since", "to",
	// "toward", "through", "under", "until", "up", "upon", "with", "within"};
	
	
	public static void main(String[] args) {
		sorterTopics("TheNewYork.csv");
		sorterTopics("CNN.csv");
	}

	public static void sorterTopics(String string) {

		String fileNameDefined = "src/" + string;
		File file = new File(fileNameDefined);

		ArrayList<trendTheme> list = new ArrayList<trendTheme>();

		try {
			Scanner inputStream = new Scanner(file);

			String dataDate = inputStream.next();
			LocalDate localDate = LocalDate.parse(dataDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

			System.out.println(localDate);

			while (inputStream.hasNext()) {
				String data = inputStream.next();
				String[] name;
				name = data.split(",");
				trendTheme temp = new trendTheme();
				if (Character.isUpperCase(name[0].charAt(0))) {
					temp.setName(name[0]);
					temp.setValue(Integer.parseInt(name[1]));
					list.add(temp);
					if(debug){System.out.println(list);}
				}
			}

			//ArrayList<trendTheme> listSorted = new ArrayList<trendTheme>();
			Collections.sort(list);
			System.out.println(list.subList(0, 10));
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
