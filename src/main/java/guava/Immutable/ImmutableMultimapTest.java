package guava.Immutable;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

/**
 * Created by yuehao on 2017/8/10.
 */
public class ImmutableMultimapTest {

    public static void main(String[] args) {

        Multimap map = HashMultimap.create();
        map.put("a", "A");
        map.put("b", "B");
        map.put("c", "C");

        ImmutableMultimap multimap = ImmutableMultimap.copyOf(map);
    }
}
