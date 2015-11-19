import java.io.*;
import java.util.*;

public class wordList {
	public static List<String> getList(String file) {
		try {
		//String word1 = "word1.txt";
		Set set = new HashSet();
		FileReader fd = new FileReader(file);
		BufferedReader br = new BufferedReader(fd);
		String line = br.readLine();
		while (line!=null) {
			String[] words = line.split("[^a-zA-Z]+");	
			for (int i=0; i<words.length; i++) {
				if (words[i].length()>0) set.add(words[i].toLowerCase());
			}
			//for (int i=0; i<words.length; i++) System.out.println(words[i]);
			line = br.readLine();
		}
		List<String> lis = new ArrayList<String>(set);
		Collections.sort(lis);
		//System.out.println(lis);
		return lis;
		}

		catch (Exception e) {
			e.printStackTrace();
			List<String> lis = new ArrayList<String>();
			return lis;
		}
	}
	
	public static List<String> compList(List<String> list1, List<String> list2) {
		/*int start = 0;
		int end = list2.size();
		char tc = 'a';
		while (list1.get(start).charAt(0)!=tc) start++;
		for (int i=0; i<list1.size(); i++) {
			list1.get(i).charAt(0);
			if a==tc : for i in (start,end) 
			else 
			//for (int j=start; )
		}
		//System.out.println(list1.get(0).charAt(0));
		System.out.println(start);*/
		list1.retainAll(list2);
		return list1;
	}

	public static void countWords(String file) {
		try {
		
		FileReader fd = new FileReader(file);
		BufferedReader br = new BufferedReader(fd);
		String line = br.readLine();
		List<String> list = new ArrayList<String>();
		List<String> table = new ArrayList<String>();

		while (line!=null) {
			String[] words = line.split("[^a-zA-Z]+");	
			for (int i=0; i<words.length; i++) {
				if (words[i].length()>0) list.add(words[i].toLowerCase());
			}
			line = br.readLine();
		}
		Collections.sort(list);
		
		Map map = new HashMap<String, Integer>();
		for (int i=0; i<list.size(); i++) {
			if (!map.containsKey(list.get(i))) {
				map.put(list.get(i), 1);
				table.add(list.get(i));
			}
			else map.put( list.get(i), (Integer)map.get(list.get(i))+1 );
			//else System.out.println(map.get(list.get(i)));
		}

		for (int i=0; i<table.size(); i++) {
			System.out.println(table.get(i) + " : " + map.get(table.get(i)));
		}
		//return table;

		}
		
		catch (Exception e) {
			//List<String> table = new ArrayList<String>();
			e.printStackTrace();
			//return table;
		}
		//map.put("List1","yeah");
	}

	public static void main(String[] args) {
			//System.out.println(getList("word1.txt"));

			//**get the list of words and count them.**//
			countWords("word1.txt");

			//**get the words that occur in both articles.**//
			List<String> inter = compList(getList("word1.txt"), getList("word2.txt"));
			System.out.println(inter);

	}
}