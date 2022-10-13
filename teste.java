import java.util.Vector;

public class teste{
   public static void main(String[] args) {
      Vector<Integer> teste = new Vector<Integer>();
      teste.add(5);
      teste.add(2);
      teste.add(9);
      teste.add(450);

      teste.remove(2);
      System.out.println(teste.toString());
      

      for(byte i = 0; i < teste.size(); i ++){
         System.out.println(teste.get(i));
      }

      System.out.println(teste.size() + " elementos.");
   }
}