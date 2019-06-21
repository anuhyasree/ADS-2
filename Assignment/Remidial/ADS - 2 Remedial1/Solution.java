import java.util.Scanner;

class Solution {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		int q = Integer.parseInt(input);
		int s = Integer.parseInt(input);
		Graph g = new Graph(q+1);
		for (int i = 0; i < q ; i++ ) {
			String[] str = scan.nextLine().split(" ");
			g.addEdge(Integer.parseInt(str[0]),Integer.parseInt(str[1]));

		}
		int n = 1, count = 0, flag1 = 0, flag2 = 0;
		for (int each: g.adj(q)) {
			if (g.degree(each)<n+1) {
				if (count < g.V()) {
					count = g.degree(each);
					flag1 = each;
					System.out.println(count);
				}else if (count == g.degree(each)) {
					flag2 = each;
					count+= g.degree(each);
					System.out.println(count);
				}
			}
		}


	}
}