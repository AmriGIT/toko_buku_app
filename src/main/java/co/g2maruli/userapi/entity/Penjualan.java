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

    @ManyToOne
    @JoinColumn(name="customer_id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "penjualan",cascade = CascadeType.ALL)
    private List<ItemPenjualan> itemPenjualanList;

}
