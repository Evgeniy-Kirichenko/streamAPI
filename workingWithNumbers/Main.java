package streamAPI.workingWithNumbers;
/*
Составьте ArrayList из набора чисел 1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4 и
произведите над ним следующие действия:

Отфильтруйте положительные числа.
Найдите среди этих положительных чисел четные.
Отсортируйте отфильтрованные числа в порядке возрастания.
Выведите результат на экран.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < intList.size(); i++) {
            if ((intList.get(i) > 0) && (intList.get(i) % 2 == 0)) {
                result.add(intList.get(i));
            }
        }
        result.sort(Comparator.naturalOrder());
        System.out.println(result);
    }
}
