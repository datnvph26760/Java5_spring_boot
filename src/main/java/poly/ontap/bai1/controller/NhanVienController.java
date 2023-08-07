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
import poly.ontap.bai1.entity.NhanVien;
import poly.ontap.bai1.repository.ChucVuRepository;
import poly.ontap.bai1.repository.CuaHangRepository;
import poly.ontap.bai1.repository.NhanVienRepository;
import poly.ontap.bai1.viewmodel.NhanVienVM;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienRepository nvRepo;
    @Autowired
    private ChucVuRepository cvRepo;
    @Autowired
    private CuaHangRepository chRepo;
    @Autowired
    private NhanVienVM nhanVienVM;

    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        List<NhanVien> listNV = nvRepo.findAll();
//        List<ChucVu> listCV = cvRepo.findAll();
//        List<CuaHang> listCH = chRepo.findAll();
        model.addAttribute("listNV",listNV);
//        model.addAttribute("listCH",listCH);
//        model.addAttribute("listCV",listCV);
        return "nhanVien/nv_hienThi";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") NhanVien nhanVien) {
        this.nvRepo.delete(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/create")
    public String create(Model model){
    List<ChucVu> chucVus = cvRepo.findAll();
    List<CuaHang> cuaHangs = chRepo.findAll();
    NhanVien nv = new NhanVien();
    model.addAttribute("chucVus",chucVus);
    model.addAttribute("cuaHangs",cuaHangs);
    model.addAttribute("nvvm",nv);
    return "nhanVien/nv_them";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid @ModelAttribute("nvvm") NhanVienVM nhanVienVM, BindingResult result){
        if (result.hasErrors()){
            List<ChucVu> chucVus = cvRepo.findAll();
            List<CuaHang> cuaHangs = chRepo.findAll();
            model.addAttribute("chucVus", chucVus);
            model.addAttribute("cuaHangs", cuaHangs);
            return "nhanVien/nv_them";
        } else {

            NhanVien nhanVien = new NhanVien();
            nhanVien.setMa(nhanVienVM.getMa());
            nhanVien.setHo(nhanVienVM.getHo());
            nhanVien.setTenDem(nhanVienVM.getTenDem());
            nhanVien.setTen(nhanVienVM.getTen());
            nhanVien.setSdt(nhanVienVM.getSdt());
            nhanVien.setGioiTinh(nhanVienVM.getGioiTinh());
            nhanVien.setNgaySinh(nhanVienVM.getNgaySinh());
            nhanVien.setMatKhau(nhanVienVM.getMatKhau());
            nhanVien.setDiaChi(nhanVienVM.getDiaChi());
            nhanVien.setTrangThai(nhanVienVM.getTrangThai());

            ChucVu chucVu = nhanVienVM.getCv();  // Lấy đối tượng ChucVu từ nhanVienVM
            CuaHang cuaHang = nhanVienVM.getCh();  // Lấy đối tượng CuaHang từ nhanVienVM

            nhanVien.setCv(chucVu);
            nhanVien.setCh(cuaHang);
            nvRepo.save(nhanVien);

        }
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") NhanVien nhanVien,Model model){
        nhanVienVM.setMa(nhanVien.getMa());
        nhanVienVM.setHo(nhanVien.getHo());
        nhanVienVM.setTenDem(nhanVien.getTenDem());
        nhanVienVM.setTen(nhanVien.getTen());
        nhanVienVM.setDiaChi(nhanVien.getDiaChi());
        nhanVienVM.setGioiTinh(nhanVien.getGioiTinh());
        nhanVienVM.setNgaySinh(nhanVien.getNgaySinh());
        nhanVienVM.setMatKhau(nhanVien.getMatKhau());
        nhanVienVM.setSdt(nhanVien.getSdt());
        nhanVienVM.setTrangThai(nhanVien.getTrangThai());

        ChucVu cv = nhanVien.getCv();
        CuaHang ch = nhanVien.getCh();
        nhanVienVM.setCv(cv);
        nhanVienVM.setCh(ch);
        List<ChucVu> chucVus = cvRepo.findAll();
        List<CuaHang> cuaHangs = chRepo.findAll();
        model.addAttribute("chucVus",chucVus);
        model.addAttribute("cuaHangs",cuaHangs);
        model.addAttribute("nvvm",nhanVienVM);
        model.addAttribute("action","/nhan-vien/update/"+nhanVien.getId());
        return "nhanVien/nv_edit";
    }
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") NhanVien nhanVien,
                         @Valid @ModelAttribute("nvvm") NhanVienVM nvvm,
                         BindingResult result,Model model){
        if (result.hasErrors()){
            List<ChucVu> chucVus = cvRepo.findAll();
            List<CuaHang> cuaHangs = chRepo.findAll();
            model.addAttribute("chucVus", chucVus);
            model.addAttribute("cuaHangs", cuaHangs);
            return "nhanVien/nv_edit";
        } else {
            nhanVien.setMa(nvvm.getMa());
            nhanVien.setHo(nvvm.getHo());
            nhanVien.setTenDem(nvvm.getTenDem());
            nhanVien.setTen(nvvm.getTen());
            nhanVien.setSdt(nvvm.getSdt());
            nhanVien.setGioiTinh(nvvm.getGioiTinh());
            nhanVien.setNgaySinh(nvvm.getNgaySinh());
            nhanVien.setMatKhau(nvvm.getMatKhau());
            nhanVien.setDiaChi(nvvm.getDiaChi());
            nhanVien.setTrangThai(nvvm.getTrangThai());

            ChucVu chucVu = nvvm.getCv();  // Lấy đối tượng ChucVu từ nhanVienVM
            CuaHang cuaHang = nvvm.getCh();  // Lấy đối tượng CuaHang từ nhanVienVM

            nhanVien.setCv(chucVu);
            nhanVien.setCh(cuaHang);
            nvRepo.save(nhanVien);
            return "redirect:/nhan-vien/hien-thi";
        }
    }
}
