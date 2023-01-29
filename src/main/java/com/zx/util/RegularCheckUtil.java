package com.zx.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 * 正则表达
 */

public class RegularCheckUtil {


  /**
   * 验证数字字母汉字
   *
   * @param string
   * @return
   */
  public static Boolean checkString(String string) {
    if (StringUtils.isBlank(string)) {
      return true;
    }
    String regex = "^[\\u4E00-\\u9FA5A-Za-z0-9]+$";
    Pattern pattern = Pattern.compile(regex);
    Matcher match = pattern.matcher(string);
    return match.matches();
  }


}
