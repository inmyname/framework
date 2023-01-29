package com.zx.util;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 类工具
 *
 * @Author gzx
 * @Date 2021/4/9 13:56
 */
public class ObjectUtil {

  /**
   * Object to Map
   *
   * @param obj
   * @return
   * @throws IllegalAccessException
   */
  public static Map<String, Object> getObjectToMap(Object obj) throws IllegalAccessException {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    Class<?> clazz = obj.getClass();
    for (Field field : clazz.getDeclaredFields()) {
      field.setAccessible(true);
      String fieldName = field.getName();
      Object value = field.get(obj);
//      if (value == null) {
//        value = null;
//      }
      map.put(fieldName, value);
    }
    return map;
  }

}
