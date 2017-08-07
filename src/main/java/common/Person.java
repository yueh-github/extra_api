package common;

import lombok.Builder;
import lombok.Data;

/**
 * Created by yuehao on 2017/8/7.
 */
@Data
@Builder
public class Person {
    private String name;

    private Integer age;

    private String remark;
}
