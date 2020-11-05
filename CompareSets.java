import java.util.HashSet;
/**
 * @author Lazar Cerovic & Beatrice Lovely (2020)
 * A class CompareSets that computes the Jaccard similarity of two sets of integers – two
 * sets of hashed shingles.
 */
public class CompareSets {


    public CompareSets() {
    }
   
    public double jaccardSimilarity(HashSet<Integer> set_1, HashSet<Integer> set_2) {
        HashSet<Integer> union = new HashSet<Integer>();
        union.addAll(set_1);
        union.addAll(set_2);

        int union_size = union.size();
        set_1.retainAll(set_2);
        int intersection_size = set_1.size();
        if(union.size() == 0){
            return -1;
        }else {
            return intersection_size/union_size;
        }


    }
}