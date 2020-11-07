import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


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
        //double[][] jaccardMatrix = new double[list_size][list_size];
        CompareSets jaccard = new CompareSets();
        ArrayList<Set<String>> similar_documents = new ArrayList<>();
        for(int i = 0; i < list_size; i++){
            for(int j = 0; j < list_size; j++){
                String doc1 = filenames.get(i);
                String doc2 = filenames.get(j);
                Set<String> names = new HashSet<>();
                names.add(doc1);
                names.add(doc2);
                if (similar_documents.contains(names) || doc1 == doc2){
                    ///System.out.println("skip");
                    continue;
                }
                else{
                    double similarity =  jaccard.jaccardSimilarity(shingles_list.get(i), shingles_list.get(j));
                    //System.out.println("jaccard similar " + names + " similarity: " + similarity);
                    similar_documents.add(names);
                }
            }
        System.out.println();
        }
         
        MinHash minHash = new MinHash(100,  shingles_list);
        int[][] minhash_signatures = minHash.minHash();
        CompareSignatures compare = new CompareSignatures();
        ArrayList<Set<String>> similar_docs = new ArrayList<>();
        for (int i = 0; i < minhash_signatures.length; i++){
            for (int j = 0; j < minhash_signatures.length - i; j++){
                String doc1 = filenames.get(i);
                String doc2 = filenames.get(j);
                Set<String> names = new HashSet<>();
                names.add(doc1);
                names.add(doc2);
                if (similar_docs.contains(names) || doc1 == doc2){
                    continue;
                }
                else {
                    float min_similarity = compare.compare(minhash_signatures[i], minhash_signatures[j]);
                    System.out.println("minhash similar: " + names + "similarity: " + min_similarity);
                    }
                }
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
        //System.out.println(filenames);
        return filenames;
    }



}
