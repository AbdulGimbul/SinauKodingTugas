package com.example.Perpustakaan.controller;

import com.example.Perpustakaan.entity.Anggota;
import com.example.Perpustakaan.entity.Buku;
import com.example.Perpustakaan.service.PerpustakaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/buku")
public class BukuController {

    @Autowired
    PerpustakaanService service;

    @PostMapping
    public Buku saveAnggota(@RequestBody Buku param) { return service.save(param); }

    @GetMapping
    public List<Buku> findAll(){
        return service.lihatDataBuku();
    }

    @GetMapping(value = "/find-by-judul")
    public List<Buku> findByJudul(@RequestParam(value = "judul") String judul){
        return service.findByJudul(judul);
    }

    @GetMapping(value = "/find-by-penulis")
    public List<Buku> findByPenulis(@RequestParam(value = "penulis") String penulis){
        return service.findByPenulis(penulis);
    }

    @GetMapping(value = "{id}")
    public Buku findById(@PathVariable int id) { return service.findBukuById(id); }

    @PutMapping(value = "{id}")
    public Buku updateData(@RequestBody Buku param, @PathVariable int id){
        return service.updateDataBuku(param, id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteData(@PathVariable int id){
        if (service.deleteDataBuku(id)){
            return "Data buku berhasil dihapus";
        } else {
            return "Data buku gagal dihapus";
        }
    }
}
