package poly.ontap.bai1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.ontap.bai1.entity.SanPham;

import java.util.UUID;
@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
}
