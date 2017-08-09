package guava;

import com.google.common.collect.Ordering;
import common.Persons;

import java.util.*;

/**
 * Created by yuehao on 2017/8/9.
 */
public class OrderingTest {

    private static List<Integer> list = Arrays.asList(20, 1, 2, 3, 4, 5, 6, 7, 8);

    private static List<String> listStr = Arrays.asList("b", "c", "e", "a");

    private static List<Persons> listPerson = new ArrayList<>();


    //natural()：使用Comparable类型的自然顺序， 例如：整数从小到大，字符串是按字典顺序;
    //usingToString() ：使用toString()返回的字符串按字典顺序进行排序；
    // arbitrary() ：返回一个所有对象的任意顺序， 即compare(a, b) == 0 就是 a == b (identity equality)。 本身的排序是没有任何含义， 但是在VM的生命周期是一个常量。
    public static void main(String[] args) throws Exception {
        Persons persons = new Persons();
        persons.setAge(100);
        persons.setName("python");
        listPerson.add(persons);
        Persons persons1 = new Persons();
        persons1.setAge(20);
        persons1.setName("java");
        listPerson.add(persons1);


        isOrdered();
    }

    private static void natural() throws Exception {
        Ordering<Integer> order = Ordering.natural();
        Set<Integer> set = new TreeSet<>(order);
        set.addAll(list);
        set.stream().forEach(integer -> System.out.println(integer));
    }

    private static void naturalList() {
        Collections.sort(list);
        list.stream().forEach(integer -> System.out.println(integer));

        Collections.sort(listStr);
        listStr.stream().forEach(s -> System.out.println(s));
    }

    private static void sortedCopy() {
        //[1, 2, 3, 4, 5, 6, 7, 8, 20]
        Ordering<Integer> ordering = Ordering.natural();
        ordering.sortedCopy(list).stream().forEach(integer -> System.out.println(integer));
        //[a, b, c, e]
        Ordering<String> ordering1 = Ordering.natural();
        ordering1.sortedCopy(listStr).stream().forEach(s -> System.out.println(s));
    }

    private static void usingToString() {
        Ordering ordering = Ordering.usingToString();
        ordering.sortedCopy(listStr).stream().forEach(e -> System.out.println(e));
    }

    private static void isOrdered() {
        Ordering<Integer> ordering = Ordering.natural();
        System.out.println(ordering.isOrdered(list));
    }

    private static void naturalPerson() {

    }
}
