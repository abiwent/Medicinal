package cn.ahpu.medicinal.impl;

import cn.ahpu.medicinal.dao.MedicinalTableDao;
import cn.ahpu.medicinal.mapper.MedicinalMapper;
import cn.ahpu.medicinal.mapper.MedicinalTableMapper;
import cn.ahpu.medicinal.mapper.OrderMapper;
import cn.ahpu.medicinal.pojo.MedicinalTable;
import cn.ahpu.medicinal.util.TimeChangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicinalTableDaoImpl implements MedicinalTableDao {

    @Autowired
    TimeChangeUtil timeChangeUtil;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    MedicinalMapper medicinalMapper;

    @Autowired
    MedicinalTableMapper medicinalTableMapper;

    @Override
    public List<MedicinalTable> findAllIn() {
        List<MedicinalTable> medicinalTables = medicinalTableMapper.findAllIn();
        for (MedicinalTable m:medicinalTables) {
            m.setTdate(timeChangeUtil.SqlChangeUtil(m.getTdate()));
        }
        return medicinalTables;
    }

    @Override
    public List<MedicinalTable> findAllOut() {
        List<MedicinalTable> medicinalTables = medicinalTableMapper.findAllOut();
        for (MedicinalTable m:medicinalTables) {
            m.setTdate(timeChangeUtil.SqlChangeUtil(m.getTdate()));
        }
        return medicinalTables;
    }
}
