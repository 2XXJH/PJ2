package Jhiron_Maven;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Jhiron_Maven.Rectangle;

/**
 * Main class for the QuadTree project. It reads commands from a file and performs
 * operations on the quadtree such as insert, delete, find, update, and dump.
 */
public class Main {

    /**
     * Main method that processes the input file containing commands to manipulate the quadtree.
     * 
     * @param args The command line arguments. It expects one argument: the path to the command file.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <file.cmmd>");
            return;
        }

        QuadTree quadTree = new QuadTree();

        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String command = parts[0];
                
                switch (command) {
                    case "INSERT":

                    	double insertX = Double.parseDouble(parts[1]);
                        double insertY = Double.parseDouble(parts[2]);
                        double insertWidth = Double.parseDouble(parts[3]);
                        double insertHeight = Double.parseDouble(parts[4]);
                        quadTree.insert(insertX, insertY, insertWidth, insertHeight);
                        break;

                    case "FIND":
                    
                        double findX = Double.parseDouble(parts[1]);
                        double findY = Double.parseDouble(parts[2]);
                        Rectangle found = quadTree.find(findX, findY);
                        System.out.println(found != null ? found : "Rectangle not found");
                        break;

                    case "DELETE":
                       
                        double deleteX = Double.parseDouble(parts[1]);
                        double deleteY = Double.parseDouble(parts[2]);
                        quadTree.delete(deleteX, deleteY);
                        break;

                    case "DUMP":
                        quadTree.dump();
                        break;

                    default:
                        System.out.println("Unknown command: " + command);
                        break;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
        }
    }
}
