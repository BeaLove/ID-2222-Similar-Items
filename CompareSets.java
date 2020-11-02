import java.util.HashSet;

public class CompareSets {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
    public CompareSets(HashSet<Integer> set_1, HashSet<Integer> set_2) {
        set1 = set_1;
        set2 = set_2;
    }
   
    public float jaccardSimilarity() {
        HashSet<Integer> union = new HashSet<Integer>();
        HashSet<Integer> intersection = new HashSet<Integer>();
        union.addAll(set1);
        union.addAll(set2);
        intersection.retainAll(set1);
        intersection.retainAll(set2);

        int union_size = union.size();
        int intersection_size = intersection.size();

        float similarity = intersection_size/union_size;

        return similarity;


    }
}