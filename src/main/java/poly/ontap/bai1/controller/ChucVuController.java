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
import poly.ontap.bai1.entity.CuaHang;
import poly.ontap.bai1.repository.ChucVuRepository;
import poly.ontap.bai1.viewmodel.ChucVuVM;
import poly.ontap.bai1.viewmodel.CuaHangVM;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuRepository cvRepo;

    @Autowired
    private ChucVuVM chucVuVM;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<ChucVu> ds = cvRepo.findAll();
        model.addAttribute("list", ds);
        return "chucVu/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") ChucVu chucVu) {
        this.cvRepo.delete(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/create")
    public String create(Model model) {
        ChucVu cv = new ChucVu();
        model.addAttribute("vm", cv);
        return "chucVu/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") ChucVu chucVu, Model model) {
        chucVuVM.setMa(chucVu.getMa());
        chucVuVM.setTen(chucVu.getTen());
        model.addAttribute("vm", chucVuVM);
        model.addAttribute("ds",chucVu);
        return "chucVu/update";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("vm") ChucVuVM vm,
                        BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(vm.getTen());
            return "chucVu/form";
        } else {
            ChucVu cv = new ChucVu();
            cv.setMa(vm.getMa());
            cv.setTen(vm.getTen());
            this.cvRepo.save(cv);
        }
        return "redirect:/chuc-vu/hien-thi";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") ChucVu chucVu,
                         @Valid @ModelAttribute("vm") ChucVuVM vm,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "chucVu/update";
        } else {
            chucVu.setMa(vm.getMa());
            chucVu.setTen(vm.getTen());
            this.cvRepo.save(chucVu);
        }
        return "redirect:/chuc-vu/hien-thi";
    }

}
