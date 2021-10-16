package co.g2maruli.userapi.service;

import co.g2maruli.userapi.entity.Buku;
import co.g2maruli.userapi.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BukuService {

    @Autowired
    BukuRepository bukuRepository;

    public List<Buku> findAll(){
        Iterable<Buku> bukuIterable = bukuRepository.findAll();
        List<Buku> bukuList = StreamSupport.stream(bukuIterable.spliterator(), false).collect(Collectors.toList());

        return bukuList;
    }

    public Buku findById(Integer id){
        return bukuRepository.findById(id).get();
    }

    public void deleteById( Integer id){
        bukuRepository.deleteById(id);
    }



    public void registerBuku(Buku bukuDto){
        Buku buku = new Buku();
        buku.setJudul(bukuDto.getJudul());
        buku.setPenerbit(bukuDto.getPenerbit());
        buku.setStock(bukuDto.getStock());
        buku.setHarga(bukuDto.getHarga());
        bukuRepository.save(buku);
    }

    public void updateBuku(Buku bukuDto, Integer id){
        Buku buku = bukuRepository.findById(id).get();
        buku.setJudul(bukuDto.getJudul());
        buku.setPenerbit(bukuDto.getPenerbit());
        buku.setStock(bukuDto.getStock());
        buku.setHarga(bukuDto.getHarga());
        bukuRepository.save(buku);
    }

    public void updateStock(Integer id,Integer stock){
        Buku buku = bukuRepository.findById(id).get();
        buku.setStock(stock);
        bukuRepository.save(buku);
    }



}
