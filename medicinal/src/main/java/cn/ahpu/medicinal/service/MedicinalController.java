package cn.ahpu.medicinal.service;


import cn.ahpu.medicinal.impl.MedicinalDaoImpl;
import cn.ahpu.medicinal.impl.UserDaoImpl;
import cn.ahpu.medicinal.pojo.Medicinal;
import cn.ahpu.medicinal.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/medicinal")
public class MedicinalController {

    @Autowired
    MedicinalDaoImpl medicinalDao;

    @RequestMapping("/showlist")
    public String showList(Model model) {
        List<Medicinal> medicinals = medicinalDao.findAll();
        model.addAttribute("meds", medicinals);
        return "page/product-list";
    }

    @RequestMapping("/showdetail")
    public String showDetail(Integer mno, Model model) {
        Medicinal medicinal = medicinalDao.selectById(mno);
        model.addAttribute("medicinal", medicinal);
        return "page/product-detail";
    }

    @RequestMapping("/showedit")
    public String showEdit(Integer mno, Model model) {
        Medicinal medicinal = medicinalDao.selectById(mno);
        model.addAttribute("medicinal", medicinal);
        return "page/product-edit";
    }

    /*view中string类型转换为Date类型*/
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @RequestMapping("/toedit")
    public String toEdit(Medicinal medicinal,Model model) {
        medicinalDao.updataMedicinal(medicinal);
        List<Medicinal> medicinals = medicinalDao.findAll();
        model.addAttribute("meds", medicinals);
        return "page/product-list";
    }

    @RequestMapping("/todelete")
    public String toDelete(Integer mno,Model model){
        medicinalDao.deleteMedicinal(mno);
        List<Medicinal> medicinals = medicinalDao.findAll();
        model.addAttribute("meds", medicinals);
        return "page/product-list";
    }

    @RequestMapping("/showadd")
    public String showAdd(){
        return "page/product-add";
    }

    @RequestMapping("/toadd")
    public String toAdd(Medicinal medicinal,Model model){
        medicinalDao.insertMedicinal(medicinal);
        List<Medicinal> medicinals = medicinalDao.findAll();
        model.addAttribute("meds", medicinals);
        return "page/product-list";
    }

}
