package co.g2maruli.userapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_item_penjualan")
public class ItemPenjualan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nama")
    private String nama;

    @Column(name = "harga")
    private Integer harga;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name = "total_harga")
    private Integer totalHarga;

    @ManyToOne
    @JoinColumn(name = "penjualan_id")
    private Penjualan penjualan;
}
