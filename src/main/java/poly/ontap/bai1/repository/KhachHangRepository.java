package poly.ontap.bai1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.ontap.bai1.entity.KhachHang;

import java.util.UUID;

public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
}
