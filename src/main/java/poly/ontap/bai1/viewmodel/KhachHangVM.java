package poly.ontap.bai1.viewmodel;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class KhachHangVM {

    @NotEmpty(message = "Mã không đươc để trống")
    private String ma;

    @NotEmpty(message = "Tên không đươc để trống")
    private String ten;

    @NotEmpty(message = "Tên đệm không đươc để trống")
    private String tenDem;

    @NotEmpty(message = "Họ không đươc để trống")
    private String ho;

    @NotNull(message = "Ngày sinh không được để trống")
    @PastOrPresent(message = "Ngày sinh phải là ngày trong quá khứ!")
    private Date ngaySinh;

    @NotEmpty(message = "Số điện thoại không đươc để trống")
    @Size(min = 10, max = 15, message = "Số điện thoại phải có độ dài từ 10 đến 15 ký tự")
    private String sdt;

    @NotEmpty(message = "Địa chỉ không đươc để trống")
    private String diaChi;

    @NotEmpty(message = "Thành phố không đươc để trống")
    private String thanhPho;

    @NotEmpty(message = "Quốc gia không đươc để trống")
    private String quocGia;

    @NotEmpty(message = "Mật khẩu không đươc để trống")
    @Size(min = 5, max = 20, message = "Mật khẩu phải có độ dài từ 8 đến 20 ký tự")
    private String matKhau;
}
