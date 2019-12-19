package cn.ahpu.medicinal.mapper;

import cn.ahpu.medicinal.pojo.Input;
import cn.ahpu.medicinal.pojo.Output;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "orderMapper")
@Mapper
public interface OrderMapper {

    public void addInput(Input input);

    public void addOutput(Output output);

    public List<Input> findAllInput();

    public List<Output> findAllOutput();

    public void deleteIn(String iuuid);

    public void deleteOut(String ouuid);

    public Input selectByIn(String iuuid);

    public Output selectByOut(String ouuid);

    public void updataIn(Input input);

    public void updataOut(Output output);

}
