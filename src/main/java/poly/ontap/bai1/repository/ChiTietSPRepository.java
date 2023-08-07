package poly.ontap.bai1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.ontap.bai1.entity.ChiTietSP;

import java.util.UUID;

public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, UUID> {
}
