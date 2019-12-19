package cn.ahpu.medicinal.mapper;

import cn.ahpu.medicinal.pojo.Medicinal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "medicinalMapper")
@Mapper
public interface MedicinalMapper {

    public  Medicinal selectById(Integer mno);

    public List<Medicinal> findAll();

    public void updataMedicinal(Medicinal medicinal);

    public void insertMedicinal(Medicinal medicinal);

    public void deleteMedicinal(Integer mno);
}
