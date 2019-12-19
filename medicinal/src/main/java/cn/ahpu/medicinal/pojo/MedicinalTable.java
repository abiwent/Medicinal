package cn.ahpu.medicinal.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class MedicinalTable {
    private String tuuid;
    private Integer mno;
    private String mname;
    private double mprice;
    private double msellprice;
    private Integer tput;
    private Integer tid;
    private String tuser;
    private Date tdate;
}
