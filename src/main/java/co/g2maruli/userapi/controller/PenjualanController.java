package co.g2maruli.userapi.controller;

import co.g2maruli.userapi.dto.BasicResponse;
import co.g2maruli.userapi.dto.PenjualanDto;
import co.g2maruli.userapi.entity.ItemPenjualan;
import co.g2maruli.userapi.entity.Penjualan;
import co.g2maruli.userapi.service.PenjualanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PenjualanController {

    @Autowired
    PenjualanService penjualanService;


    BasicResponse basicResponse = new BasicResponse();

    @GetMapping("/penjualans")
    public ResponseEntity<List<Penjualan>> showAllPenjualan(){
     return ResponseEntity.ok(penjualanService.showPenjualan());
    }

    @GetMapping("/penjualan")
    public ResponseEntity<Penjualan> showPenjualanById(Integer id){
        return ResponseEntity.ok(penjualanService.findPenjualanById(id));
    }

    @PostMapping("/penjualan")
    public ResponseEntity<Penjualan> createPenjualan(@RequestBody List<PenjualanDto> itemPenjualans){
        Penjualan penjualan = penjualanService.catatPenjualan(itemPenjualans);
        return ResponseEntity.ok(penjualan);
    }

}
