/**
 * @author Lazar Cerovic & Beatrice Lovely (2020)
 * Driver class for homework 1: Finding Similar Items: Textually Similar Documents in Data mining course
 */

public class Driver {
    public static void main(String[] args ){
        int k = Integer.parseInt(args[0]);
        String filename = args[1];
        //Måste göras för alla dokument
        Shingling shingling = new Shingling(k, filename);
        shingling.readFromFile();
        shingling.hashShingle();

    }
}
