package com.example.Perpustakaan.controller;

import com.example.Perpustakaan.entity.Anggota;
import com.example.Perpustakaan.entity.Pinjam;
import com.example.Perpustakaan.service.PerpustakaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pinjam")
public class PinjamController {
    @Autowired
    PerpustakaanService service;

    @PostMapping
    public Pinjam savePinjam(@RequestBody Pinjam param) { return service.save(param); }

    @GetMapping
    public List<Pinjam> findAll(){
        return service.lihatDataPinjam();
    }

    @GetMapping(value = "{id}")
    public Pinjam findById(@PathVariable int id) { return service.findPinjamById(id); }

    @PutMapping(value = "{id}")
    public Pinjam updateData(@RequestBody Pinjam param, @PathVariable int id){
        return service.updateDataPinjam(param, id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteData(@PathVariable int id){
        if (service.deleteDataPinjam(id)){
            return "Data anggota berhasil dihapus";
        } else {
            return "Data anggota gagal dihapus";
        }
    }

}
