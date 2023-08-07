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
import poly.ontap.bai1.entity.ChucVu;
import poly.ontap.bai1.entity.MauSac;
import poly.ontap.bai1.repository.MauSacRepository;
import poly.ontap.bai1.viewmodel.ChucVuVM;
import poly.ontap.bai1.viewmodel.MauSacVM;

import java.util.List;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {
    @Autowired
    private MauSacRepository msRepo;

    @Autowired
    private MauSacVM mauSacVM;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<MauSac> ds = msRepo.findAll();
        model.addAttribute("list", ds);
        return "mauSac/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") MauSac mauSac) {
        this.msRepo.delete(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/create")
    public String create(Model model) {
        MauSac ms = new MauSac();
        model.addAttribute("vm", ms);
        return "mauSac/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") MauSac mauSac, Model model) {
        mauSacVM.setMa(mauSac.getMa());
        mauSacVM.setTen(mauSac.getTen());
        model.addAttribute("vm", mauSacVM);
        model.addAttribute("ds",mauSac);
        return "mauSac/update";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("vm") MauSacVM vm,
                        BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(vm.getTen());
            return "mauSac/add";
        } else {
            MauSac ms = new MauSac();
            ms.setMa(vm.getMa());
            ms.setTen(vm.getTen());
            this.msRepo.save(ms);
        }
        return "redirect:/mau-sac/hien-thi";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") MauSac mauSac,
                         @Valid @ModelAttribute("vm") MauSacVM vm,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "mauSac/update";
        } else {
            mauSac.setMa(vm.getMa());
            mauSac.setTen(vm.getTen());
            this.msRepo.save(mauSac);
        }
        return "redirect:/mau-sac/hien-thi";
    }

}
