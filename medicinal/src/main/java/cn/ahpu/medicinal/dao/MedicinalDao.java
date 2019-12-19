package cn.ahpu.medicinal.dao;

import cn.ahpu.medicinal.pojo.Medicinal;

import java.util.List;

public interface MedicinalDao {

    public Medicinal selectById(Integer mno);

    public List<Medicinal> findAll();

    public void updataMedicinal(Medicinal medicinal);

    public void insertMedicinal(Medicinal medicinal);

    public void deleteMedicinal(Integer mno);

}
