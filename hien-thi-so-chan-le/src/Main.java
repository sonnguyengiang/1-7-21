public class Main {
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();


        Thread asd = new Thread(oddThread);
        Thread asda = new Thread(evenThread);

        asd.start();
        asda.start();
    }


}
