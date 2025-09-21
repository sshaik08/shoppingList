
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

        File file = new File("shoppingList.txt");
        System.out.print("Enter 'o' to open your previous shopping list or enter 'n' to write a new one: ");
        if (input.nextLine().equals("n")) {
            System.out.print("Enter the number of items you wish to add: ");
            int numItems = input.nextInt();
            for (int i = 0; i <= numItems; i++) {
                String inp = input.nextLine();
                shoppingList.add(inp);
            }
            System.out.println("siez 1: " + shoppingList.size());
            System.out.println();
            // System.out.println(shoppingList);
            // to write data to a file
            FileWriter fw = new FileWriter(file);
            String str = "Your most recent shopping list: " + "\n" + shoppingList.toString();
            fw.write(str);
            fw.close();
            System.out.println("siez 2: " + shoppingList.size());
            System.out.println("actual file content 1: " + file);
            Scanner fileContent = new Scanner(new File("/Users/sshaik/IdeaProjects/projbasedprogramming2526/project2/shoppingList/shoppingList.txt"));
            while (fileContent.hasNextLine())
            {
                System.out.println(fileContent.nextLine()+" :D");
            }
        } else if (input.nextLine().equals("o")){
            System.out.println("siez 3: " + shoppingList.size());
            FileReader fr = new FileReader(file);
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println("siez 4: " + shoppingList.size());
            System.out.println("actual file content 2: " + file);
        }

//        for (int i = 0; i < shoppingList.size(); i++) {
//            System.out.println(shoppingList.get(i));
//        }

        System.out.println("siez 5: " + shoppingList.size());
        System.out.print("Enter 'r' to remove an item or 'a' to add an item: ");
        if (input.nextLine().equals("r")) {
            System.out.print("Enter the index of the item to be removed from the list: ");
            System.out.println("The item you wish to remove is " + shoppingList.get(input.nextInt()));
            shoppingList.remove(input.nextInt());
            System.out.println("new shopping list: ");
            for (int i = 0; i <= shoppingList.size(); i++) {
                System.out.println(shoppingList.get(i));
            }

        }
    }
}
