package poly.ontap.bai1.viewmodel;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SanPhamVM {

    @NotEmpty(message = "Không được để trống")
    private String ma;

    @NotEmpty(message = "Không được để trống")
    private String ten;
}
