import java.util.HashSet;
import java.util.Arrays;

/**Random r = new Random(11);
for (int i = 0; i < numHash; i++){
    int a = (int)r.nextInt();
    int b = (int)r.nextInt();
    int c = (int)r.nextInt();
    int x = hash(a*b*c, a, b, c);
    hash[i] = x;
} */

//TO DO generera 100 hashfunktioner

public class MinHash {
   //IN: number of hash functions, list of all documents as sets of hashed shingles
   //OUT: n x s signature matrix where each column s is the MinHash signature of a document,
   int s;
   Array<HashSet<Integer>> docs = new List<HashSet<Integer>>(); 
    public void MinHash(int hashfunc, Array<HashSet<Integer>> all_docs) {
        docs = all_docs;
        s = docs.size();
        int[][] signatures = int[hashfunc][s];
        Integer inf = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < s; j++){
                signatures[i][j] = inf;
            }
        }
    }

    public HashSet<Integer> makeMasterSet() {
        HashSet<Integer> master_set = new HashSet<Integer>();
        //loopa genom alla dokument och skapa en master list med shingles
        for (int i = 0; i < docs.size(); i++){
            master_set.addAll(docs[i]);
        }
        return master_set;
    }

    public void minHash(HashSet<Integer> master_set, List hashfunc) {
        int num_hash = hashfunc.size(); \\number of hash functions
        int shingles = master_set.size();
        int num_docs = docs.size();
        for (int i = 0; i = num_docs; i++){
            for(int s = 0; s = shingles; s++){
                if (docs[i].contains(master_set[s])){
                    for (int h = 0; h < num_hash; h++ ){
                        //TO DO anropa hashfunktionen ur listan
                        int hash_val = hash_functions[h]
                        if (hash_val < signatures[h][i]){
                            signatures[h][i] == hash_val
                        }
                    }
                }
                else {
                    continue;
                }
            }
        }
        
    }
}