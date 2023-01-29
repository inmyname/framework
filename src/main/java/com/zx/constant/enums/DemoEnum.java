package com.zx.constant.enums;

import com.zx.constant.enums.base.BaseEnum;

/**
 * enum--demo
 *
 * @Author gzx
 * @Date 2021/3/18 15:59
 */
public enum DemoEnum implements BaseEnum<Integer> {
  //
  MAN(1, "男"),
  WOMAN(2, "女"),
  ;


  private Integer value;

  private String name;

  DemoEnum(int value, String name) {
    this.value = value;
    this.name = name;
  }


  @Override
  public Integer getValue() {
    return value;
  }

  @Override
  public String getName() {
    return name;
  }

  public static String getName(Integer value) {
    for (DemoEnum e : DemoEnum.values()) {
      if (e.getValue() == value) {
        return e.getName();
      }
    }
    return null;
  }

  public static Integer getValue(String name) {
    for (DemoEnum e : DemoEnum.values()) {
      if (e.getName().equals(name)) {
        return e.getValue();
      }
    }
    return null;
  }


}
