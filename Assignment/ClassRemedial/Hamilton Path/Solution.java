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
		// DirectedCycle dc = new DirectedCycle(di);
		// if(dc.hasCycle()) {
		// 	HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		// 	Topological tp = new Topological(di);
		// 	for(int i: tp.order()) {
		// 		System.out.println(i);
		// 	}
		// } else {
		// 	System.out.println("False");
		// }
		Topological tl = new Topological(di);
		for(int I : tl.order()) {
			System.out.println(I);
		}
		// if (!tp.hasOrder()){
		// 	System.out.println("True");
		// } else{
		// 	System.out.println("False");
		// }
	}
}

