package com.doku.wallet.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "Configuration")
@ToString
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key")
    private Integer key;

    @Column(name = "value")
    private String value;

}
