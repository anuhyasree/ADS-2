import java.util.*;

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] str = input.nextLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		Digraph di = new Digraph(a);
		String[] letter = input.nextLine().split(",");
		while (input.hasNext()) {
			String strg = input.nextLine();
			String[] values = strg.split(" ");
			di.addEdge(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
		}
		Topological tp = new Topological(di);
		if (tp.isDAG()){
			System.out.println("true");
		} else{
			System.out.println("false");
		}
	}
}

