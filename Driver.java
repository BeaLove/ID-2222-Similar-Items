import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Lazar Cerovic & Beatrice Lovely (2020)
 * Driver class for homework 1: Finding Similar Items: Textually Similar Documents in Data mining course
 */

public class Driver {
    //CONSTANTS
    private final static int NUMBER_OF_SHINGLES = 3;
    private final static int NUMBER_OF_HASH_FUNCTIONS = 100;
    private final static float SIMILARITY_THRESHOLD = (float) 0.8;
    private final static int NUMBER_OF_BANDS = 4;
    private static ArrayList<HashSet<Integer>> shingles_list = new ArrayList<>();

    public static void main(String[] args ) {
        ArrayList<String> filenames = getFiles();

        for (String fn : filenames) {
            if (fn != null) {
                shingles_list.add(getShingles(fn));
            }
        }

        CompareSets jaccard = new CompareSets();
        ArrayList<Set<String>> similar_documents = new ArrayList<>();
            for (int i = 0; i < shingles_list.size(); i++) {
            for (int j = 0; j < shingles_list.size(); j++) {
                String doc1 = filenames.get(i);
                String doc2 = filenames.get(j);
                Set<String> names = new HashSet<>();
                names.add(doc1);
                names.add(doc2);
                if (!(similar_documents.containsAll(names) && doc1.equals(doc2))) {
                    float similarity = jaccard.jaccardSimilarity(shingles_list.get(i), shingles_list.get(j));
                    similar_documents.add(names);
                    if (SIMILARITY_THRESHOLD < similarity) {
                        System.out.println("jaccard similar " + filenames.get(i) + " AND " +
                             filenames.get(j) + " similarity: " + similarity);
                    }
                }
            }
        }

        MinHash minHash = new MinHash(NUMBER_OF_HASH_FUNCTIONS, shingles_list);
        int[][] minhash_signatures = minHash.minHash(); //minhash_signatures[docs.size()][n_hash]
        CompareSignatures compare = new CompareSignatures();
        for (int i = 0; i < minhash_signatures.length; i++) {
            for (int j = 0; j < minhash_signatures.length; j++) {
                String doc1 = filenames.get(i);
                String doc2 = filenames.get(j);
                Set<String> names = new HashSet<>();
                names.add(doc1);
                names.add(doc2);
                float min_similarity = compare.compare(minhash_signatures[i], minhash_signatures[j]);
                if (min_similarity > SIMILARITY_THRESHOLD) {
                    System.out.println("minhash similar: " + names + "similarity: " + min_similarity);
                }
            }
        }
        run_lsh(minhash_signatures, filenames);

    }

    private static void run_lsh(int[][] minhash_signatures, ArrayList<String> filenames){
        LSH lsh = new LSH(minhash_signatures, NUMBER_OF_BANDS, shingles_list.size());
        ArrayList<ArrayList<Integer>> lsh_signatures = lsh.lsh();
        for (int i = 0; i < filenames.size(); i++){
            for(int j = 0; j< filenames.size(); j++){
                if (lsh.compare(lsh_signatures.get(i), lsh_signatures.get(j))){
                    System.out.println("candidate pair: " + filenames.get(i) + " " + filenames.get(j));
                }
            }
        }
    }

    /**
     * Method that generates a hashset of shingles for every document
     * @param filename of the document
     * @return HashSet of hashed shingles
     */
    private static HashSet<Integer> getShingles(String filename){
        Shingling shingling = new Shingling(NUMBER_OF_SHINGLES, "raw_data/"+filename);
        shingling.readFromFile();
        return shingling.hashShingle();
    }

    /**
     * Lists the filenames in a ArrayList
     * @return ArrayList of filenames
     */
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
