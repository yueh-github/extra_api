package guava;

import com.google.common.base.Preconditions;
import exception.CustomerException;

/**
 * Created by yuehao on 2017/8/7.
 */
public class PreconditionsTest {

    private static final Long number = 199L;

    private static final Integer sNumber = 1000;

    private static final Boolean isTrue = true;

    private static final Boolean isFalse = false;

    static {

    }

    //Preconditions 检查参数
    public static void main(String[] args) {
        checkArgument();
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
}
