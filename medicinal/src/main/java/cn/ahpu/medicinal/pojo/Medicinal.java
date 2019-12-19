package cn.ahpu.medicinal.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Medicinal {
    private Integer mno;
    private String mname;
    private double mprice;
    private double msellprice;
    private Date mmadetime;
    private double mcount;
}
