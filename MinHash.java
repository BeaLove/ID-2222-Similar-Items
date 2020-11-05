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
    private HashSet<Integer>[] docs; //Array of all documents as sets of shingles
    public int[][] signatures; //array of vectors of unique minhash signatures
    private int[][] hash_constants; //constants to use for hash functions
    private HashSet<Integer> master_set; //master set of all shingles contained in all documents
    public MinHash(int n_hash, HashSet<Integer> doc) {
        int s = doc.size();
        this.n_hash = n_hash;
        int[][] signatures = new int[n_hash][s];
        Integer inf = Integer.MAX_VALUE;
        for (int i = 0; i < n_hash; i++){
            for (int j = 0; j < s; j++){
                signatures[i][j] = inf;
            }
        }
        makeHashConstants(n_hash);
        makeMasterSet();
    }

    public void makeHashConstants(int n_funcs) {
        //generates constants to use in hash functions
        int[][] hash_constants = new int[this.n_hash][2];
        int c = 9973;
        Random rand = new Random();
        for (int n = 0; n < n_funcs; n++) {
            hash_constants[n][0] = rand.nextInt(c) + 1;
            hash_constants[n][1] = rand.nextInt(c);
        }
        this.hash_constants = hash_constants;
    }

    public int hash(int x, int a, int b){
        //computes hash value of input x
        int c = 9973; //constant prime number closest to maximum expected value of x
        return (a*x + b) % c;
    }

    public void makeMasterSet() {
        HashSet<Integer> master_set = new HashSet<Integer>();
        //creates a master list of all shingles contained in all documents
        for (int i = 0; i < docs.length; i++){
            master_set.addAll(docs[i]);
        }
        this.master_set = master_set;
    }

    public int[][] minHash() {
        //generates the minhash signatures of all documents
        int num_docs = docs.length;
        int n = this.n_hash;
        int[][] signatures = new int[n][num_docs];
        for(int d = 0; d < num_docs; d++){
            for(int shingle: this.master_set) {
                if (docs[d].contains(shingle)) {
                    for (int h = 0; h < n; h++ ){
                        int hash_val = hash(shingle, this.hash_constants[h][0], this.hash_constants[h][1]);
                        if (hash_val < signatures[h][d]){
                            signatures[h][d] = hash_val;
                        }
                    }
                }
            }
        }
        return signatures;
    }

}