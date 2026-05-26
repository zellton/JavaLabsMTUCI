class RowMaxThread extends Thread {
    private int[] row;       
    private int rowIndex;    
    private int maxVal;      

    public RowMaxThread(int[] row, int rowIndex) {
        this.row = row;
        this.rowIndex = rowIndex;
        this.maxVal = Integer.MIN_VALUE; 
    }

    @Override
    public void run() {
        for (int val : row) {
            if (val > maxVal) {
                maxVal = val;
            }
        }
        System.out.println("Поток для строки " + rowIndex +
            " нашёл максимум: " + maxVal);
    }

    public int getMaxVal() {
        return maxVal;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
            {3, 7, 2},
            {8, 1, 5},
            {4, 9, 6}
        };

        int rows = matrix.length;
        RowMaxThread[] threads = new RowMaxThread[rows];

        for (int i = 0; i < rows; i++) {
            threads[i] = new RowMaxThread(matrix[i], i);
            threads[i].start();
        }

        for (int i = 0; i < rows; i++) {
            threads[i].join();
        }

        int globalMax = Integer.MIN_VALUE;
        for (RowMaxThread t : threads) {
            if (t.getMaxVal() > globalMax) {
                globalMax = t.getMaxVal();
            }
        }

        System.out.println("Глобальный максимум матрицы: " + globalMax); // 9
    }
}
