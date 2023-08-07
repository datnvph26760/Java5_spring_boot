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
import poly.ontap.bai1.entity.HoaDon;
import poly.ontap.bai1.entity.KhachHang;
import poly.ontap.bai1.entity.NhanVien;
import poly.ontap.bai1.repository.HoaDonRepository;
import poly.ontap.bai1.repository.KhachHangRepository;
import poly.ontap.bai1.repository.NhanVienRepository;
import poly.ontap.bai1.viewmodel.HoaDonVM;
import poly.ontap.bai1.viewmodel.NhanVienVM;

import java.util.List;

@Controller
@RequestMapping("hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonRepository hdRepo;
    @Autowired
    private NhanVienRepository nvRepo;
    @Autowired
    private KhachHangRepository khRepo;
    @Autowired
    private HoaDonVM hoaDonVM;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<HoaDon> listHD = hdRepo.findAll();
        List<KhachHang> listKH = khRepo.findAll();
        List<NhanVien> listNV = nvRepo.findAll();
        model.addAttribute("listNV", listNV);
        model.addAttribute("listHD", listHD);
        model.addAttribute("listKH", listKH);
        return "hoaDon/hd_hienThi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") HoaDon hoaDon) {
        this.hdRepo.delete(hoaDon);
        return "redirect:/hoa-don/hien-thi";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<KhachHang> khachHangs = khRepo.findAll();
        List<NhanVien> nhanViens = nvRepo.findAll();
        HoaDon hoaDon = new HoaDon();
        model.addAttribute("khachHangs", khachHangs);
        model.addAttribute("nhanViens", nhanViens);
        model.addAttribute("hdvm", hoaDon);
        return "hoaDon/hd_them";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid @ModelAttribute("hdvm") HoaDonVM hoaDonVM, BindingResult result) {
        if (result.hasErrors()) {
            List<KhachHang> khachHangs = khRepo.findAll();
            List<NhanVien> nhanViens = nvRepo.findAll();
            model.addAttribute("nhanViens", khachHangs);
            model.addAttribute("nhanViens", nhanViens);
            return "hoaDon/hd_them";
        } else {

            HoaDon hoaDon = new HoaDon();
            hoaDon.setMa(hoaDonVM.getMa());
            hoaDon.setDiaChi(hoaDonVM.getDiaChi());
            hoaDon.setSdt(hoaDonVM.getSdt());
            hoaDon.setNgayNhan(hoaDonVM.getNgayNhan());
            hoaDon.setNgayShip(hoaDonVM.getNgayShip());
            hoaDon.setNgayTao(hoaDonVM.getNgayTao());
            hoaDon.setTenNguoiNhan(hoaDonVM.getTenNguoiNhan());
            hoaDon.setNgayThanhToan(hoaDonVM.getNgayThanhToan());
            hoaDon.setTinhTrang(hoaDonVM.getTinhTrang());

            KhachHang khachHang = hoaDonVM.getKh();
            NhanVien nhanVien = hoaDonVM.getNv();
            hoaDon.setKh(khachHang);
            hoaDon.setNv(nhanVien);
            hdRepo.save(hoaDon);
        }
        return "redirect:/hoa-don/hien-thi";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") HoaDon hoaDon, Model model) {
        hoaDonVM.setMa(hoaDon.getMa());
        hoaDonVM.setDiaChi(hoaDon.getDiaChi());
        hoaDonVM.setSdt(hoaDon.getSdt());
        hoaDonVM.setNgayShip(hoaDon.getNgayShip());
        hoaDonVM.setNgayTao(hoaDon.getNgayTao());
        hoaDonVM.setNgayNhan(hoaDon.getNgayNhan());
        hoaDonVM.setTenNguoiNhan(hoaDon.getTenNguoiNhan());
        hoaDonVM.setNgayThanhToan(hoaDon.getNgayThanhToan());
        hoaDonVM.setTinhTrang(hoaDon.getTinhTrang());
//--------------------------------------
        KhachHang kh = hoaDon.getKh();
        NhanVien nv = hoaDon.getNv();
        hoaDonVM.setKh(kh);
        hoaDonVM.setNv(nv);
        List<KhachHang> khachHangs = khRepo.findAll();
        List<NhanVien> nhanViens = nvRepo.findAll();
        model.addAttribute("khachHangs", khachHangs);
        model.addAttribute("nhanViens", nhanViens);
        model.addAttribute("hdvm", hoaDonVM);
        model.addAttribute("action", "/hoa-don/update/" + hoaDon.getId());
        return "hoaDon/hd_edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") HoaDon hoaDon,
                         @Valid @ModelAttribute("hdvm") HoaDonVM hdvm,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<KhachHang> khachHangs = khRepo.findAll();
            List<NhanVien> nhanViens = nvRepo.findAll();
            model.addAttribute("khachHangs", khachHangs);
            model.addAttribute("nhanViens", nhanViens);
            return "hoaDon/hd_edit";
        } else {
            hoaDon.setMa(hdvm.getMa());
            hoaDon.setDiaChi(hdvm.getDiaChi());
            hoaDon.setSdt(hdvm.getSdt());
            hoaDon.setNgayShip(hdvm.getNgayShip());
            hoaDon.setNgayTao(hdvm.getNgayTao());
            hoaDon.setNgayNhan(hdvm.getNgayNhan());
            hoaDon.setTenNguoiNhan(hdvm.getTenNguoiNhan());
            hoaDon.setNgayThanhToan(hdvm.getNgayThanhToan());
            hoaDon.setTinhTrang(hdvm.getTinhTrang());

            KhachHang khachHang = hdvm.getKh();
            NhanVien nhanVien = hdvm.getNv();
            hoaDon.setKh(khachHang);
            hoaDon.setNv(nhanVien);
            hdRepo.save(hoaDon);
            return "redirect:/hoa-don/hien-thi";
        }
    }

}
