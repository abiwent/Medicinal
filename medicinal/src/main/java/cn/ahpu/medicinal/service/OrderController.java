package cn.ahpu.medicinal.service;

import cn.ahpu.medicinal.impl.MedicinalDaoImpl;
import cn.ahpu.medicinal.impl.MedicinalTableDaoImpl;
import cn.ahpu.medicinal.impl.OrderDaoImpl;
import cn.ahpu.medicinal.pojo.Input;
import cn.ahpu.medicinal.pojo.Medicinal;
import cn.ahpu.medicinal.pojo.MedicinalTable;
import cn.ahpu.medicinal.pojo.Output;
import cn.ahpu.medicinal.util.GetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    MedicinalDaoImpl medicinalDao;

    @Autowired
    OrderDaoImpl orderDao;

    @Autowired
    GetUtil getUtil;

    @Autowired
    MedicinalTableDaoImpl medicinalTableDao;

    //库存表
    @RequestMapping("/orderlist")
    public String orderList(Model model) {
        List<Medicinal> medicinals = medicinalDao.findAll();
        model.addAttribute("meds", medicinals);
        return "page/order-list";
    }

    //入库表
    @RequestMapping("/showinput")
    public String showInput(Model model) {
        String iuuid = getUtil.getGuuid();
        model.addAttribute("iuuid", iuuid);
        return "page/order-input";
    }

    //出库表
    @RequestMapping("/showoutput")
    public String showoutput(Model model) {
        String ouuid = getUtil.getGuuid();
        model.addAttribute("ouuid", ouuid);
        return "page/order-output";
    }

    /*view中string类型转换为Date类型*/
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //添加入库
    @RequestMapping("/addinput")
    public String addInput(Input input, Model model) {
        orderDao.addInput(input);
        List<Input> orders = orderDao.findAllInput();
        model.addAttribute("orders", orders);
        return "page/input-list";
    }

    //添加出库
    @RequestMapping("/addoutput")
    public String addOutput(Output output, Model model) {
        orderDao.addOutput(output);
        List<Output> orders = orderDao.findAllOutput();
        model.addAttribute("orders", orders);
        return "page/output-list";
    }

    //入库清单
    @RequestMapping("/showinlist")
    public String showInList(Model model) {
        List<Input> orders = orderDao.findAllInput();
        model.addAttribute("orders", orders);
        return "page/input-list";
    }

    //出库清单
    @RequestMapping("/showoutlist")
    public String showOutList(Model model) {
        List<Output> orders = orderDao.findAllOutput();
        model.addAttribute("orders", orders);
        return "page/output-list";
    }

    //删除入库表单
    @RequestMapping("/toindelete")
    public String toInDelete(String iuuid, Model model) {
        orderDao.deleteIn(iuuid);
        List<Input> orders = orderDao.findAllInput();
        model.addAttribute("orders", orders);
        return "page/input-list";
    }

    //删除出库表单
    @RequestMapping("/tooutdelete")
    public String toOutDelete(String ouuid, Model model) {
        orderDao.deleteOut(ouuid);
        List<Output> orders = orderDao.findAllOutput();
        model.addAttribute("orders", orders);
        return "page/output-list";
    }

    //入库单详情
    @RequestMapping("/showindetail")
    public String showInDdetail(String iuuid, Model model) {
        Input input = orderDao.selectByIn(iuuid);
        model.addAttribute("input", input);
        return "page/input-detail";
    }

    //去编辑入库
    @RequestMapping("/showinedit")
    public String showInEdit(String iuuid, Model model) {
        Input input = orderDao.selectByIn(iuuid);
        model.addAttribute("input", input);
        return "page/input-edit";
    }

    //编辑入库单
    @RequestMapping("/toinedit")
    public String toInEdit(Input input, Model model) {
        orderDao.updataIn(input);
        List<Input> orders = orderDao.findAllInput();
        model.addAttribute("orders", orders);
        return "page/input-list";
    }

    //出库单详情
    @RequestMapping("/showoutdetail")
    public String showOutDetail(String ouuid, Model model) {
        Output output = orderDao.selectByOut(ouuid);
        model.addAttribute("output", output);
        return "page/output-detail";
    }

    //去编辑出库
    @RequestMapping("/showoutedit")
    public String toOutEdit(String ouuid, Model model) {
        Output output = orderDao.selectByOut(ouuid);
        model.addAttribute("output", output);
        return "page/output-edit";
    }

    //编辑出库单
    @RequestMapping("/tooutedit")
    public String showOutedit(Output output, Model model) {
        orderDao.updataOut(output);
        List<Output> orders = orderDao.findAllOutput();
        model.addAttribute("orders", orders);
        return "page/output-list";
    }


    @RequestMapping("/showsell")
    public String showSell(Model model){
        List<MedicinalTable> medicinalTables = new ArrayList<MedicinalTable>();
        List<MedicinalTable> medinputs = medicinalTableDao.findAllIn();
        for (MedicinalTable m: medinputs) {
            m.setTid(1);
        }
        List<MedicinalTable> medoutputs = medicinalTableDao.findAllOut();
        for (MedicinalTable m:medoutputs) {
            m.setTid(0);
        }
        medinputs.addAll(medoutputs);
        medicinalTables.addAll(medinputs);
        model.addAttribute("tables",medicinalTables);
        return "page/table-list";
    }

}
