package cn.ahpu.medicinal.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class GetUtil {

    public String getGuuid(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmssSSS");
        String str =formatter.format(new Date());
        return str;
    }

    public Date getDate(){
        return new Date();
    }


}
