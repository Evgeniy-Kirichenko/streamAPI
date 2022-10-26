package streamAPI.workingWithNumbers;
/*
Составьте ArrayList из набора чисел 1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4 и
произведите над ним следующие действия:

Отфильтруйте положительные числа.
Найдите среди этих положительных чисел четные.
Отсортируйте отфильтрованные числа в порядке возрастания.
Выведите результат на экран.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        Stream<Integer> stream = intList.stream();
        stream.filter(x -> x > 0).filter(x -> x%2 == 0).sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }
}
