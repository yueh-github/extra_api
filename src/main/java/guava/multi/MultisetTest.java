package guava.multi;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuehao on 2017/8/10.
 */
public class MultisetTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("岳浩");
        list.add("小色");
        list.add("SEO");


        Multiset multiset = HashMultiset.create();
        multiset.add("12");
        multiset.add("233");
        multiset.add("234");
        multiset.add("234");
        multiset.add("yuehao");

        Set set = new HashSet();
        set.add("12");
        set.add("233");
        set.add("234");

//        System.out.println(multiset.removeAll(set));
//        multiset.stream().forEach(s -> System.out.println(s));

        multiset.addAll(list);


//        multiset.stream().forEach(e -> System.out.println(e));

        multiset.parallelStream().forEach(e -> System.out.println(e));
//        System.out.println(multiset.count("234"));

//        Iterator iterator = multiset.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
    }
}
