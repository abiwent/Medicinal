package cn.ahpu.medicinal.impl;

import cn.ahpu.medicinal.dao.OrderDao;
import cn.ahpu.medicinal.mapper.OrderMapper;
import cn.ahpu.medicinal.pojo.Input;
import cn.ahpu.medicinal.pojo.Output;
import cn.ahpu.medicinal.util.TimeChangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    TimeChangeUtil timeChangeUtil;

    @Override
    public void addInput(Input input) {

        orderMapper.addInput(input);
    }

    @Override
    public void addOutput(Output output) {

        orderMapper.addOutput(output);
    }

    @Override
    public List<Input> findAllInput() {
        List<Input> inputs = orderMapper.findAllInput();
        for (Input input:inputs) {
            input.setIdate(timeChangeUtil.SqlChangeUtil(input.getIdate()));
        }
        return inputs;
    }

    @Override
    public List<Output> findAllOutput() {
        List<Output> outputs = orderMapper.findAllOutput();
        for (Output output:outputs) {
            output.setOdate(timeChangeUtil.SqlChangeUtil(output.getOdate()));
        }
        return outputs;
    }

    @Override
    public void deleteIn(String iuuid) {
        orderMapper.deleteIn(iuuid);
    }

    @Override
    public void deleteOut(String ouuid) {
        orderMapper.deleteOut(ouuid);
    }

    @Override
    public Input selectByIn(String iuuid) {
        Input input = orderMapper.selectByIn(iuuid);
        input.setIdate(timeChangeUtil.SqlChangeUtil(input.getIdate()));
        return input;
    }

    @Override
    public Output selectByOut(String ouuid) {
        Output output = orderMapper.selectByOut(ouuid);
        output.setOdate(timeChangeUtil.SqlChangeUtil(output.getOdate()));
        return output;
    }

    @Override
    public void updataIn(Input input) {
        orderMapper.updataIn(input);
    }

    @Override
    public void updataOut(Output output) {
        orderMapper.updataOut(output);
    }
}
