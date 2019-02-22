import java.util.*;

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		input.nextLine();
		Digraph di = new Digraph(a);
		while (input.hasNext()) {
			String strg = input.nextLine();
			String[] values = strg.split(" ");
			di.addEdge(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
		}
		Topological tp = new Topological(di);
		if (!tp.hasOrder()){
			System.out.println("True");
		} else{
			System.out.println("False");
		}
	}
}

