package com.example.Perpustakaan.repository;

import com.example.Perpustakaan.entity.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnggotaRepository extends JpaRepository<Anggota, Integer> {
    List<Anggota> findByNamaContaining(String nama);
}
