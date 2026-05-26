import java.util.Arrays;

public class ArrayAverage {
    public static void main (String[] args){
        Object[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                if (!(arr[i] instanceof Integer)) {
                    throw new ArrayStoreException("Элемент не является числом: " + arr[i]);
                }
                sum += (Integer) arr[i];
            }
            System.out.println("Массив: " + Arrays.toString(arr));
            System.out.println("Среднее арифметическое: " + (double) sum / arr.length);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        } catch (ArrayStoreException e) {
            System.out.println(e.getMessage());
        }
    }
}
