import java.util.ArrayList;

/**
 * @author Lazar Cerovic & Beatrice Lovely (2020)
 * A class CompareSignatures that estimates similarity of two integer vectors – minhash
 * signatures – as a fraction of components, in which they agree.
 */
public class CompareSignatures {

    public CompareSignatures(){
    }


    public float compare(int[] sig1, int[] sig2){
        float sim = 0;
        float size = (float) sig1.length;
        
        for (int i = 0; i < sig1.length; i++){
            if (sig1[i] == sig2[i]) {
                sim++;
            }
        }
        float similarity = sim/size;
        return similarity;
    }
        
}
