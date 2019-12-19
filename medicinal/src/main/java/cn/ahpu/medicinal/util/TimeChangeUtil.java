package cn.ahpu.medicinal.util;

import org.springframework.stereotype.Component;


import java.util.Date;

@Component
public class TimeChangeUtil {
    /*Util时间转换为Sql时间*/
    public  Date UtilChangeSql(java.sql.Date sqldate){
        Date utildate = new Date(sqldate.getTime());
        return utildate;
    }

    /*SQL时间转换为Util时间,在pojo中时间定义为Util.Date*/
    public  java.sql.Date SqlChangeUtil(Date utildate){
        java.sql.Date sqldate = new java.sql.Date(utildate.getTime());
        return sqldate;
    }
}
