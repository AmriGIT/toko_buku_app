package co.g2maruli.userapi.repository;

import co.g2maruli.userapi.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BukuRepository extends JpaRepository<Buku,Integer> {
    public Buku getBukuByJudul(String judul);
}
