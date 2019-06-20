import java.util.*;


public class Solution{
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
		DirectedCycle dick = new DirectedCycle(di);
		if (dick.hasCycle()){
			System.out.println("Cycle exists.");
		} else{
			System.out.println("Cycle doesn't exists.");
		}

	}
}