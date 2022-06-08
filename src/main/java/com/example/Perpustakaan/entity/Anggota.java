package com.example.Perpustakaan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "anggota")
@Setter
@Getter
public class Anggota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anggota")
    private Integer idAnggota;

    @Column(name = "nama")
    private String nama;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "no_telepon")
    private String noTelepon;

    @Column(name = "tgl_lahir", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tglLahir;

    @Column(name = "jenis_kelamin")
    private String jk;
}
