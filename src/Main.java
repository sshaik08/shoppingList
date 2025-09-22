import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        LinkedList<String> shoppingList = new LinkedList<>();

        File file = new File("shoppingList.txt");

        System.out.print("Enter 'o' to open your previous shopping list or enter 'n' to write a new one: ");
        String choice = input.nextLine();
        if (choice.equals("n")) {
            System.out.print("Enter the number of items you wish to add: ");
            int numItems = input.nextInt();
            input.nextLine();
            for (int i = 0; i <= numItems; i++) {
                String inp = input.nextLine();
                shoppingList.add(inp);
            }
            System.out.println();
            saveList(shoppingList);
            System.out.println("New list saved successfully");
            System.out.println(shoppingList);

        } else if (choice.equals("o")){
            shoppingList = loadList();
            System.out.println("Loaded list: " + "\n" + shoppingList);
        } else {
            System.out.println("invalid response");
        }

        String choice2 = "";
        while(!choice2.equals("q")) {
            System.out.print("Enter 'r' to remove an item, 'a' to add an item, or 'q' to quit: ");
            choice2 = input.nextLine();

            if (choice2.equals("r")) {
                System.out.println("Current list: " + "\n" + shoppingList);
                System.out.print("Enter the index (begins at 1) of the item to be removed from the list: ");
                int index = input.nextInt();
                input.nextLine();

                if (index > 0 && index <= shoppingList.size()) {
                    System.out.println(shoppingList.remove(index) + " successfully removed from list");
                } else {
                    System.out.println("invalid index");
                }

                saveList(shoppingList);
                System.out.println("Updated list: " + "\n" + shoppingList);

            } else if (choice2.equals("a")) {
                System.out.println("Current list: " + "\n" + shoppingList);
                System.out.print("Enter the name of the item to be added to the list: ");
                String item = input.nextLine();
                shoppingList.add(item);
                saveList(shoppingList);
                System.out.println("Updated list: " + "\n" + shoppingList);
            } else if (choice2.equals("q")) {
                break;
            } else {
                System.out.println("invalid response");
            }
        }
    }

    public static void saveList(LinkedList<String> shoppingList) {
        try {
            FileWriter fw = new FileWriter("shoppingList.txt");
            for (int i = 0; i < shoppingList.size(); i++) {
                fw.write(shoppingList.get(i) + "\n");
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static LinkedList<String> loadList() throws IOException {
        LinkedList<String> shoppingList = new LinkedList<>();

        FileReader fr = new FileReader("shoppingList.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        while((line = br.readLine()) != null) {
            shoppingList.add(line);
        }
        return shoppingList;
    }
}
