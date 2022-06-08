package com.example.Perpustakaan.controller;


import com.example.Perpustakaan.entity.Anggota;
import com.example.Perpustakaan.service.PerpustakaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/anggota")
public class AnggotaController {

    @Autowired
    PerpustakaanService service;

    @PostMapping
    public Anggota saveAnggota(@RequestBody Anggota param) { return service.save(param); }

    @GetMapping
    public List<Anggota> findAll(){
        return service.lihatDataAnggota();
    }

    @GetMapping(value = "/find-by-name")
    public List<Anggota> findByName(@RequestParam(value = "name") String name){
        return service.findByName(name);
    }

    @GetMapping(value = "{id}")
    public Anggota findById(@PathVariable int id) { return service.findAnggotaById(id); }

    @PutMapping(value = "{id}")
    public Anggota updateData(@RequestBody Anggota param, @PathVariable int id){
        return service.updateDataAnggota(param, id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteData(@PathVariable int id){
        if (service.deleteDataAnggota(id)){
            return "Data anggota berhasil dihapus";
        } else {
            return "Data anggota gagal dihapus";
        }
    }
}
