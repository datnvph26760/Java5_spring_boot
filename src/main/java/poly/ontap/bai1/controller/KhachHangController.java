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
import poly.ontap.bai1.entity.CuaHang;
import poly.ontap.bai1.entity.KhachHang;
import poly.ontap.bai1.repository.KhachHangRepository;
import poly.ontap.bai1.viewmodel.CuaHangVM;
import poly.ontap.bai1.viewmodel.KhachHangVM;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangRepository khRepo;
    @Autowired
    private KhachHangVM khachHangVM;


    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<KhachHang> list = khRepo.findAll();
        model.addAttribute("listCH", list);
        return "khachHang/kh_hienThi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") KhachHang khachHang) {
        System.out.println(khachHang.getTen());
        this.khRepo.delete(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/create")
    public String create(Model model) {
        KhachHang khachHang = new KhachHang();
        model.addAttribute("vm", khachHang);
        return "khachHang/kh_them";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("vm") KhachHangVM vm,
                        BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(vm.getTen());
            return "khachHang/kh_them";
        } else {
            KhachHang kh = new KhachHang();
            kh.setMa(vm.getMa());
            kh.setTen(vm.getTen());
            kh.setTenDem(vm.getTenDem());
            kh.setHo(vm.getHo());
            kh.setNgaySinh(vm.getNgaySinh());
            kh.setSdt(vm.getSdt());
            kh.setMatKhau(vm.getMatKhau());
            kh.setDiaChi(vm.getDiaChi());
            kh.setThanhPho(vm.getThanhPho());
            kh.setQuocGia(vm.getQuocGia());
            this.khRepo.save(kh);
        }
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") KhachHang khachHang, Model model) {
        khachHangVM.setMa(khachHang.getMa());
        khachHangVM.setHo(khachHang.getHo());
        khachHangVM.setTenDem(khachHang.getTenDem());
        khachHangVM.setTen(khachHang.getTen());
        khachHangVM.setSdt(khachHang.getSdt());
        khachHangVM.setDiaChi(khachHang.getDiaChi());
        khachHangVM.setMatKhau(khachHang.getMatKhau());
        khachHangVM.setThanhPho(khachHang.getThanhPho());
        khachHangVM.setNgaySinh(khachHang.getNgaySinh());
        khachHangVM.setQuocGia(khachHang.getQuocGia());
        model.addAttribute("vm", khachHangVM);
        model.addAttribute("action","/khach-hang/update/"+khachHang.getId());
        return "khachHang/kh_edit";
    }

    @PostMapping("/update/{id}")
    public String update(
            @PathVariable("id") KhachHang khachHang,
                         @Valid @ModelAttribute("vm") KhachHangVM vm,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "khachHang/kh_edit";
        } else {
//            KhachHang khachHang = new KhachHang();
            khachHang.setMa(vm.getMa());
            khachHang.setTen(vm.getTen());
            khachHang.setDiaChi(vm.getDiaChi());
            khachHang.setThanhPho(vm.getThanhPho());
            khachHang.setQuocGia(vm.getQuocGia());
            khachHang.setTenDem(vm.getTenDem());
            khachHang.setHo(vm.getHo());
            khachHang.setNgaySinh(vm.getNgaySinh());
            khachHang.setMatKhau(vm.getMatKhau());
            khachHang.setSdt(vm.getSdt());

            this.khRepo.save(khachHang);
        }
        return "redirect:/khach-hang/hien-thi";
    }
}
