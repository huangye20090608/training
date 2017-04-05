package com.huangye.training.common;

/**
 * Created by huangye on 2016/10/22.
 */
public enum TipsTypeEnum {

    PURCHASED_VALID("10", "已购买服务未过期"),
    PURCHASED_EXPIRED("20", "已购买服务已过期"),
    ONTRIAL_VALID("30", "正在试用服务未过期"),
    ONTRIAL_EXPIRED("40", "正在试用服务已过期");

    private String code;

    private String desc;

    TipsTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static TipsTypeEnum getEnumObjByCode(Integer code){
        for(TipsTypeEnum enumObj : TipsTypeEnum.values()){
            if(enumObj.getCode().equals(code)){
                return enumObj;
            }
        }
        return null;
    }
}
