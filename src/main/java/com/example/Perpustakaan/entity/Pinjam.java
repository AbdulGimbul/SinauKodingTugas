package com.example.Perpustakaan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pinjam")
@Setter
@Getter
public class Pinjam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pinjam")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "tgl_pinjam")
    Date tglPinjam;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "tgl_kembali")
    Date tglKembali;

    @JsonIgnoreProperties(value = {"pinjamList","handle","hibernateLazyInitializer"},
        allowSetters = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_anggota")
    private Anggota anggota;

    @JsonIgnoreProperties(value = {"pinjamList","handler","hibernateLazyInitializer"},
        allowSetters = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_buku")
    private Buku buku;
}
