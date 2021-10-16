package co.g2maruli.userapi.service;

import co.g2maruli.userapi.dto.PenjualanDto;
import co.g2maruli.userapi.entity.ItemPenjualan;
import co.g2maruli.userapi.entity.Penjualan;
import co.g2maruli.userapi.repository.ItemPenjualanRepository;
import co.g2maruli.userapi.repository.PenjualanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
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

    public void catatPenjualan(List <ItemPenjualan> item){

        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        Penjualan penjualan = new Penjualan();

        ItemPenjualan itemPenjualan = new ItemPenjualan();
        for(int i=0; i<item.size(); i++){
            itemPenjualan.setNama(item.get(i).getNama());
            itemPenjualan.setHarga(item.get(i).getHarga());
            itemPenjualan.setPenjualan(penjualan);
            itemPenjualan.setQuantity(item.get(i).getQuantity());
        }

    }

    public void updatePenjualan(Integer id,Penjualan penjualanDto) {
        Penjualan penjualan = penjualanRepository.findById(id).get();
        penjualanRepository.save(penjualanDto);
    }

}