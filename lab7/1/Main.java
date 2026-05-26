class SumThread extends Thread {
    private int[] array;      
    private int from;         
    private int to;           
    private long result;      

    public SumThread(int[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
        this.result = 0;
    }

    @Override
    public void run() {
        for (int i = from; i < to; i++) {
            result += array[i];
        }
        System.out.println(Thread.currentThread().getName() +
            " посчитал частичную сумму: " + result);
    }

    public long getResult() {
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int mid = array.length / 2;

        SumThread t1 = new SumThread(array, 0, mid);
        SumThread t2 = new SumThread(array, mid, array.length);

        t1.start(); 
        t2.start(); 

        t1.join();
        t2.join();

        long total = t1.getResult() + t2.getResult();
        System.out.println("Итоговая сумма: " + total);
    }
}
