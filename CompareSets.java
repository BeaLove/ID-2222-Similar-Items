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

        double union_size = (double) union.size();
        //System.out.println("union size " + union_size);
        set_1.retainAll(set_2);
        double intersection_size = (double) set_1.size();
        //System.out.println("intersection size " + intersection_size);
        if(union.size() == 0){
            //System.out.println("-1");
            return -1;
        }else {
            double result = intersection_size/union_size;
            //System.out.println("result" + result);
            return result;


        }
    }   
}