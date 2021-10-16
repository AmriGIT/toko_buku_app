package co.g2maruli.userapi.dto;

import co.g2maruli.userapi.entity.Buku;
import co.g2maruli.userapi.entity.Penjualan;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
public class PenjualanDto {

    private String judul;

    private String namaPembeli;

    private Integer harga;

    private Integer quantity;

    private Integer totalHarga;

    private Penjualan penjualan;
}

