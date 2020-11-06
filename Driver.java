import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * @author Lazar Cerovic & Beatrice Lovely (2020)
 * Driver class for homework 1: Finding Similar Items: Textually Similar Documents in Data mining course
 */

public class Driver {
    public static void main(String[] args ) throws FileNotFoundException {
        int k = 2;

        ArrayList<String> filenames = getFiles();
        ArrayList<HashSet<Integer>> shingles_list = new ArrayList<>();
        for(String fn : filenames){
            if(fn != null){
                shingles_list.add(getShingles(k, fn));
            }
        }

        int list_size = shingles_list.size();
        double[][] jaccardMatrix = new double[list_size][list_size];
        CompareSets jaccard = new CompareSets();
        for(int i = 0; i < list_size; i++){
            for(int j = 0; j < list_size; j++){
                jaccardMatrix[i][j] =  jaccard.jaccardSimilarity(shingles_list.get(i), shingles_list.get(j));
            }
        }

        int[][] minhash_signatures = new int[100][shingles_list.size()]; 
        MinHash minHash = new MinHash(100,  shingles_list);
        minhash_signatures = minHash.minHash();
        //TO DO: compare minhash signatures
        for(int i = 0; i < list_size; i++){

            shingles_list.get(i);
        }


    }




    private static HashSet<Integer> getShingles(int shingle_size, String filename){
        Shingling shingling = new Shingling(shingle_size, "raw_data/"+filename);
        shingling.readFromFile();
        return shingling.hashShingle();
    }


    private static ArrayList<String> getFiles(){
        ArrayList<String> filenames = new ArrayList<>();
        File folder = new File("raw_data");
        File[] listOfFiles = folder.listFiles();
        for(File file : listOfFiles){
            filenames.add(file.getName());
        }
        return filenames;
    }



}
