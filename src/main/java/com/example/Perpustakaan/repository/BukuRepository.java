package com.example.Perpustakaan.repository;

import com.example.Perpustakaan.entity.Anggota;
import com.example.Perpustakaan.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BukuRepository extends JpaRepository<Buku, Integer> {
    List<Buku> findByJudulContaining(String judul);
    List<Buku> findByPenulisContaining(String penulis);
}
