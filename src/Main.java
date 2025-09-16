
import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        LinkedList<String> shoppingList = new LinkedList<>();

/*
        System.out.print("Enter an item to add to the shopping list: ");
        String item1 = input.nextLine();
        Node<String> root = new Node<>(item1);
*/

        File file = new File("/Users/sshaik/Downloads/test3.txt");
        System.out.println("Enter 'o' to open your previous shopping list or enter 'n' to write a new one");
        if(input.nextLine().equals("n")) {
            System.out.print("Enter the number of items you wish to add: ");
            int numItems = input.nextInt();
            for (int i = 0; i <= numItems; i++) {
                String inp = input.nextLine();
                shoppingList.add(inp);
            }
            System.out.println();
            // System.out.println(shoppingList);
            // to write data to a file
            FileWriter fw = new FileWriter(file);
            String str = "Your most recent shopping list: " + "\n" + shoppingList.toString();
            fw.write(str);
            fw.close();
        } else if(input.nextLine().equals("o")) {
            FileReader fr = new FileReader(file);
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        }
    }
}
