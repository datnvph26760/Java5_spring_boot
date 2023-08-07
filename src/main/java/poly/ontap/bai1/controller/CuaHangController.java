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
import org.springframework.web.bind.annotation.RequestParam;
import poly.ontap.bai1.entity.CuaHang;
import poly.ontap.bai1.repository.CuaHangRepository;
import poly.ontap.bai1.viewmodel.CuaHangVM;

import java.util.List;


@Controller
@RequestMapping("/cua-hang")
public class CuaHangController {

    @Autowired
    private CuaHangRepository chRepo;
    @Autowired
    private CuaHangVM cuaHangVM;

//    @Autowired
//    private CuaHang ch;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<CuaHang> listCH = chRepo.findAll();
        model.addAttribute("listCH", listCH);
        return "cuaHang/ch_hienThi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") CuaHang cuaHang) {
        System.out.println(cuaHang.getTen());
        this.chRepo.delete(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/create")
    public String create(Model model) {
        CuaHang cuaHang = new CuaHang();
        model.addAttribute("chvm", cuaHang);
        return "cuaHang/ch_them";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("chvm") CuaHangVM chvm,
                        BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(chvm.getTen());
            return "cuaHang/ch_them";
        } else {
            CuaHang ch = new CuaHang();
            ch.setMa(chvm.getMa());
            ch.setTen(chvm.getTen());
            ch.setDiaChi(chvm.getDiaChi());
            ch.setThanhPho(chvm.getThanhPho());
            ch.setQuocGia(chvm.getQuocGia());
            this.chRepo.save(ch);
        }
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") CuaHang cuaHang, Model model) {
        cuaHangVM.setMa(cuaHang.getMa());
        cuaHangVM.setTen(cuaHang.getTen());
        cuaHangVM.setDiaChi(cuaHang.getDiaChi());
        cuaHangVM.setThanhPho(cuaHang.getThanhPho());
        cuaHangVM.setQuocGia(cuaHang.getQuocGia());
        model.addAttribute("vm", cuaHangVM);
        model.addAttribute("ch", cuaHang);
        return "cuaHang/ch_edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") CuaHang cuaHang,
                         @Valid @ModelAttribute("vm") CuaHangVM vm,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "cuaHang/ch_edit";
        } else {
            cuaHang.setMa(vm.getMa());
            cuaHang.setTen(vm.getTen());
            cuaHang.setDiaChi(vm.getDiaChi());
            cuaHang.setThanhPho(vm.getThanhPho());
            cuaHang.setQuocGia(vm.getQuocGia());
            this.chRepo.save(cuaHang);
        }
        return "redirect:/cua-hang/hien-thi";
    }
}
