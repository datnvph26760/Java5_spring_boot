package poly.ontap.bai1.viewmodel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import poly.ontap.bai1.entity.KhachHang;
import poly.ontap.bai1.entity.NhanVien;

import java.sql.Date;
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Component
public class HoaDonVM {

    private KhachHang kh;

    private NhanVien nv;

    @NotEmpty(message = "Mã không được để trống")
    private String ma;

    @NotNull(message = "Dữ liệu không hợp lệ!")
    private Date ngayTao;

    @NotNull(message = "Dữ liệu không hợp lệ!")
    private Date ngayThanhToan;

    @NotNull(message = "Dữ liệu không hợp lệ!")
    private Date ngayShip;

    @NotNull(message = "Dữ liệu không hợp lệ!")
    private Date ngayNhan;

    @NotNull(message = "Dữ liệu không hợp lệ!")
    private int tinhTrang;

    @NotBlank(message = "Không được để trống!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    @Length(max = 100, message = "Tên không được quá 100 ký tự")
    private String diaChi;

    @NotBlank(message = "Không được để trống!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    @Length(max = 50, message = "Tên không được quá 50 ký tự")
    private String tenNguoiNhan;

    @NotBlank(message = "Không được để trống!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    @Size(min = 10,max = 15,message = "Số điện thoại phải có độ dài từ 10 đến 15 ký tự")
    private String sdt;
}
