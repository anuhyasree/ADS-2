import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int a = Integer.parseInt(input.nextLine());
    int b = Integer.parseInt(input.nextLine());
    Digraph di = new Digraph(a);
    while (input.hasNext()) {
      String strg = input.nextLine();
      String[] values = strg.split(" ");
      di.addEdge(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    }
    DirectedCycle cy = new DirectedCycle(di);
    if (cy.hasCycle()) {
      for (Stack<Integer> s : cy.lists) {
        TreeSet<Integer> treeset = new TreeSet<Integer>();
        for (Integer i : s) {
          treeset.add(i);
        }
        System.out.println(treeset.toString().replace("[","").replace("]",""));
      }
      //System.out.println(s.substring(0, s.length() - 2));
    } else {
      System.out.println("No Self Beneficiaries.");
    }
  }
}

