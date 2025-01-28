package com.allobank.allobackendtest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "dapil")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dapil {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "nama_dapil")
    private String namaDapil;
    @Column(name = "provinsi")
    private String provinsi;
    @ElementCollection
    @CollectionTable(name = "wilayah_dapil", joinColumns = @JoinColumn(name = "dapil_id"))
    @Column(name = "nama_wilayah")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<String> wilayahDapilList;
    @Column(name = "jumlah_kursi")
    private int jumlahKursi;
}
