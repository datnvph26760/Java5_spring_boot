package poly.ontap.bai1.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.ontap.bai1.entity.ChucVu;
import poly.ontap.bai1.entity.DongSP;
import poly.ontap.bai1.repository.DongSPRepository;
import poly.ontap.bai1.viewmodel.ChucVuVM;
import poly.ontap.bai1.viewmodel.DongSPVM;

import java.util.List;

@Controller
@RequestMapping("dong-san-pham")
public class DongSPController {
    @Autowired
    private DongSPRepository dongSPRepository;

    @Autowired
    private DongSPVM dongSPVM;


    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<DongSP> ds = dongSPRepository.findAll();
        model.addAttribute("list", ds);
        return "dongSP/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") DongSP dongSP) {
        this.dongSPRepository.delete(dongSP);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("/create")
    public String create(Model model) {
        DongSP dongSP = new DongSP();
        model.addAttribute("vm", dongSP);
        return "dongSP/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") DongSP dongSP, Model model) {
        dongSPVM.setMa(dongSP.getMa());
        dongSPVM.setTen(dongSP.getTen());
        model.addAttribute("vm", dongSPVM);
        model.addAttribute("ds",dongSP);
        return "dongSP/update";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("vm") DongSPVM vm,
                        BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(vm.getTen());
            return "dongSP/add";
        } else {
            DongSP dongSP = new DongSP();
            dongSP.setMa(vm.getMa());
            dongSP.setTen(vm.getTen());
            this.dongSPRepository.save(dongSP);
        }
        return "redirect:/dong-san-pham/hien-thi";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") DongSP dongSP,
                         @Valid @ModelAttribute("vm") DongSPVM vm,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "dongSP/update";
        } else {
            dongSP.setMa(vm.getMa());
            dongSP.setTen(vm.getTen());
            this.dongSPRepository.save(dongSP);
        }
        return "redirect:/dong-san-pham/hien-thi";
    }

}
