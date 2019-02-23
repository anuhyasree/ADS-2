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
      String s = "";
      int count = 0;
      for(Integer i: cy.cycle()) {
        if(count > 0) {
          s += i + ", ";
        }
        count++;
      }
      System.out.println(s.substring(0, s.length() - 1));
    } else{
      System.out.println("No Self Beneficiaries.");
    }
  }
}

