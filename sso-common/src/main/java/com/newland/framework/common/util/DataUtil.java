package com.newland.framework.common.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;

import com.newland.framework.common.constants.Constants.ReturnCodeEnum;

/**
 * 整合JAVA8时间处理类 提供常用方法
 * @author xjldtc
 *
 */
public class DataUtil {

	/**
	 * 当前时区
	 */
	private static final ZoneId ZONE = ZoneId.systemDefault();

	/**
	 * 时间格式枚举
	 * 
	 * @author xjldtc
	 *
	 */
	public static enum TimePattern {
		/**
		 * yyyy-MM-dd HH:mm:ss
		 */
		DATE_TIME_PATTERN("yyyy-MM-dd HH:mm:ss"),
		/**
		 * yyyy/MM/dd/HH/mm/ss
		 */
		PROCESSING_TIME_PATTERN("yyyy/MM/dd/HH/mm/ss"),
		/**
		 * yyyy-MM-dd HH:mm
		 */
		MINUTE_PATTERN("yyyy-MM-dd HH:mm"),
		/**
		 * yyyy-MM-dd
		 */
		DATE_PATTERN("yyyy-MM-dd");

		private TimePattern(String value) {
			this.value = value;
		}

		private final String value;

		public String getValue() {
			return value;
		}

	}
	
	/**
	 * 时间格式枚举
	 * 
	 * @author xjldtc
	 *
	 */
	public static enum CalculateType {
		/**
		 *  年
		 */
		YEARS("years"),
		/**
		 *  月
		 */
		MONTHS("month"),
		/**
		 *  日
		 */
		DAYS("days"),
		/**
		 * 时
		 */
		HOURS("hours"),
		/**
		 * 分
		 */
		MINUTES("mimutes"),
		/**
		 * 秒
		 */
		SECONDS("seconds");

		private CalculateType(String value) {
			this.value = value;
		}

		private final String value;

		public String getValue() {
			return value;
		}

	}

	/**
	 * 获取当前时间
	 */
	public static LocalDateTime getDateTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		return localDateTime;
	}

	/**
	 * 根据传入的时间格式返回系统当前的时间
	 */
	public static String dateTimeFormat(TimePattern Pattern) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Pattern.getValue());
		LocalDateTime now = LocalDateTime.now();
		return now.format(dateTimeFormatter);
	}

    /**
     * 将string和 date类型的时间 转换成 LocalDate 或者 LocalDateTime <BR/>
     * 当time 等于String  已经实现的 装换类型 format为DATE_PATTERN(yyyy-MM-dd) 转换成LocalDate.<BR/>
     * DATE_TIME_PATTERN(yyyy-MM-dd HH:mm:ss). PROCESSING_TIME_PATTERN(yyyy/MM/dd/HH/mm/ss). 
     * MINUTE_PATTERN(yyyy-MM-dd HH:mm) 转换成LocalDateTime<BR/>
     * time 等于Date 不限制格式化类型，返回localDateTime
     *
     * @param time string or date
     * @param pattern TimePattern枚举类
     * @param <I> 传入类型 
     * @param <R> 返回类型
     * @return LocalDateTime or LocalDate(只有DATE_PATTERN返回)
     */
    public static <I, R> R timeFormat(I time,TimePattern pattern){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern.value);
        //可在此处扩展支持类型
        if (ClassCommonUtil.isCompatible(String.class,time)){
        	LocalDateTime localDateTime;
        	LocalDate localDate;
        	switch(pattern)
        	{
        	    case DATE_TIME_PATTERN:
        	    	localDateTime = LocalDateTime.parse(time.toString(), dtf);
                    return (R) localDateTime;
        	    case PROCESSING_TIME_PATTERN:
        	    	localDateTime = LocalDateTime.parse(time.toString(), dtf);
                    return (R) localDateTime;
        	    case MINUTE_PATTERN:
        	    	localDateTime = LocalDateTime.parse(time.toString(), dtf);
                    return (R) localDateTime;
        	    case DATE_PATTERN:
        	    	localDate = LocalDate.parse(time.toString(), dtf);
        	    	return (R) localDate;
			    default:
			    	return null;
        	}
        }
        if (ClassCommonUtil.isCompatible(String.class,time)){
            Date date = (Date) time;
            Instant instant = date.toInstant();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZONE);
            return (R) localDateTime;
        }
        return null;
    }
    
    /**
     * 使用ChronoUnit实现两时间的时间差计算 <BR/>
     * 2018-10-23 Temporal请使用LocalDateTime LocalDate时间类
     * @param type 传入CalculateType时间枚举  
     * @param timeA 时间A 可以是 LocalDateTime LocalDate 等Temporal接口的实现类 
     * @param timeB 时间B 可以是 LocalDateTime LocalDate 等Temporal接口的实现类
     * @return Long
     * @author xjldtc
     */
	public static Long minusBetweenByString(CalculateType type, Temporal timeA, Temporal timeB) {
		switch (type){
		    case YEARS:
		    	return ChronoUnit.YEARS.between(timeA, timeB);
		    case MONTHS:
		    	return ChronoUnit.MONTHS.between(timeA, timeB);
		    case DAYS:
		    	return ChronoUnit.DAYS.between(timeA, timeB);
		    case HOURS:
		    	return ChronoUnit.HOURS.between(timeA, timeB);
		    case MINUTES:
		    	return ChronoUnit.MINUTES.between(timeA, timeB);
		    case SECONDS:
		    	return ChronoUnit.SECONDS.between(timeA, timeB);
		    default:
		    	return ReturnCodeEnum.ERROR.getValue();
		}
	}
	
	

	public static void main(String[] args) {
		//System.out.println(DataUtil.string2LocalDateTime(TimePattern.DATE_PATTERN, DataUtil.dateTimeFormat(TimePattern.DATE_PATTERN)));
		LocalDateTime instant = (LocalDateTime) DataUtil.timeFormat("1990-01-18 22:12:58", TimePattern.DATE_TIME_PATTERN);
		System.out.println(instant.toString());
		instant = (LocalDateTime) DataUtil.timeFormat("1990/01/18/22/12/58", TimePattern.PROCESSING_TIME_PATTERN);
		System.out.println(instant.toString());
		instant = (LocalDateTime) DataUtil.timeFormat("1990-01-18 22:12", TimePattern.MINUTE_PATTERN);
		System.out.println(instant.toString());
		LocalDate localDate = (LocalDate) DataUtil.timeFormat("1990-01-18", TimePattern.DATE_PATTERN);
		System.out.println(localDate.toString());
	}
}
