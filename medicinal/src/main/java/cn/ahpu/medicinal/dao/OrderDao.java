package cn.ahpu.medicinal.dao;

import cn.ahpu.medicinal.pojo.Input;
import cn.ahpu.medicinal.pojo.Output;

import java.util.List;

public interface OrderDao {

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
