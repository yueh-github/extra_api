package guava;

import com.google.common.base.Preconditions;
import exception.CustomerException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yuehao on 2017/8/7.
 * <p>
 * //Preconditions 检查参数来使用
 */
public class PreconditionsTest {

    private static final Long number = 199L;

    private static final Integer sNumber = 1000;

    private static final Boolean isTrue = true;

    private static final Boolean isFalse = false;

    private static final String string = "{1,2,3,4,5,6,7}";

    private static final String str = null;

    static {

    }

    /*
        Preconditions里面的方法：

        1 .checkArgument(boolean) ：
        功能描述：检查boolean是否为真。 用作方法中检查参数
        失败时抛出的异常类型: IllegalArgumentException

        2.checkNotNull(T)：
        功能描述：检查value不为null， 直接返回value；
        失败时抛出的异常类型：NullPointerException

        3.checkState(boolean)：
        功能描述：检查对象的一些状态，不依赖方法参数。 例如， Iterator可以用来next是否在remove之前被调用。
        失败时抛出的异常类型：IllegalStateException

        4.checkElementIndex(int index, int size)：
        功能描述：检查index是否为在一个长度为size的list， string或array合法的范围。 index的范围区间是[0, size)(包含0不包含size)。无需直接传入list， string或array， 只需传入大小。返回index。
        失败时抛出的异常类型：IndexOutOfBoundsException


        5.checkPositionIndex(int index, int size)：
        功能描述：检查位置index是否为在一个长度为size的list， string或array合法的范围。 index的范围区间是[0， size)(包含0不包含size)。无需直接传入list， string或array， 只需传入大小。返回index。
        失败时抛出的异常类型：IndexOutOfBoundsException

        6.checkPositionIndexes(int start, int end, int size)：
        功能描述：检查[start, end)是一个长度为size的list， string或array合法的范围子集。伴随着错误信息。
        失败时抛出的异常类型：IndexOutOfBoundsException
    */

    //Preconditions 检查参数来使用
    public static void main(String[] args) {
        checkPositionIndex();
    }

    //功能描述：检查boolean是否为真。 用作方法中检查参数
    private static void checkArgument() {
        //Exception in thread "main" java.lang.IllegalArgumentException
        Preconditions.checkArgument(isFalse);
        //Exception in thread "main" java.lang.IllegalArgumentException: 错误码:10086;错误信息:值错误
        Preconditions.checkArgument(isFalse, new CustomerException("值错误", 10086));
        //Exception in thread "main" java.lang.IllegalArgumentException: 用作方法中检查参数 [错误码:10086;错误信息:值错误]
        Preconditions.checkArgument(isFalse, "用作方法中检查参数", new CustomerException("值错误", 10086));
    }

    private static void checkNotNull() {
        //Exception in thread "main" java.lang.NullPointerException
        Preconditions.checkNotNull(str);
        //Exception in thread "main" java.lang.NullPointerException: 错误码:18800;错误信息:null
        Preconditions.checkNotNull(str, new CustomerException(18800));
        //Exception in thread "main" java.lang.NullPointerException: 传进去一个空置 [82920]
        Preconditions.checkNotNull(str, "传进去一个空置", 82920);
    }

    private static void checkState() {
        //Exception in thread "main" java.lang.IllegalStateException: 10080
        Preconditions.checkState(isFalse, 10080);
        //Exception in thread "main" java.lang.IllegalStateException: 1234 [错误码:10086;错误信息:值错误, 错误码:10089;错误信息:错误]
        Preconditions.checkState(isFalse, "1234", new CustomerException("值错误", 10086), new CustomerException("错误", 10089));
    }

    private static void checkPositionIndex() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //Exception in thread "main" java.lang.IndexOutOfBoundsException: 下标越界 (10) must not be greater than size (7)
        Preconditions.checkPositionIndex(10, list.size(), "下标越界");
    }
}
