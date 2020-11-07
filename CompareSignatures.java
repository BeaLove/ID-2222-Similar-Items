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
        float sim = 0;
        float size = sig1.length;
        for (int i = 0; i < size; i++){
            //System.out.println(sig1[i] + " " + sig2[i]);
            if (sig1[i] == sig2[i]) {
                //System.out.println("same");
                sim++;
            }
        }
        float similarity = sim/size;

        return similarity;
    }
        
}
