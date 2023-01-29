package com.zx.enums.base;

/**
 * 枚举基础类
 *
 * @Author gzx
 * @Date 2021/3/18 15:57
 */

public interface BaseEnum<T> {

  T getValue();

  String getName();

}
