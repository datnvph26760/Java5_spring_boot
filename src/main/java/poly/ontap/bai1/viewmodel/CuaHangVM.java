package poly.ontap.bai1.viewmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.UUID;
//@Entity @Table(name = "CuaHang")
@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
@Component
public class CuaHangVM {

    @NotBlank(message = "Kho dc de trong")
    private String ma;

    @NotBlank(message = "Kho dc de trong")
    private String ten;

    @NotBlank(message = "Kho dc de trong")
    private String diaChi;

    @NotBlank(message = "Kho dc de trong")
    private String thanhPho;

    @NotBlank(message = "Kho dc de trong")
    private String quocGia;
}
