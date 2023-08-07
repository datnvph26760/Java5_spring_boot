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

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "HoaDon")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Component
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "IdKH",
            referencedColumnName = "Id"
    )
    private KhachHang kh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "IdNV",
            referencedColumnName = "Id"
    )
    private NhanVien nv;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "NgayShip")
    private Date ngayShip;

    @Column(name = "NgayNhan")
    private Date ngayNhan;

    @Column(name = "TinhTrang")
    private int tinhTrang;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "Sdt")
    private String sdt;

}
