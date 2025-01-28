package com.allobank.allobackendtest.model.dto;

import com.allobank.allobackendtest.model.Partai;
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
public class PartaiDto {
    private UUID id;
    private String namaPartai;
    private Integer nomorUrut;

    public static PartaiDto fromPartai(Partai partai) {
        return PartaiDto.builder()
                .id(partai.getId())
                .namaPartai(partai.getNamaPartai())
                .nomorUrut(partai.getNomorUrut())
                .build();
    }
}
