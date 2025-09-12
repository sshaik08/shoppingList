
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<String> shoppingList = new LinkedList<>();

/*
        System.out.print("Enter an item to add to the shopping list: ");
        String item1 = input.nextLine();
        Node<String> root = new Node<>(item1);
*/
        System.out.print("Enter the number of items you wish to add: ");
        int numItems = input.nextInt();

        for (int i = 0; i <= numItems; i++) {
            String inp = input.nextLine();
            shoppingList.add(inp);
        }

        System.out.println();
        System.out.println(shoppingList);
    }
}
