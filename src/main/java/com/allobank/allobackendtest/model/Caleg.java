package com.allobank.allobackendtest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "caleg")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Caleg {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "dapil_id")
    private Dapil dapil;
    @ManyToOne
    @JoinColumn(name = "partai_id")
    private Partai partai;
    @Column(name = "nomor_urut")
    private Integer nomorUrut;
    @Column(name = "nama")
    private String nama;
    @Column(name = "jenis_kelamin")
    @Enumerated(EnumType.STRING)
    private JenisKelamin jenisKelamin;
}
