package cn.ahpu.medicinal.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Output {
    private String ouuid;
    private Integer mno;
    private Integer mcount;
    private Date odate;
    private String ouser;
}
