import java.util.ArrayList;

/**
 * @author Lazar Cerovic & Beatrice Lovely (2020)
 * A class CompareSignatures that estimates similarity of two integer vectors – minhash
 * signatures – as a fraction of components, in which they agree.
 */
public class CompareSignatures {
    
    //private int vector_size;
    //private int size;
    public CompareSignatures(){
        //signatureArray = signatureMatrix;
        //int vector_size = sig1.length;

    }


    public float compare(int[] sig1, int[] sig2){
        int sim = 0;
        for (int i = 0; i < sig1.length; i++){
            System.out.println(sig1[i] + " " + sig2[i]);
        }
        
        for (int i = 0; i < sig1.length; i++){
            if (sig1[i] == sig2[i]) {
                sim++;
            }
        }
        float similarity = sim/sig1.length;
        System.out.println(similarity);
        return similarity;
    }
        
}
