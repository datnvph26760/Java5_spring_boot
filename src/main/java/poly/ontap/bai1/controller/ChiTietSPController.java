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
import poly.ontap.bai1.entity.ChiTietSP;
import poly.ontap.bai1.entity.DongSP;
import poly.ontap.bai1.entity.HoaDon;
import poly.ontap.bai1.entity.KhachHang;
import poly.ontap.bai1.entity.MauSac;
import poly.ontap.bai1.entity.NSX;
import poly.ontap.bai1.entity.NhanVien;
import poly.ontap.bai1.entity.SanPham;
import poly.ontap.bai1.repository.ChiTietSPRepository;
import poly.ontap.bai1.repository.DongSPRepository;
import poly.ontap.bai1.repository.MauSacRepository;
import poly.ontap.bai1.repository.NSXRepository;
import poly.ontap.bai1.repository.SanPhamRepository;
import poly.ontap.bai1.viewmodel.ChiTietSPVM;
import poly.ontap.bai1.viewmodel.HoaDonVM;

import java.util.List;

@Controller
@RequestMapping("chi-tiet-san-pham")
public class ChiTietSPController {
    @Autowired
    private ChiTietSPRepository ctspRepo;
    @Autowired
    private SanPhamRepository spRepo;
    @Autowired
    private NSXRepository nsxRepo;
    @Autowired
    private MauSacRepository msRepo;
    @Autowired
    private DongSPRepository dspRepo;

    @Autowired
    private ChiTietSPVM chiTietSPVM;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<ChiTietSP> listCTSP = ctspRepo.findAll();
        List<SanPham> listSP = spRepo.findAll();
        List<MauSac> listMS = msRepo.findAll();
        List<DongSP> listDSP = dspRepo.findAll();
        List<NSX> listNSX = nsxRepo.findAll();
        model.addAttribute("listCTSP", listCTSP);
        model.addAttribute("listSP", listSP);
        model.addAttribute("listMS", listMS);
        model.addAttribute("listNSX", listNSX);
        model.addAttribute("listDSP", listDSP);
        return "chiTietSP/hienThi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") ChiTietSP ctsp) {
        this.ctspRepo.delete(ctsp);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<SanPham> sanPhams = spRepo.findAll();
        List<MauSac> mauSacs = msRepo.findAll();
        List<DongSP> dongSPS = dspRepo.findAll();
        List<NSX> nsxes = nsxRepo.findAll();
        ChiTietSP chiTietSP = new ChiTietSP();
        model.addAttribute("sanPhams", sanPhams);
        model.addAttribute("mauSacs", mauSacs);
        model.addAttribute("dongSPS", dongSPS);
        model.addAttribute("nsxes", nsxes);
        model.addAttribute("ctspvm",chiTietSP);
        return "chiTietSP/them";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid @ModelAttribute("ctspvm") ChiTietSPVM chiTietSPVM, BindingResult result) {
        if (result.hasErrors()) {
            List<SanPham> sanPhams = spRepo.findAll();
            List<MauSac> mauSacs = msRepo.findAll();
            List<DongSP> dongSPS = dspRepo.findAll();
            List<NSX> nsxes = nsxRepo.findAll();

            model.addAttribute("sanPhams", sanPhams);
            model.addAttribute("mauSacs", mauSacs);
            model.addAttribute("dongSPS", dongSPS);
            model.addAttribute("nsxes", nsxes);
            return "chiTietSP/them";
        } else {

            ChiTietSP chiTietSP = new ChiTietSP();
            chiTietSP.setGiaBan(chiTietSPVM.getGiaBan());
            chiTietSP.setGiaNhap(chiTietSPVM.getGiaNhap());
            chiTietSP.setMoTa(chiTietSPVM.getMoTa());
            chiTietSP.setSLTon(chiTietSPVM.getSLTon());
            chiTietSP.setNamBH(chiTietSPVM.getNamBH());
            SanPham sanPham = chiTietSPVM.getSp();
            MauSac mauSac = chiTietSPVM.getMauSac();
            DongSP dongSP = chiTietSPVM.getDongSP();
            NSX nsx = chiTietSPVM.getNsx();

            chiTietSP.setMauSac(mauSac);
            chiTietSP.setSp(sanPham);
            chiTietSP.setDongSP(dongSP);
            chiTietSP.setNsx(nsx);
            ctspRepo.save(chiTietSP);
        }
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") ChiTietSP chiTietSP, Model model) {
        chiTietSPVM.setGiaBan(chiTietSP.getGiaBan());
        chiTietSPVM.setGiaNhap(chiTietSP.getGiaNhap());
        chiTietSPVM.setMoTa(chiTietSP.getMoTa());
        chiTietSPVM.setSLTon(chiTietSP.getSLTon());
        chiTietSPVM.setNamBH(chiTietSP.getNamBH());

        SanPham sanPham = chiTietSP.getSp();
        MauSac mauSac = chiTietSP.getMauSac();
        DongSP dongSP = chiTietSP.getDongSP();
        NSX nsx = chiTietSP.getNsx();

        chiTietSPVM.setMauSac(mauSac);
        chiTietSPVM.setSp(sanPham);
        chiTietSPVM.setDongSP(dongSP);
        chiTietSPVM.setNsx(nsx);

        List<SanPham> sanPhams = spRepo.findAll();
        List<MauSac> mauSacs = msRepo.findAll();
        List<DongSP> dongSPS = dspRepo.findAll();
        List<NSX> nsxes = nsxRepo.findAll();

        model.addAttribute("sanPhams", sanPhams);
        model.addAttribute("mauSacs", mauSacs);
        model.addAttribute("dongSPS", dongSPS);
        model.addAttribute("nsxes", nsxes);
        return "chiTietSP/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") ChiTietSP chiTietSP,
                         @Valid @ModelAttribute("hdvm") ChiTietSPVM ctspvm,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<SanPham> sanPhams = spRepo.findAll();
            List<MauSac> mauSacs = msRepo.findAll();
            List<DongSP> dongSPS = dspRepo.findAll();
            List<NSX> nsxes = nsxRepo.findAll();
            model.addAttribute("sanPhams", sanPhams);
            model.addAttribute("mauSacs", mauSacs);
            model.addAttribute("dongSPS", dongSPS);
            model.addAttribute("nsxes", nsxes);
            return "chiTietSP/edit";
        } else {
            chiTietSP.setGiaBan(ctspvm.getGiaBan());
            chiTietSP.setGiaNhap(ctspvm.getGiaNhap());
            chiTietSP.setMoTa(ctspvm.getMoTa());
            chiTietSP.setSLTon(ctspvm.getSLTon());
            chiTietSP.setNamBH(ctspvm.getNamBH());
            SanPham sanPham = ctspvm.getSp();
            MauSac mauSac = ctspvm.getMauSac();
            DongSP dongSP = ctspvm.getDongSP();
            NSX nsx = ctspvm.getNsx();

            chiTietSP.setMauSac(mauSac);
            chiTietSP.setSp(sanPham);
            chiTietSP.setDongSP(dongSP);
            chiTietSP.setNsx(nsx);
            ctspRepo.save(chiTietSP);
            return "redirect:/chi-tiet-san-pham/hien-thi";
        }
    }
}
