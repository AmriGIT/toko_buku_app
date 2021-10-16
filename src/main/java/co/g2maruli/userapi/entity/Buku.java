package co.g2maruli.userapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="t_buku")
public class Buku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="judul",nullable = false)
    private String judul;

    @Column(name="penerbit",nullable = false)
    private String penerbit;

    @Column(name="stock",nullable = false)
    private Integer stock;

    @Column(name = "harga",nullable = false)
    private Integer harga;

}
