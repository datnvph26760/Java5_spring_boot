package poly.ontap.bai1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


import java.util.UUID;

@Entity @Table(name = "ChiTietSP")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ChiTietSP {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "IdSP",
            referencedColumnName = "Id"
    )
    private SanPham sp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "IdNsx",
            referencedColumnName = "Id"
    )
    private NSX nsx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "IdMauSac",
            referencedColumnName = "Id"
    )
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "IdDongSP",
            referencedColumnName = "Id"
    )
    private DongSP dongSP;
    @Column(name = "NamBH")
    private int namBH;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "SoLuongTon")
    private int sLTon;
    @Column(name = "GiaNhap")
    private int giaNhap;
    @Column(name = "GiaBan")
    private int giaBan;
}
