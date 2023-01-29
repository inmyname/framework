package com.zx.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import com.zx.annotation.CompareField;

/**
 * 用自定义注解比较属性值
 *
 * @Author gzx
 * @Date 2021/4/9 13:56
 */
public class CompareUtil {

  /**
   * 拥有自定义注解 @CompareField 的同名属性值对比,对比双方必须同时有注解
   *
   * @param oldObj 原obj
   * @param newObj 新obj
   * @return Map(Annotation - value, Map ( oldValue, newValue))
   * @throws Exception
   */
  public static Map<String, Map<String, String>> compare(Object oldObj, Object newObj)
      throws Exception {
    Map<String, Map<String, String>> map = new HashMap<>();
    Class<?> clazz1 = oldObj.getClass();
    Class<?> clazz2 = newObj.getClass();
    Field[] fields1 = clazz1.getDeclaredFields();
    Field[] fields2 = clazz2.getDeclaredFields();
    if (fields1.length <= 0 || fields2.length <= 0) {
      return null;
    }
    for (int i = 0; i < fields1.length; i++) {
      fields1[i].setAccessible(true);
      if (fields1[i].getAnnotation(CompareField.class) != null) {
        for (int j = 0; j < fields2.length; j++) {
          if (fields1[i].getName().equals(fields2[j].getName())) {
            fields2[j].setAccessible(true);
            Map<String, String> fieldMap = new HashMap<>();
            fieldMap.put(fields1[i].get(oldObj).toString(), fields2[j].get(newObj).toString());
            map.put(fields1[i].getAnnotation(CompareField.class).value(),
                fieldMap);
          }
        }
      }
    }
    return map;
  }

}
