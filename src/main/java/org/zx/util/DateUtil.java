package org.zx.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtil {

  /**
   * 获取当前时间到一天结束的剩余秒数
   *
   * @return
   */
  public static long getRemainingTime() {
    Date currentDate = new Date();
    LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(),
        ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
        .withSecond(0).withNano(0);
    LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
        ZoneId.systemDefault());
    return ChronoUnit.SECONDS.between(currentDateTime, midnight);
  }

}
