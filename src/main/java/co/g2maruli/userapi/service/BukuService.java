package co.g2maruli.userapi.service;

import co.g2maruli.userapi.entity.Buku;
import co.g2maruli.userapi.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public void registerBuku(Buku bukuDto){
        Buku buku = new Buku();
        buku.setJudul(bukuDto.getJudul());
        buku.setPenerbit(bukuDto.getPenerbit());
        buku.setStock(bukuDto.getStock());
        bukuRepository.save(buku);
    }

}
