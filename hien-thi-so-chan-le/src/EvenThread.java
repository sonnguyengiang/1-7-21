public class EvenThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i%2==0){
                try {
                    Thread.sleep(10);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
