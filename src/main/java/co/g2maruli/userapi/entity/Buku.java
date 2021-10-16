package co.g2maruli.userapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_buku")
public class Buku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="judul")
    private String judul;

    @Column(name="penerbit")
    private String penerbit;

    @Column(name="stock")
    private Integer stock;
}
