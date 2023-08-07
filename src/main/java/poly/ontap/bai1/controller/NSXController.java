package poly.ontap.bai1.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.ontap.bai1.entity.NSX;
import poly.ontap.bai1.repository.NSXRepository;
import poly.ontap.bai1.viewmodel.NSXVM;

import java.util.List;

@Controller
@RequestMapping("nha-san-xuat")
public class NSXController {
    @Autowired
    private NSXRepository nsxRepository;

    @Autowired
    private NSXVM nsxvm;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<NSX> ds = nsxRepository.findAll();
        model.addAttribute("list", ds);
        return "nSX/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") NSX nsx) {
        this.nsxRepository.delete(nsx);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("/create")
    public String create(Model model) {
        NSX nsx = new NSX();
        model.addAttribute("vm", nsx);
        return "nSX/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") NSX nsx, Model model) {
        nsxvm.setMa(nsx.getMa());
        nsxvm.setTen(nsx.getTen());
        model.addAttribute("vm", nsxvm);
        model.addAttribute("ds",nsx);
        return "nSX/update";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("vm") NSXVM vm,
                        BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(vm.getTen());
            return "nSX/add";
        } else {
            NSX nsx = new NSX();
            nsx.setMa(vm.getMa());
            nsx.setTen(vm.getTen());
            this.nsxRepository.save(nsx);
        }
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") NSX nsx,
                         @Valid @ModelAttribute("vm") NSXVM vm,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "mauSac/update";
        } else {
            nsx.setMa(vm.getMa());
            nsx.setTen(vm.getTen());
            this.nsxRepository.save(nsx);
        }
        return "redirect:/nha-san-xuat/hien-thi";
    }

}
