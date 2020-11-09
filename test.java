import java.util.Arrays;
import java.util.Random; 

public class test {


    public static void  main(String[] args) {
        System.out.println("hello doing random numbers");
        Random rand = new Random();
        int[] coeff = rand.ints(0, 11).distinct().limit(10).toArray();
        int[] test = {1,2,3,4,5};
        for (int c: coeff){
            //System.out.println(c);
        }
        int[] slice = Arrays.copyOfRange(test, 0, 3);
        for (int s: slice){
            System.out.println(s);
        }
    }

    
}