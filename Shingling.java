import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Shingling {

    private int shingle_size;
    private String filename;
    private String inputString;
    /*
    A class Shingling that constructs k–shingles of a given length k (e.g., 10) from a given
    document, computes a hash value for each unique shingle, and represents the document
    in the form of an ordered set of its hashed k-shingles.
     */

    public Shingling(int k, String fn){
        shingle_size = k;
        filename = fn;
        inputString = "";
    }


    public void readFromFile(){
        try {
            // pass the path to the file as a parameter
            File file =
                    new File(filename);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String s = sc.nextLine();
                if(s != null) {
                    inputString = inputString + s;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Shingling hash
    public HashSet<Integer> hashShingle(){
        //ArrayList<Integer> hashedShingles = new ArrayList<>();
        HashSet<Integer> hashedShingles = new HashSet<>();
        for(int i = 0; i < inputString.length(); i++){
            if((i <= inputString.length()-shingle_size)){
                String shingling = inputString.substring(i, i+shingle_size);
                //System.out.println("SHingling: " + shingling);
                hashedShingles.add(shingling.hashCode());
            }else{
                break;
            }
        }
        return hashedShingles;
    }







}
