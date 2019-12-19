package cn.ahpu.medicinal.mapper;

import cn.ahpu.medicinal.pojo.MedicinalTable;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "medicinalTableMapper")
@Mapper
public interface MedicinalTableMapper {

    public List<MedicinalTable> findAllIn();

    public List<MedicinalTable> findAllOut();
}
