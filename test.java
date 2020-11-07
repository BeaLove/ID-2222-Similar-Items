import java.util.Random; 

public class test {


    public static void  main(String[] args) {
        System.out.println("hello doing random numbers");
        Random rand = new Random();
        int[] coeff = rand.ints(0, 11).distinct().limit(10).toArray();
        for (int c: coeff){
            System.out.println(c);
        }
        
    }

    
}