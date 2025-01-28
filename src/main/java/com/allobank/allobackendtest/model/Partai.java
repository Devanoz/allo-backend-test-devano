package com.allobank.allobackendtest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "partai")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Partai {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "nama_partai")
    private String namaPartai;
    @Column(name = "nomor_urut")
    private Integer nomorUrut;
}
