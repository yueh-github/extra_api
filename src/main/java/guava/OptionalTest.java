package guava;


import common.Persons;

import java.util.Optional;

/**
 * Created by yuehao on 2017/8/8.
 */
public class OptionalTest {

    private static final Long number = 199L;

    private static final Integer sNumber = 1000;

    private static final Boolean isTrue = true;

    private static final Boolean isFalse = false;

    private static final String string = "{1,2,3,4,5,6,7}";

    private static final String str = null;

    private static Optional optional_not_null = null;

    private static Optional optional_is_null = null;

    private static Optional<Persons> optional_is_person = null;


    private static Persons person = new Persons();

    public static void main(String[] args) throws Exception {
        person.setAge(29);
        person.setName("岳浩");
        person.setRemark("备注字段");
        optional_not_null = Optional.of(number);
        optional_is_null = Optional.ofNullable(str);
        optional_is_person = Optional.ofNullable(person);
        ifPresent();
    }

    private static void of() {
        //如果值为空直接抛出空指针
        Optional optional = Optional.of(number);
    }

    private static void ofNullable() {
        //可以放空置
        Optional optional = Optional.ofNullable(str);
        if (optional.isPresent()) {
            System.out.println("值不为null");
        } else {
            System.out.println("值为null");
        }
    }

    public static void isPresent() {
        Optional optional = Optional.of(str);
        //判断是否有值，有值为true,无值为false
        System.out.println(optional.isPresent());
    }


    public static void get() {
        //获取值
        System.out.println(optional_not_null.get());
        System.out.println(optional_is_null.get());
    }

    public static void orElse() {
        //如果值存在不为空，返回值，如果不存在返回传入的参数
        System.out.println(optional_is_null.orElse(100));
        System.out.println(optional_not_null.orElse(1000));
    }

    public static void orElseGet() {
        //如果有值返回值，无值返回方法返回的值
        System.out.println(optional_not_null.orElseGet(() -> "岳浩"));
        System.out.println(optional_is_null.orElseGet(OptionalTest::getString));
    }

//    public static void orElseThrow() {
//        System.out.println(optional_is_null.orElseThrow(new CustomerException(100)));
//    }


    public static void ifPresent() {
        //如果有值，调用对应的表达式
//        optional_is_person.ifPresent((value) ->
//                Person.builder().age(value.getAge()).name(value.getName()).remark(value.getRemark()).build()
//        );

        optional_is_person.ifPresent(persons -> {
            System.out.println(persons.getName());
            System.out.println(persons.getAge());
            System.out.println(persons.getRemark());
        });
    }

    private static String getString() {
        return "岳浩";
    }
}

