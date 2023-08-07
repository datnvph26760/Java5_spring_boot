package poly.ontap.bai1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.UUID;
@Entity @Table(name = "KhachHang")
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Component
public class KhachHang {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="Ma")
    private String ma;

    @Column(name="Ten")
    private String ten;

    @Column(name="TenDem")
    private String tenDem;

    @Column(name="Ho")
    private String ho;

    @Column(name="NgaySinh")
    private Date ngaySinh;

    @Column(name="Sdt")
    private String sdt;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="ThanhPho")
    private String thanhPho;

    @Column(name="QuocGia")
    private String quocGia;

    @Column(name="MatKhau")
    private String matKhau;

}
