package com.allobank.allobackendtest.repository;

import com.allobank.allobackendtest.model.Caleg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CalegRepository extends JpaRepository<Caleg, UUID> {

    @Query(value = "SELECT * FROM caleg",
            nativeQuery = true
    )
    Page<Caleg> findAllCalegsPageable(Pageable pageable);

    @Query(value = "SELECT * FROM caleg WHERE partai_id = ?1 AND dapil_id = ?2",
            nativeQuery = true
    )
    Page<Caleg> findAllCalegsByPartaiIdAndDapilIdPageable(UUID partaiId, UUID dapilId, Pageable pageable);

    @Query(value = "SELECT * FROM caleg WHERE partai_id = ?1",
            nativeQuery = true
    )
    Page<Caleg> findAllCalegsByPartaiId(UUID partaiId, Pageable pageable);

    @Query(value = "SELECT * FROM caleg WHERE dapil_id = ?1",
            nativeQuery = true
    )
    Page<Caleg> findAllCalegsByDapilId(UUID dapilId, Pageable pageable);
}
