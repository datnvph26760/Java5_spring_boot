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

@Entity @Table(name = "NhanVien")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Component
public class NhanVien {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "TrangThai")
    private int trangThai;

//    @Column(name = "IdGuiBC")
//    private String idGuiBC;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "IdCV",
            referencedColumnName = "Id"
    )
    private ChucVu cv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "IdCH",
            referencedColumnName = "Id"
    )
    private CuaHang ch;
}
