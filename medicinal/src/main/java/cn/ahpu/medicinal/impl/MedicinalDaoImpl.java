package cn.ahpu.medicinal.impl;

import cn.ahpu.medicinal.dao.MedicinalDao;
import cn.ahpu.medicinal.mapper.MedicinalMapper;
import cn.ahpu.medicinal.pojo.Medicinal;
import cn.ahpu.medicinal.util.TimeChangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicinalDaoImpl implements MedicinalDao {

    @Autowired
    TimeChangeUtil timeChangeUtil;

    @Autowired
    MedicinalMapper medicinalMapper;

    @Override
    public Medicinal selectById(Integer mno) {
        Medicinal medicinal = medicinalMapper.selectById(mno);
        medicinal.setMmadetime(timeChangeUtil.SqlChangeUtil(medicinal.getMmadetime()));
        return medicinal;
    }

    @Override
    public List<Medicinal> findAll() {
        List<Medicinal> medicinals = medicinalMapper.findAll();
        for (Medicinal medicinal:medicinals) {
            medicinal.setMmadetime(timeChangeUtil.SqlChangeUtil(medicinal.getMmadetime()));
        }
        return medicinals;
    }

    @Override
    public void updataMedicinal(Medicinal medicinal) {
        medicinalMapper.updataMedicinal(medicinal);
    }

    @Override
    public void insertMedicinal(Medicinal medicinal) {
        medicinalMapper.insertMedicinal(medicinal);
    }

    @Override
    public void deleteMedicinal(Integer mno) {
        medicinalMapper.deleteMedicinal(mno);
    }
}
