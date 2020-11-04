import java.util.ArrayList;

/**
 * @author Lazar Cerovic & Beatrice Lovely (2020)
 * A class CompareSignatures that estimates similarity of two integer vectors – minhash
 * signatures – as a fraction of components, in which they agree.
 */
public class CompareSignatures {
    private int [][] signartureArray;
    private int size;
    public CompareSignatures(int[][] signatureMatrix, int vectorSize){
        signartureArray = signatureMatrix;
        size = vectorSize;

    }


    public int compare(){
        int sim = 0;
        for(int i = 0; i < size; i++){ //For each row
            if(signartureArray[i][0] == signartureArray[i][1]){
                sim++;
            }
        }
        return sim/size;
    }
}
