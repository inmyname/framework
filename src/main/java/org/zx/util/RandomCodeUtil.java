package org.zx.util;

import java.util.Random;

/**
 * 随机数工具
 *
 * @Author gzx
 * @Date 2021/4/9 13:56
 */
public class RandomCodeUtil {

  /**
   * 六位随机字符
   *
   * @return
   */
  public static String randomCode6() {
    String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    StringBuilder sb = new StringBuilder(6);
    for (int i = 0; i < 6; i++) {
      char ch = str.charAt(new Random().nextInt(str.length()));
      sb.append(ch);
    }
    return sb.toString();
  }


  /**
   * 区间随机数
   *
   * @return
   */
  public static int randomNum(int min, int max) {
    Random random = new Random();
    return random.nextInt(max) % (max - min + 1) + min;
  }

  /**
   * 六位随机数字
   *
   * @return
   */
  public static String randomNum6() {
    String str = "0123456789";
    StringBuilder sb = new StringBuilder(6);
    for (int i = 0; i < 6; i++) {
      char ch = str.charAt(new Random().nextInt(str.length()));
      sb.append(ch);
    }
    return sb.toString();
  }

}
