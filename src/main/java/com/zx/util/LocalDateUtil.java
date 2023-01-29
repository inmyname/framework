package com.zx.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LocalDateUtil {

  /**
   * @param date
   * @return
   */
  public static int getMonth(LocalDate date) {
    return date.getMonthValue();
  }

  /**
   * @param date
   * @return
   */
  public static int getYear(LocalDate date) {
    return date.getYear();
  }

  /**
   * @param date
   * @return
   */
  public static int getWeekOfYear(LocalDate date) {
    WeekFields weekFields = WeekFields.ISO;
    return date.get(weekFields.weekOfWeekBasedYear());
  }

  /**
   * 月-第一天
   *
   * @param date
   * @return
   */
  public static LocalDate firstDayOfMonth(LocalDate date) {
    return date.with(TemporalAdjusters.firstDayOfMonth());
  }

  /**
   * 月-最后一天
   *
   * @param date
   * @return
   */
  public static LocalDate lastDayOfMonth(LocalDate date) {
    return date.with(TemporalAdjusters.lastDayOfMonth());
  }

  /**
   * 周-第一天
   *
   * @param date
   * @return
   */
  public static LocalDate firstDayOfWeek(LocalDate date) {
    return date.with(DayOfWeek.MONDAY);
  }

  /**
   * 周-最后一天
   *
   * @param date
   * @return
   */
  public static LocalDate lastDayOfWeek(LocalDate date) {
    return date.with(DayOfWeek.SUNDAY);
  }

  /**
   * 是否同一年
   *
   * @param beginDate
   * @param endDate
   * @return
   */
  public static boolean isSameYear(LocalDate beginDate, LocalDate endDate) {
    if (beginDate == null || endDate == null) {
      return false;
    }
    return beginDate.getYear() == endDate.getYear();
  }

  /**
   * @param date
   * @return
   */
  public static int getWeekBasedYear(LocalDate date) {
    WeekFields weekFields = WeekFields.ISO;
    return date.get(weekFields.weekBasedYear());
  }

  /**
   * 两个日期之间的周
   *
   * @param beginDate
   * @param endDate
   * @return
   */
  public static Map<Integer, Set<Integer>> getWeeksBetweenDates(LocalDate beginDate,
      LocalDate endDate) {
    Map<Integer, Set<Integer>> weeksMap = new HashMap<>();
    while (beginDate.isBefore(endDate)) {
      int week = LocalDateUtil.getWeekOfYear(beginDate);
      int year = LocalDateUtil.getYear(beginDate);
      int weekBasedYear = LocalDateUtil.getWeekBasedYear(beginDate);
      Set<Integer> r = weeksMap.get(year);
      if (r == null) {
        r = new HashSet<>();
      }
      if (year == weekBasedYear) {
        r.add(week);
      }
      weeksMap.put(year, r);
      beginDate = beginDate.plusDays(1);
    }
    return weeksMap;
  }

  /**
   * 两个日期之间的月
   *
   * @param beginDate
   * @param endDate
   * @return
   */
  public static Map<Integer, Set<Integer>> getMonthsBetweenDates(LocalDate beginDate,
      LocalDate endDate) {
    Map<Integer, Set<Integer>> monthsMap = new HashMap<>();
    while (beginDate.isBefore(endDate)) {
      int month = LocalDateUtil.getMonth(beginDate);
      int year = LocalDateUtil.getYear(beginDate);
      Set<Integer> r = monthsMap.get(year);
      if (r == null) {
        r = new HashSet<>();
      }
      r.add(month);
      monthsMap.put(year, r);
      beginDate = beginDate.plusDays(1);
    }
    return monthsMap;
  }

  /**
   * 两个日期之间的年
   *
   * @param beginDate
   * @param endDate
   * @return
   */
  public static Set<Integer> getYearsBetweenDates(LocalDate beginDate,
      LocalDate endDate) {
    Set<Integer> years = new HashSet<>();
    while (beginDate.isBefore(endDate)) {
      int year = LocalDateUtil.getYear(beginDate);
      years.add(year);
      beginDate = beginDate.plusDays(1);
    }
    return years;
  }

}
