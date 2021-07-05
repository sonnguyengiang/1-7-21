public class OddThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i%2!=0){
                try {
                    Thread.sleep(15);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
