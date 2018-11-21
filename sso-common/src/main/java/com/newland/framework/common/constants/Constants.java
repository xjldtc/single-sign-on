package com.newland.framework.common.constants;

/**
 * 通用基础常量类
 * (只提供全局的常量，业务常量交由biz定义
 *  现提供"通用的是否","通用的真假","审核状态","通用的启用禁用状态","逻辑删除状态","性别")
 * @author xjldtc
 *
 */
public class Constants {
	
	/**
     * 通用的是否
     * @author xjldtc
     */
    public static enum YesOrNoEnum{
        NO(0,"否"),YES(1,"是");
        private YesOrNoEnum(Integer value,String name){
            this.value = value;
            this.name = name;
        }
        private final Integer value;
        private final String name;
        
        public Integer getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }
    
	/**
     * 通用的真假
     * @author xjldtc
     */
    public static enum TrueOrFalseEnum{
        TRUE(0,"否"),FALSE(1,"是");
        private TrueOrFalseEnum(Integer value,String name){
            this.value = value;
            this.name = name;
        }
        private final Integer value;
        private final String name;
        
        public Integer getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }
    
    /**
     * 通用的启用禁用状态
     * @author xjldtc
     */
    public static enum EnableStateEnum{
        DISABLE(0,"禁用"),ENABLE(1,"启用");
        private EnableStateEnum(Integer value,String name){
            this.value = value;
            this.name = name;
        }
        private final Integer value;
        private final String name;
        
        public Integer getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }
    
    /**
     * 审核状态
     * @author xjldtc
     */
    public static enum BackOrderStatusEnum{
        WAIT(1,"待审核"),AUDIT(2,"审核中"),PASS(3,"审核通过"),NOTPASS(4,"审核不通过"),HANG(5,"挂起");
        private BackOrderStatusEnum(Integer value,String name){
            this.value = value;
            this.name = name;
        }
        private final Integer value;
        private final String name;
        
        public Integer getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }
    
    /**
     * 逻辑删除状态
     * @author xjldtc
     */
    public static enum DeleteStatusEnum{
    	 NORMAL(1,"正常"),DELETE(0,"删除");
        private DeleteStatusEnum(Integer value,String name){
            this.value = value;
            this.name = name;
        }
        private final Integer value;
        private final String name;
        
        public Integer getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }
    
    /**
     * 性别
     * @author xjldtc
     */
    public static enum SexEnum{
        
        MAN("1","男"),FEMAN("2","女");
        
        private SexEnum(String value,String name){
            this.value = value;
            this.name = name;
        }
        private final String value;
        private final String name;
        
        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
        
    }
    
    /**
     * 数字
     * @author xjldtc
     */
    public static enum NumberEnum{
    	NEGATIVE_ONE(-1),
    	ZERO(0),
    	ONE(1),
    	TWO(2),
    	THREE(3),
    	HOUR(4),
    	FIVE(5),
    	SIX(6),
    	SEVEN(7),
    	EIGHT(8),
    	NINE(9),
    	TEN(10),
    	ELEVEN(11),
    	TWELVE(12);
    	
    	private NumberEnum(Integer value) {
			this.value = value;
		}

		private final Integer value;

		public Integer getValue() {
			return value;
		}
    }
    
    /**
     * 通用返回码
     * @author xjldtc
     */
    public static enum ReturnCodeEnum{
    	
    	SUCCESS(Long.valueOf(00000000),"成功"),
    	ERROR(Long.valueOf(-99999999),"未知错误");
    	
    	private ReturnCodeEnum(Long value,String name){
            this.value = value;
            this.name = name;
        }
        private final Long value;
        private final String name;
        
        public Long getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }
}
