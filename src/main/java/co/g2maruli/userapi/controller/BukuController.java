package co.g2maruli.userapi.controller;


import co.g2maruli.userapi.entity.Buku;
import co.g2maruli.userapi.model.BasicResponse;
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

    @GetMapping("/list-buku")
    public ResponseEntity <List<Buku>> showAllBuku(){
        List<Buku> bukuList = bukuService.findAll();

        return ResponseEntity.ok(bukuList);

    }

    @PostMapping("/buku")
    public ResponseEntity<BasicResponse> registerBuku(@RequestBody Buku buku){
        BasicResponse basicResponse = new BasicResponse();
        bukuService.registerBuku(buku);
        basicResponse.setStatus("Buku Didaftarkan");
        return ResponseEntity.ok(basicResponse);
    }

}
