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
      System.out.println("true");
    } else{
      System.out.println("No Self Beneficiaries.");
    }
  }
}

