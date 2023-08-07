package poly.ontap.bai1.viewmodel;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import poly.ontap.bai1.entity.ChucVu;
import poly.ontap.bai1.entity.CuaHang;

import java.sql.Date;
import java.util.UUID;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Component
public class NhanVienVM {

    @NotEmpty(message = "Mã không được để trống")
    private String ma;


    @NotBlank(message = "Không được để trống!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    @Length(max = 30, message = "Tên không được quá 30 ký tự")
    private String ten;

    //    @NotBlank(message = "Không được để trống!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    @Length(max = 30, message = "Tên đệm không được quá 30 ký tự")
    private String tenDem;

    @NotBlank(message = "Không được để trống!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    @Length(max = 30, message = "Họ không được quá 30 ký tự")
    private String ho;

//    @NotBlank(message = "Không được để trống!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    @PastOrPresent(message = "Ngày sinh phải là ngày trong quá khứ!")
    private Date ngaySinh;

    @NotBlank(message = "Không được để trống!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    @Pattern(regexp = "Nam|Nữ", message = "Dữ liệu không hợp lệ!")
    private String gioiTinh = "Nam";

    @NotBlank(message = "Không được để trống!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    @Length(max = 100, message = "Địa chỉ không được quá 100 ký tự")
    private String diaChi;

    @NotBlank(message = "Không được để trống!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    @Size(min = 10,max = 15,message = "Số điện thoại phải có độ dài từ 10 đến 15 ký tự")
    private String sdt;

    @NotBlank(message = "Không được để trống!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    @Size(min = 6,max = 15,message = "Mật Khẩu phải có độ dài từ 6 đến 15 ký tự")
    private String matKhau;

    @NotNull(message = "Dữ liệu không hợp lệ!")
//    @Pattern(regexp = "0", message = "Dữ liệu không hợp lệ!")
    private int trangThai ;

    private CuaHang ch;

    private ChucVu cv;
}
