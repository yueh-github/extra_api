package guava;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuehao on 2017/8/9.
 */
public class ImmutableSetTest {

    private static final Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        ImmutableSet immutableSet = ImmutableSet.builder().addAll(set).build();

        iterator();
    }

    private static void builder() {
        ImmutableSet<Integer> immutableSet = ImmutableSet.<Integer>builder().add(100).add(200).add(300).build();
        immutableSet.forEach(s -> System.out.println(s));
    }

    private static void copyOf() {
        ImmutableSet<Integer> integers = ImmutableSet.copyOf(set);
        integers.stream().forEach(integer -> System.out.println(integer));
    }

    private static void of() {
        ImmutableSet.of(1, 2, 3, 4, 5, 6, 7, 8).stream().forEach(integer -> System.out.println(integer));
    }

    private static void iterator() {
        ImmutableSet immutableSet = ImmutableSet.copyOf(set);

        UnmodifiableIterator iterator = immutableSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
