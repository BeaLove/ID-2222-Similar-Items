import java.util.ArrayList;
import java.util.Arrays;

public class LSH {
    private int[][] signatures;
    private int bands;
    private int n_signatures;

    public LSH(int[][] minhash_signatures, int n_bands, int num_signatures){
        signatures = minhash_signatures;
        bands = n_bands;
        n_signatures = num_signatures;
    }

    public ArrayList<ArrayList<Integer>> lsh() {
        ArrayList<ArrayList<Integer>> lsh_signatures = new ArrayList<>();
        for (int s = 0; s < n_signatures; s++){
            ArrayList<Integer> lsh_sig = new ArrayList<>();
            for (int i = 0; i < signatures.length; i += bands){
                int[] band = Arrays.copyOfRange(signatures[s], i, i+bands);
                int value = Arrays.hashCode(band);
                lsh_sig.add(value);
            }
            lsh_signatures.add(lsh_sig);
        }
        return lsh_signatures;
    }

    public boolean compare(ArrayList<Integer> sig1, ArrayList<Integer> sig2){
        for(int i = 0; i < sig1.size(); i++){
            if (sig1.get(i).equals(sig2.get(i))){
                return true;
            }
        }
        return false;
    }
}
