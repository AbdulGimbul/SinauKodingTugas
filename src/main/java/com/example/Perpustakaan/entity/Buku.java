package com.example.Perpustakaan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "buku")
@Setter
@Getter
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_buku")
    private Integer idBuku;

    @Column(name = "judul")
    private String judul;

    @Column(name = "penulis")
    private String penulis;

    @Column(name = "penerbit")
    private String penerbit;

    @Column(name = "tahun_terbit")
    private String tahunTerbit;

    @Column(name = "jenis_buku")
    private String jenisBuku;

}
