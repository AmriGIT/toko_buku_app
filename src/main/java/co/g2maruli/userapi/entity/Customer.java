package co.g2maruli.userapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "t_customer")
    private Long phoneNumber;

}
