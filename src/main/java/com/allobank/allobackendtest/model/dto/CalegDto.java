package com.allobank.allobackendtest.model.dto;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.JenisKelamin;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CalegDto {
    private UUID id;
    private DapilDto dapil;
    private PartaiDto partai;
    private Integer nomorUrut;
    private String nama;
    private JenisKelamin jenisKelamin;

    public static CalegDto fromCaleg(Caleg caleg) {
        return CalegDto.builder()
                .id(caleg.getId())
                .dapil(DapilDto.fromDapil(caleg.getDapil()))
                .partai(PartaiDto.fromPartai(caleg.getPartai()))
                .nomorUrut(caleg.getNomorUrut())
                .nama(caleg.getNama())
                .jenisKelamin(caleg.getJenisKelamin())
                .build();
    }
}
