package cn.sagreen.jooqdemo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author linyicong
 * @since 2019-07-26
 */
@Getter
@AllArgsConstructor
public enum SexEnum {
    // 性别枚举
    MAN(1, "男"), WOMAN(2, "女");

    private int code;
    private String desc;
}
