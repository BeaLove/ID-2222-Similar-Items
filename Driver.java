public class Driver {
    public static void main(String[] args ){
        int k = Integer.parseInt(args[0]);
        String filename = args[1];

        Shingling shingling = new Shingling(k, filename);
        shingling.readFromFile();
        shingling.hashShingle();

    }
}
