import java.util.HashSet;
/**
 * @author Lazar Cerovic & Beatrice Lovely (2020)
 * A class CompareSets that computes the Jaccard similarity of two sets of integers – two
 * sets of hashed shingles.
 */
public class CompareSets {


    public CompareSets() {
    }
   
    public float jaccardSimilarity(HashSet<Integer> set_1, HashSet<Integer> set_2) {
        int a = set_1.size();
        int b = set_2.size();
        HashSet<Integer> intersection = new HashSet<Integer>(set_1);
        intersection.retainAll(set_2);
        int union = (a+b-intersection.size());
        if(union <= 0){
            return 0;
        }else {
            return (float) intersection.size() / union;
        }
    }   
}