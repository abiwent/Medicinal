package cn.ahpu.medicinal.dao;

import cn.ahpu.medicinal.pojo.MedicinalTable;

import java.util.List;

public interface MedicinalTableDao {

    public List<MedicinalTable> findAllIn();

    public List<MedicinalTable> findAllOut();
}
