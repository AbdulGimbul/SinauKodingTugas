package com.example.Perpustakaan.entity.mapping;

import com.example.Perpustakaan.entity.Anggota;
import com.example.Perpustakaan.entity.Buku;
import com.example.Perpustakaan.entity.dto.AnggotaDTO;
import com.example.Perpustakaan.entity.dto.BukuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PerpustakaanMapping {
    PerpustakaanMapping INSTANCE_ANGGOTA = Mappers.getMapper(PerpustakaanMapping.class);

    PerpustakaanMapping INSTANCE_BUKU = Mappers.getMapper(PerpustakaanMapping.class);

    Anggota toEntity(AnggotaDTO dto);

    Buku toEntity(BukuDTO dto);

    AnggotaDTO toDto(Anggota anggota);

    BukuDTO toDto(Buku buku);

    List<Anggota> toAnggotaList(List<AnggotaDTO> data);

    List<Buku> toBukuList(List<BukuDTO> data);

    List<AnggotaDTO> toAnggotaDTOList(List<Anggota> data);

    List<BukuDTO> toBukuDTOList(List<Buku> data);
}
