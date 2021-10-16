package co.g2maruli.userapi.controller;


import co.g2maruli.userapi.dto.StockDto;
import co.g2maruli.userapi.entity.Buku;
import co.g2maruli.userapi.dto.BasicResponse;
import co.g2maruli.userapi.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BukuController {

    @Autowired
    BukuService bukuService;

    BasicResponse basicResponse = new BasicResponse();

    @GetMapping("/list-buku")
    public ResponseEntity <List<Buku>> showAllBuku(){
        List<Buku> bukuList = bukuService.findAll();
        return ResponseEntity.ok(bukuList);

    }

    @PostMapping("/buku")
    public ResponseEntity<BasicResponse> registerBuku(@RequestBody Buku buku){
        bukuService.registerBuku(buku);
        basicResponse.setStatus("Buku Didaftarkan");
        return ResponseEntity.ok(basicResponse);
    }

    @PutMapping("/buku/{id}")
    public ResponseEntity<BasicResponse> updateBuku(@PathVariable (name="id") Integer id,@RequestBody Buku bukuDto){

        bukuService.updateBuku(bukuDto,id);
        basicResponse.setStatus("Buku Di-update");
        return ResponseEntity.ok(basicResponse);
    }

    @PutMapping("/buku/stock/{id}")
    public ResponseEntity<BasicResponse> updateStock(@PathVariable (name="id") Integer id, @RequestBody StockDto stockDto){

        bukuService.updateStock(id,stockDto.getStock());
        basicResponse.setStatus("Buku Di-update");
        return ResponseEntity.ok(basicResponse);
    }

    @DeleteMapping("/buku/{id}")
    public ResponseEntity<BasicResponse> deleteBuku(@PathVariable (name="id") Integer id){
        bukuService.deleteById(id);
        basicResponse.setStatus("Buku Dihapus");
        return ResponseEntity.ok(basicResponse);

    }

}
