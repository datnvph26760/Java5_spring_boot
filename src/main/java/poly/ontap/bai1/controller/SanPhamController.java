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
import poly.ontap.bai1.entity.SanPham;
import poly.ontap.bai1.repository.SanPhamRepository;
import poly.ontap.bai1.viewmodel.ChucVuVM;
import poly.ontap.bai1.viewmodel.SanPhamVM;

import java.util.List;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamRepository spRepo;

    @Autowired
    private SanPham sp;

    @Autowired
    private SanPhamVM sanPhamVM;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<SanPham> ds = spRepo.findAll();
        model.addAttribute("list", ds);
        return "sanPham/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") SanPham sanPham) {
        this.spRepo.delete(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/create")
    public String create(Model model) {
        SanPham sp = new SanPham();
        model.addAttribute("vm", sp);
        return "sanPham/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") SanPham sanPham, Model model) {
        sanPhamVM.setMa(sanPham.getMa());
        sanPhamVM.setTen(sanPham.getTen());
        model.addAttribute("ds",sanPham);
        model.addAttribute("vm", sanPhamVM);
        return "sanPham/update";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("vm") SanPhamVM vm,
                        BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(vm.getTen());
            return "sanPham/add";
        } else {
            SanPham sp = new SanPham();
            sp.setMa(vm.getMa());
            sp.setTen(vm.getTen());
            this.spRepo.save(sp);
        }
        return "redirect:/san-pham/hien-thi";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") SanPham sanPham,
                         @Valid @ModelAttribute("vm") SanPhamVM vm,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "sanPham/update";
        } else {
            sanPham.setMa(vm.getMa());
            sanPham.setTen(vm.getTen());
            this.spRepo.save(sanPham);
        }
        return "redirect:/san-pham/hien-thi";
    }

}
