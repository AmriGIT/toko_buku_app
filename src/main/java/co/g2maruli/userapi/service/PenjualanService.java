package co.g2maruli.userapi.service;

import co.g2maruli.userapi.dto.PenjualanDto;
import co.g2maruli.userapi.entity.Buku;
import co.g2maruli.userapi.entity.ItemPenjualan;
import co.g2maruli.userapi.entity.Penjualan;
import co.g2maruli.userapi.repository.BukuRepository;
import co.g2maruli.userapi.repository.ItemPenjualanRepository;
import co.g2maruli.userapi.repository.PenjualanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PenjualanService {

    @Autowired
    PenjualanRepository penjualanRepository;

    @Autowired
    ItemPenjualanRepository itemPenjualanRepository;

    @Autowired
    BukuRepository bukuRepository;


    public List<Penjualan> showPenjualan(){
        Iterable<Penjualan> penjualanIterable = penjualanRepository.findAll();
        List<Penjualan> penjualanList = StreamSupport.stream(penjualanIterable.spliterator(), false).collect(Collectors.toList());
        return penjualanList;
    }

    public Penjualan findPenjualanById(Integer id){
        return penjualanRepository.findById(id).get();
    }

    public void deletePenjualanById(Integer id){
        penjualanRepository.delete(penjualanRepository.findById(id).get());
    }

    public Penjualan catatPenjualan(List <PenjualanDto> item){

        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        Penjualan penjualan = new Penjualan();
        penjualan.setDate(date);
        penjualan.setNamaCustomer(item.get(0).getNamaPembeli());

        List<Integer> harga = new ArrayList<>();
        List<ItemPenjualan> ip = new ArrayList<>();
        Buku buku;
        ItemPenjualan itemPenjualan = new ItemPenjualan();
        for(int i=0; i<item.size(); i++){

            buku = bukuRepository.getBukuByJudul(item.get(i).getJudul());
            itemPenjualan.setBuku(buku);
            itemPenjualan.setNamaPembeli(item.get(i).getNamaPembeli());
            itemPenjualan.setHarga(buku.getHarga());
            itemPenjualan.setQuantity(item.get(i).getQuantity());
            itemPenjualan.setTotalHarga(buku.getHarga()*item.get(i).getQuantity());
            buku.setStock(buku.getStock()-item.get(i).getQuantity());
            harga.add(buku.getHarga());
            ip.add(itemPenjualan);
            bukuRepository.save(buku);
        }
        for( ItemPenjualan ips : ip){
            itemPenjualanRepository.save(ips);
        }

        Integer sum = harga.stream().collect(Collectors.summingInt(Integer::intValue));
        penjualan.setTotalBelanjaan(sum);

        penjualanRepository.save(penjualan);

        return penjualan;
    }
}
