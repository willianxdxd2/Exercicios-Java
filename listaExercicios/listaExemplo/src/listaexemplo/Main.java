package listaexemplo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Main {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Maria");
		list.add("João");
		list.add("Pedro");
		list.add("Fernando");
		list.add("Faria");
		list.add(2, "Pietro");
		System.out.println(list.size());
		list.remove(1);
		for (String x : list) {
			System.out.println(x);
			
		}
		System.out.println("-------------------");
		list.removeIf(x -> x.charAt(0) == 'P');
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("-------------------");
		System.out.println("Index of Maria" + list.indexOf("Maria"));
		System.out.println("Index of Pedro" + list.indexOf("Pedro"));
		System.out.println("-------------------");
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'F').collect(Collectors.toList());
		for (String x : result) {
			System.out.println(x);
		}
		System.out.println("-------------------");
		String name = list.stream().filter(x -> x.charAt(0) == 'F').findFirst().orElse(null);
		System.out.println(name);
	}

}
