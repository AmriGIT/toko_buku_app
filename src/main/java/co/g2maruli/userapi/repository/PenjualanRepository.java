package co.g2maruli.userapi.repository;

import co.g2maruli.userapi.entity.Penjualan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenjualanRepository extends JpaRepository<Penjualan,Integer> {

    public Penjualan getPenjualanByNamaCustomer(String namaCustomer);

}
