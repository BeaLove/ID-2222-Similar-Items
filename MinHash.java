import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * @author Lazar Cerovic & Beatrice Lovely (2020)
 * A class MinHashing that builds a minHash signature (in the form of a vector or a set) of a
 * given length n from a given set of integers (a set of hashed shingles).
 */
public class MinHash {
    //A class MinHash that computes the MinHash signatures of a given set of documents and returns it as a 
    //IN: number of hash functions, list of all documents as sets of hashed shingles
    //OUT: n x s signature matrix where each column s is the MinHash signature of a document,
    private int n_hash;
    private ArrayList<HashSet<Integer>> docs; //Array of all documents as sets of shingles
    public int[][] signatures; //array of vectors of unique minhash signatures
    private int[] coeff_a; //constants to use for hash functions
    private int[] coeff_b;


    public MinHash(int num_hash, ArrayList<HashSet<Integer>> collection_docs) {
        docs = collection_docs;
        int s = docs.size();
        n_hash = num_hash;
        signatures = new int[s][n_hash];
        Integer inf = Integer.MAX_VALUE;
        for (int i = 0; i < s; i++){
            for (int j = 0; j < n_hash; j++){
                signatures[i][j] = inf;
            }
        }
        makeHashConstants();
    }

    public void makeHashConstants() {
        //generates constants to use in hash functions
        int c = 10007;
        Random rand = new Random();
        coeff_a = rand.ints(1, c).distinct().limit(n_hash).toArray();
        coeff_b = rand.ints(0, c).distinct().limit(n_hash).toArray();
        
    }

    public int hash(int x, int a, int b){
        //computes hash value of input x
        int c = 10007; //constant prime number closest to maximum expected value of x
        return (a*x + b) % c;
    }

    public int[][] minHash() {
        //generates the minhash signatures of all documents
        int num_docs = docs.size();
        //int[][] signatures = new int[n][num_docs];
        for(int d = 0; d < num_docs; d++){
            for (int shingle: docs.get(d)){
                for (int h = 0; h < n_hash; h++ ){
                    int hash_val = hash(shingle, coeff_a[h], coeff_b[h]);
                    if (hash_val < signatures[d][h]){
                        signatures[d][h] = hash_val;
                    }
                }
            }
        }
        return signatures;
    }

}