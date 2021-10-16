package co.g2maruli.userapi.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="t_penjualan")
public class Penjualan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tanggal",nullable = false)
    private Date date;

    @Column(name="nama_customer",nullable = false)
    private String namaCustomer;

    @Column(name="total_belanjaan")
    private Integer totalBelanjaan;

    @OneToMany(mappedBy = "penjualan",cascade = CascadeType.ALL)
    private List<ItemPenjualan> itemPenjualanList;

}
