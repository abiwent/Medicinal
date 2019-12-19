package cn.ahpu.medicinal.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Input {
    private String iuuid;
    private Integer mno;
    private Integer mcount;
    private Date idate;
    private String iuser;
}
