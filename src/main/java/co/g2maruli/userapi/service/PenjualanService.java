package co.g2maruli.userapi.service;

import co.g2maruli.userapi.entity.Penjualan;
import co.g2maruli.userapi.repository.PenjualanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PenjualanService {

    @Autowired
    PenjualanRepository penjualanRepository;



}
