import java.util.ArrayList;

/**
 * @author Lazar Cerovic & Beatrice Lovely (2020)
 * A class CompareSignatures that estimates similarity of two integer vectors – minhash
 * signatures – as a fraction of components, in which they agree.
 */
public class CompareSignatures {
    private ArrayList<Integer> singature1, signature2;

    public CompareSignatures(ArrayList<Integer> sign1, ArrayList<Integer> sign2){
        singature1 = sign1;
        signature2 = sign2;
        
    }
}
