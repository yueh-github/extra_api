package guava;

import com.alibaba.fastjson.JSON;
import com.google.common.base.*;
import com.google.common.collect.*;
import com.google.common.primitives.Longs;

import java.util.*;


/**
 * Created by yuehao on 2017/7/27.
 */
public class GuavaTest {

    public static void main(String[] args) {
        try {
            testInts();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void testPreconditions() {
        Preconditions.checkNotNull(null, "参数不能为null");

        double dtr = 723.99;
        Preconditions.checkArgument(dtr < 0.0, "参数过大", 100);

//        Preconditions.checkState(true,"检测是否为true");

        int[] data = {1, 2, 3, 4, 5};


        Preconditions.checkElementIndex(10, data.length, "未找到有效坐标");
    }


    public static void testOrdering() {
        List<Integer> list = Arrays.asList(5, 3, 4, 7, 8, 34, 21, 645, 676, 899);

        Ordering ordering = Ordering.natural();

        Collections.sort(list, ordering);


        System.out.println(ordering.isOrdered(list));
        System.out.println(JSON.toJSONString(list));
        System.out.println("max:" + ordering.max(list));
        System.out.println("min:" + ordering.min(list));


        Collections.sort(list, ordering.reverse());
        System.out.println(JSON.toJSONString(list));

        Collections.sort(list, ordering.nullsFirst());
        System.out.println(JSON.toJSONString(list));


        List<String> names = new ArrayList<>();
        names.add("Ram");
        names.add("Shyam");
        names.add("Mohan");
        names.add("Sohan");
        names.add("Ramesh");
        names.add("Suresh");
        names.add("Naresh");
        names.add("Mahesh");
        names.add("Vikas");
        names.add("Deepak");
        names.add(null);

        Collections.sort(names, ordering.nullsLast().reverse());
        System.out.println(JSON.toJSONString(names));
    }


    public static void testObjects() {
//        SafSkiEntity safSkiEntity = new SafSkiEntity();
//        safSkiEntity.setName("3让日让");
//        safSkiEntity.setId(1000);
//        System.out.println(MoreObjects.toStringHelper(safSkiEntity));
//        System.out.println(MoreObjects.toStringHelper(safSkiEntity.getClass().getName()));
//        System.out.println(MoreObjects.toStringHelper(safSkiEntity).add("name", safSkiEntity.getName()).add("id", safSkiEntity.getId()).toString());
    }

    public static void testRange() {


        Range<Integer> range = Range.closed(1, 10);
        for (int grade : ContiguousSet.create(range, DiscreteDomain.integers())) {
            System.out.print(grade + " ");
        }
    }

    public static void testThrowables() throws Exception {
        try {
            List list = new ArrayList();
            list.get(10);
        } catch (Exception ex) {
            System.out.println(Throwables.getStackTraceAsString(ex));
            System.out.println("---------");
            System.out.println(Throwables.getRootCause(ex));
        }
    }

    public static void testBimap() {
        BiMap biMap = HashBiMap.create();

        biMap.put("yuehao", "100");
        biMap.forcePut("yuemiao", "100");

        System.out.println(biMap.get("yuemiao"));
        System.out.println(biMap.get("yuehao"));

        System.out.println(biMap.inverse().get("100"));

        Map<String, String> map = new HashMap<>();

        map.put("dddd", "dddd");
        map.put("xxxx", "dddd");

        System.out.println(map.get("dddd"));
        System.out.println(map.get("xxxx"));
    }

    public static void testTable() {
        Table<String, String, String> table = HashBasedTable.create();
        table.put("beijing", "yuehao", "男");
        table.put("beijing", "yuemiao", "男");
        table.put("beijing", "liaiyun", "女");

        table.put("shanghai", "liaiyun", "女");
        table.put("shanghai", "liaiyun", "女");
        table.put("shanghai", "liaiyun", "女");


        Map<String, String> map = table.row("beijing");

        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println("Emp name: " + entry.getKey() + ", 性别: " + entry.getValue());
        }

        Set<String> employers = table.rowKeySet();

        for (String str : employers) {
            System.out.println(str);
        }

        Map<String, String> stringMap = table.column("yuemiao");

        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            System.out.println("Employer: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }

    public static void testJoiner() throws Exception {

        String string = Joiner.on("/").join(Arrays.asList("fef", "fegr", "grgrg", "grhtht"));


        StringBuffer buffer = new StringBuffer();
        buffer.append("s:");
        System.out.println(Joiner.on("&").appendTo(buffer, Arrays.asList("fefe", "fgrgr")));

        Map<String, String> map = new HashMap<>();
        map.put("yuehao", "1000");
        map.put("yuemiao", "2222");

        Joiner.MapJoiner mapJoiner = Joiner.on("&").withKeyValueSeparator("->");
        System.out.println(mapJoiner.join(map));
    }


    public static void testSpiltter() {
        String str = "1,2,,3,,4,55,667,888,   ,  ,6455,";
        Splitter.on(",").trimResults().omitEmptyStrings().limit(200).splitToList(str).forEach(e -> System.out.print(e + ","));

        Splitter.MapSplitter mapSplitter = Splitter.on(",").trimResults().omitEmptyStrings().withKeyValueSeparator("->");
    }


    public static void testCharMatcher() {

        String string = "ggqf23r54g34wgebrherheg4**&&%$$$)(@(73r3r2rfeefe   HHFWFWFLEGR28Y20FSNFK";

        //返回所有的数字
        System.out.println(CharMatcher.digit().retainFrom(string));
        //
        System.out.println(CharMatcher.javaUpperCase().retainFrom(string));
    }

    public static void testCaseFormat() {
        //按格式转换
        String string = "yue_Hao";
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "yuehao"));
    }

    public static void testInts() {
        byte[] byteArray = Longs.toByteArray(20000);
        for (int i = 0; i < byteArray.length; i++) {
            System.out.print(byteArray[i] + " ");
        }
    }
}
