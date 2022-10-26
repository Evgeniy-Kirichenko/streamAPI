package streamAPI.populationCensus;
/*
Найти количество несовершеннолетних (т.е. людей младше 18 лет).
Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
Получить отсортированный по фамилии список потенциально работоспособных людей с высшим
образованием в выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
 */

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        List<String> personFamilies = new ArrayList<String>();
        List<Person> personWork = new ArrayList<Person>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        System.out.println("Количество несовершеннолетних " + persons.stream().filter(x -> x.getAge() < 18).count());
        //Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).

        personFamilies = persons.stream().
                filter(x -> (x.getAge() >= 18) || (x.getAge() < 27)).
                map(x -> x.getFamily()).
                collect(Collectors.toList());
/*
Получить отсортированный по фамилии список потенциально работоспособных людей с высшим
образованием в выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
 */
        personWork = persons.stream().filter(x -> x.getEducation().equals(Education.HIGHER)).
                filter(x -> (
                        ((x.getAge() >= 18) && (x.getAge() < 60) && x.getSex().equals(Sex.WOMAN)) ||
                                ((x.getAge() >= 18) && (x.getAge() < 65) && x.getSex().equals(Sex.MAN)))).
                sorted(Comparator.comparing(x -> x.getFamily())).collect(Collectors.toList());


    }
}
