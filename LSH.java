
import java.util.ArrayList;
import java.util.Arrays;

public class LSH{
    public int[][] signatures;
    public int bands;
    public int n_signatures;
    public ArrayList<ArrayList<Integer>> lsh_signatures;
    
    public LSH(int[][] minhash_signatures, int n_bands, int num_signatures){
        signatures = minhash_signatures;
        bands = n_bands;
        n_signatures = num_signatures;
    }

    public ArrayList<ArrayList<Integer>> lsh() {
        for (int s = 0; s < n_signatures; s++){
            ArrayList<Integer> lsh_sig = new ArrayList<>();
            for (int i = 0; i < signatures.length; i += bands){
                int[] band = Arrays.copyOfRange(signatures[s], i, i+bands);
                int value = band.hashCode();
                lsh_sig.add(value);
            }
            lsh_signatures.add(lsh_sig);
        }
        return lsh_signatures;
    }

    public boolean compare(ArrayList<Integer> sig1, ArrayList<Integer> sig2){
        for (int s: sig1){
            if (sig1.get(s) == sig2.get(s)){
                return true;
            }
        }
        return false;
    }
}