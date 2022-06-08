package com.example.Perpustakaan.service;

import com.example.Perpustakaan.entity.Anggota;
import com.example.Perpustakaan.entity.Buku;
import com.example.Perpustakaan.repository.AnggotaRepository;
import com.example.Perpustakaan.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PerpustakaanService {

    @Autowired
    AnggotaRepository anggotaRepository;
    @Autowired
    BukuRepository bukuRepository;

    public Anggota save(Anggota param) {
        return anggotaRepository.save(param); }

    public Buku save(Buku param) { return bukuRepository.save(param); }

    public List<Anggota> lihatDataAnggota() { return anggotaRepository.findAll(); }
    public List<Buku> lihatDataBuku() { return bukuRepository.findAll(); }

    public List<Anggota> findByName(String param) { return anggotaRepository.findByNamaContaining(param); }
    public List<Buku> findByJudul(String param) { return bukuRepository.findByJudulContaining(param); }
    public List<Buku> findByPenulis(String param) { return bukuRepository.findByPenulisContaining(param); }

    public Anggota findAnggotaById(Integer id) { return anggotaRepository.findById(id).get(); }
    public Buku findBukuById(Integer id) { return bukuRepository.findById(id).get(); }

    public Anggota updateDataAnggota(Anggota anggota, Integer id){
        Anggota referenceData = anggotaRepository.findById(id).get();
        referenceData.setNama(anggota.getNama() != null ? anggota.getNama() : referenceData.getNama());
        referenceData.setAlamat(anggota.getAlamat() != null ? anggota.getAlamat() : referenceData.getAlamat());
        referenceData.setJk(anggota.getJk() != null ? anggota.getJk() : referenceData.getJk());
        referenceData.setTglLahir(anggota.getTglLahir() != null ? anggota.getTglLahir() : referenceData.getTglLahir());
        referenceData.setNoTelepon(anggota.getNoTelepon() != null ? anggota.getNoTelepon() : referenceData.getNoTelepon());

        return anggotaRepository.save(referenceData);
    }

    public Buku updateDataBuku(Buku buku, Integer id){
        Buku referenceData = bukuRepository.findById(id).get();
        referenceData.setJudul(buku.getJudul() != null ? buku.getJudul() : referenceData.getJudul());
        referenceData.setPenulis(buku.getPenulis() != null ? buku.getPenulis() : referenceData.getPenulis());
        referenceData.setPenerbit(buku.getPenerbit() != null ? buku.getPenerbit() : referenceData.getPenerbit());
        referenceData.setTahunTerbit(buku.getTahunTerbit() != null ? buku.getTahunTerbit() : referenceData.getTahunTerbit());
        referenceData.setJenisBuku(buku.getJenisBuku() != null ? buku.getJenisBuku() : referenceData.getJenisBuku());

        return bukuRepository.save(referenceData);
    }

    public boolean deleteDataAnggota(int id){
        Anggota reference = anggotaRepository.findById(id).orElse(new Anggota());
        anggotaRepository.delete(reference);

        reference = anggotaRepository.findById(id).orElse(null);

        if (reference == null)
            return true;

        return false;
    }

    public boolean deleteDataBuku(int id){
        Buku reference = bukuRepository.findById(id).orElse(new Buku());
        bukuRepository.delete(reference);

        reference = bukuRepository.findById(id).orElse(null);

        if (reference == null)
            return true;

        return false;
    }

}
