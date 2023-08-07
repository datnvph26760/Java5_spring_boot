package poly.ontap.bai1.viewmodel;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import poly.ontap.bai1.entity.DongSP;
import poly.ontap.bai1.entity.MauSac;
import poly.ontap.bai1.entity.NSX;
import poly.ontap.bai1.entity.SanPham;


@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Component
public class ChiTietSPVM {

    private SanPham sp;
    private NSX nsx;
    private MauSac mauSac;
    private DongSP dongSP;
    private int namBH;
    private String moTa;
    private int sLTon;
    private int giaNhap;
    private int giaBan;
}
