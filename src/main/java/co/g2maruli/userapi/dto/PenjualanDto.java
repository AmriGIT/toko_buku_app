package co.g2maruli.userapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PenjualanDto {
    private String namaBuku;
    private Integer hargaBuku;
    private Integer quantityBuku;

}
