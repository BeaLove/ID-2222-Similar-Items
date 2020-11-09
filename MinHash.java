import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * @author Lazar Cerovic & Beatrice Lovely (2020)
 * A class MinHashing that builds a minHash signature (in the form of a vector or a set) of a
 * given length n from a given set of integers (a set of hashed shingles).
 * A class MinHash that computes the MinHash signatures of a given set of documents and returns it as a
 * IN: number of hash functions, list of all documents as sets of hashed shingles
 * OUT: n x s signature matrix where each column s is the MinHash signature of a document,
 */
public class MinHash {
    private int n_hash;
    private ArrayList<HashSet<Integer>> docs; //Array of all documents as sets of shingles
    //public int[][] signatures; //array of vectors of unique minhash signatures
    private int[][] hash_constants; //constants to use for hash functions

    /**
     * Initializes the constant global variables such as different hash function array,
     * @param num_hash number of hash functions
     * @param collection_docs Collection of all documents
     */
    public MinHash(int num_hash, ArrayList<HashSet<Integer>> collection_docs) {
        docs = collection_docs;
        n_hash = num_hash;
        /*
        signatures = new int[docs.size()][n_hash];
        Integer inf = Integer.MAX_VALUE;
        for (int i = 0; i < docs.size(); i++){
            for (int j = 0; j < n_hash; j++){
                signatures[i][j] = inf;
            }
        }
        */
        makeHashConstants();
    }

    /**
     * Assigns hash constants in the hash function
     */
    private void makeHashConstants() {
        hash_constants = new int[n_hash][2];
        int c = 9973;
        Random rand = new Random(System.currentTimeMillis());
        for (int n = 0; n < n_hash; n++) {
            hash_constants[n][0] = rand.nextInt(c) + 1;
            hash_constants[n][1] = rand.nextInt(c);
        }
    }

    /**
     * Hashes a value x
     * @param x input variable for the hashfunction
     * @param a Constant value for hashfunction
     * @param b Constant value for hashfunction
     * @return Hashvalue
     */
    private int hash(int x, int a, int b){
        int c = 9973; //constant prime number closest to maximum expected value of x
        return (a*x + b) % c;
    }


    private int[] getSignatureVector(HashSet<Integer> document){
        int[] sigArr = new int[n_hash];
        Arrays.fill(sigArr, Integer.MAX_VALUE);
        for (int shingle: document){
            for (int i = 0; i < n_hash; i++ ){
                int hash_val = hash(shingle, hash_constants[i][0], hash_constants[i][1]);
                if (hash_val < sigArr[i]){
                    sigArr[i] = hash_val;
                }
            }
        }
        return sigArr;
    }

    //generates the minhash signatures of all documents
    public int[][] minHash() {
        int[][] signatureMatrix = new int[docs.size()][n_hash];
        int[] signature;
        for(int d = 0; d < docs.size(); d++){
            signature = getSignatureVector(docs.get(d));
            for(int i = 0; i < n_hash; i++ ){
                signatureMatrix[d][i] = signature[i];
            }
        }
        return signatureMatrix;
    }

}