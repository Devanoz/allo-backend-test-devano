package com.allobank.allobackendtest.model.dto;

import com.allobank.allobackendtest.model.Dapil;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DapilDto {
    private UUID id;
    private String namaDapil;
    private String provinsi;
    private List<String> wilayahDapilList;
    private int jumlahKursi;

    public static DapilDto fromDapil(Dapil dapil) {
        return DapilDto.builder()
                .id(dapil.getId())
                .namaDapil(dapil.getNamaDapil())
                .provinsi(dapil.getProvinsi())
                .wilayahDapilList(dapil.getWilayahDapilList())
                .jumlahKursi(dapil.getJumlahKursi())
                .build();
    }
}
