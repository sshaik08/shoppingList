import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        LinkedList<String> shoppingList = new LinkedList<>();

        // creating the text file for the shopping list
        File file = new File("shoppingList.txt");

        // asks the user if they are opening an existing shopping list or beginning a new one
        System.out.print("Enter 'o' to open your previous shopping list or enter 'n' to write a new one: ");
        String choice1 = input.nextLine();
        if (choice1.equals("n")) {
            newList(input, shoppingList);
        } else if (choice1.equals("o")){
            shoppingList = loadList();
            System.out.println("Loaded list: " + "\n" + shoppingList);
        } else {
            System.out.println("invalid response");
        }

        // continuously asks the user if they want to add or remove an item to the list until they quit
        String choice2;
        while(true) {
            System.out.print("Enter 'r' to remove an item, 'a' to add an item, or 'q' to quit: ");
            choice2 = input.nextLine();

            if (choice2.equals("r")) {
                removeItem(input, shoppingList);
                saveList(shoppingList);
                System.out.println("Updated list: " + "\n" + shoppingList);
            } else if (choice2.equals("a")) {
                addItem(input, shoppingList);
                saveList(shoppingList);
                System.out.println("Updated list: " + "\n" + shoppingList);
            } else if (choice2.equals("q")) {
                break;
            } else {
                System.out.println("invalid response");
            }
        }
    }

    /**
     * Saves the shopping list in the .txt file line by line
     * @param shoppingList the linkedList in which the items of the shopping list are saved
     */
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

    /**
     * Loads the shopping list as a linked list object by reading each separate line in the txt file and adding
     * the content of the line to the shopping list object
     * @return the shopping list in a linked list object that can be read by the java program
     * @throws IOException This exception is thrown if the shoppingList.txt file is not found
     */
    public static LinkedList<String> loadList() throws IOException {
        LinkedList<String> shoppingList = new LinkedList<>();
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader("shoppingList.txt");
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        while((line = br.readLine()) != null) {
            shoppingList.add(line);
        }
        return shoppingList;
    }

    /**
     * Writes a new shopping list, taking in input from the user to make the list a certain size and adding that number
     * of items from the user
     * @param input the int value of the size of the linked list and the String values of each item added to the linked list
     * @param shoppingList the shopping list in a linked list object that can be read by the java program
     */
    public static void newList(Scanner input, LinkedList<String> shoppingList) {
        System.out.print("Enter the number of items you wish to add: ");
        int numItems = input.nextInt();
        for (int i = 0; i <= numItems; i++) {
            String inp = input.nextLine();
            shoppingList.add(inp);
        }
        System.out.println();
        saveList(shoppingList);
        System.out.println("New list saved successfully");
        System.out.println(shoppingList);

    }

    /**
     * Removes an item from the shopping list object given the index of the item
     * @param input the index of the item to be removed from the linked list
     * @param shoppingList the shopping list in a linked list object that can be read by the java program
     */
    public static void removeItem(Scanner input, LinkedList<String> shoppingList) {
        System.out.println("Current list: " + "\n" + shoppingList);
        System.out.print("Enter the index (begins at 1) of the item to be removed from the list: ");
        int index = input.nextInt();
        input.nextLine();
        if (index > 0 && index <= shoppingList.size()) {
            System.out.println(shoppingList.remove(index) + " successfully removed from list");
        } else {
            System.out.println("invalid index");
        }
    }

    /**
     * Adds an item to end of the shopping list object given the String value of the item
     * @param input the String value of the item to be added to the linked list
     * @param shoppingList the shopping list in a linked list object that can be read by the java program
     */
    public static void addItem(Scanner input, LinkedList<String> shoppingList) {
        System.out.println("Current list: " + "\n" + shoppingList);
        System.out.print("Enter the name of the item to be added to the list: ");
        String item = input.nextLine();
        shoppingList.add(item);

    }
}

