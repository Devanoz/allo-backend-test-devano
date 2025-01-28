package com.allobank.allobackendtest.caleg.repository;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.repository.CalegRepository;
import com.allobank.allobackendtest.repository.DapilRepository;
import com.allobank.allobackendtest.repository.PartaiRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class CalegRepositoryTest {
    @Autowired
    private CalegRepository calegRepository;
    @Autowired
    private DapilRepository dapilRepository;
    @Autowired
    private PartaiRepository partaiRepository;

    @Test
    @DisplayName("Find all calegs pageable should return list of the given size and page")
    public void findAllCalegsPageable() {
        Dapil dapil1 = Dapil.builder().namaDapil("Dapil 1").wilayahDapilList(List.of("Wilayah 1", "Wilayah 2")).build();
        Dapil savedDapil1 = dapilRepository.saveAndFlush(dapil1);
        List<Caleg> savedCalegs = calegRepository.saveAll(List.of(
                Caleg.builder().nama("Caleg 1").dapil(savedDapil1).build(),
                Caleg.builder().nama("Caleg 2").dapil(savedDapil1).build(),
                Caleg.builder().nama("Caleg 3").dapil(savedDapil1).build(),
                Caleg.builder().nama("Caleg 4").dapil(savedDapil1).build(),
                Caleg.builder().nama("Caleg 5").dapil(savedDapil1).build()
        ));
        savedCalegs.forEach(caleg -> assertThat(caleg.getDapil().getWilayahDapilList().size()).isEqualTo(2));

        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<Caleg> calegs = calegRepository.findAllCalegsPageable(pageRequest);
        assertThat(calegs.getContent()).hasSize(2);
        assertThat(calegs.getTotalElements()).isEqualTo(5);
        pageRequest = PageRequest.of(1, 2);
        Page<Caleg> calegs2 = calegRepository.findAllCalegsPageable(pageRequest);
        assertThat(calegs2.getContent()).hasSize(2);
        assertThat(calegs2.getTotalElements()).isEqualTo(5);
    }

    @Test
    @DisplayName("Find all calegs by partai id pageable should return list of the given size and page with the given partai id")
    public void findAllCalegsByPartaiId() {
        Partai partai1 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 1").nomorUrut(1).build());
        Partai partai3 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 3").build());
        Partai partai4 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 4").build());
        Partai partai5 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 5").build());

        List<Caleg> savedCalegs = calegRepository.saveAll(List.of(
                Caleg.builder().nama("Caleg 1").partai(partai1).build(),
                Caleg.builder().nama("Caleg 2").partai(partai1).build(),
                Caleg.builder().nama("Caleg 3").partai(partai3).build(),
                Caleg.builder().nama("Caleg 4").partai(partai4).build(),
                Caleg.builder().nama("Caleg 5").partai(partai5).build()
        ));

        PageRequest pageRequest = PageRequest.of(0, 5);
        UUID partaiId = savedCalegs.get(0).getPartai().getId();
        Page<Caleg> allCalegsByPartaiId = calegRepository.findAllCalegsByPartaiId(partaiId, pageRequest);
        assertThat(allCalegsByPartaiId.getContent()).hasSize(2);
        assertThat(allCalegsByPartaiId.getTotalElements()).isEqualTo(2);
        allCalegsByPartaiId.forEach(caleg -> assertThat(caleg.getPartai().getId()).isEqualTo(partaiId));
    }

    @Test
    @DisplayName("Find all calegs by dapil id pageable should return list of the given size and page with the given dapil id")
    public void findAllCalegsByDapilId() {
        Partai partai1 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 1").nomorUrut(1).build());
        Partai partai3 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 3").build());
        Partai partai4 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 4").build());
        Partai partai5 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 5").build());

        Dapil dapil1 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 1").build());
        Dapil dapil2 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 2").build());

        List<Caleg> savedCalegs = calegRepository.saveAll(List.of(
                Caleg.builder().nama("Caleg 1").partai(partai1).dapil(dapil2).build(),
                Caleg.builder().nama("Caleg 2").partai(partai1).dapil(dapil1).build(),
                Caleg.builder().nama("Caleg 3").partai(partai3).dapil(dapil2).build(),
                Caleg.builder().nama("Caleg 4").partai(partai4).dapil(dapil1).build(),
                Caleg.builder().nama("Caleg 5").partai(partai5).dapil(dapil1).build()
        ));

        PageRequest pageRequest = PageRequest.of(0, 5);
        UUID dapilId = savedCalegs.get(0).getDapil().getId();
        Page<Caleg> allCalegsByDapilId = calegRepository.findAllCalegsByDapilId(dapilId, pageRequest);
        assertThat(allCalegsByDapilId.getContent()).hasSize(2);
        assertThat(allCalegsByDapilId.getTotalElements()).isEqualTo(2);
        allCalegsByDapilId.forEach(caleg -> assertThat(caleg.getDapil().getId()).isEqualTo(dapilId));
    }

    @Test
    @DisplayName("Find all calegs by partai id and dapil id pageable should return list of the given size and page with the given partai id and dapil id")
    public void findAllCalegsByPartaiIdAndDapilId() {
        Partai partai1 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 1").nomorUrut(1).build());
        Partai partai3 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 3").build());
        Partai partai4 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 4").build());
        Partai partai5 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 5").build());

        Dapil dapil1 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 1").build());
        Dapil dapil2 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 2").build());

        calegRepository.saveAll(List.of(
                Caleg.builder().nama("Caleg 2").partai(partai1).dapil(dapil1).nomorUrut(2).build(),
                Caleg.builder().nama("Caleg 1").partai(partai1).dapil(dapil1).nomorUrut(1).build(),
                Caleg.builder().nama("Caleg 3").partai(partai3).dapil(dapil2).nomorUrut(3).build(),
                Caleg.builder().nama("Caleg 4").partai(partai4).dapil(dapil1).nomorUrut(5).build(),
                Caleg.builder().nama("Caleg 5").partai(partai5).dapil(dapil1).nomorUrut(4).build()
        ));

        PageRequest pageRequest = PageRequest.of(0, 5, Sort.by(Sort.Order.asc("nomor_urut")));
        UUID dapilId = dapil1.getId();
        UUID partaiId = partai1.getId();
        Page<Caleg> allCalegsByPartaiIdAndDapilId = calegRepository.findAllCalegsByPartaiIdAndDapilIdPageable(partaiId, dapilId, pageRequest);
        assertThat(allCalegsByPartaiIdAndDapilId.getContent()).hasSize(2);
        assertThat(allCalegsByPartaiIdAndDapilId.getTotalElements()).isEqualTo(2);
        allCalegsByPartaiIdAndDapilId.forEach(caleg -> {
            assertThat(caleg.getDapil().getId()).isEqualTo(dapilId);
            assertThat(caleg.getPartai().getId()).isEqualTo(partaiId);
        });
        //test assert that sorting is actually work as expected
        assertThat(allCalegsByPartaiIdAndDapilId.getContent().get(0).getNomorUrut()).isEqualTo(1);
        assertThat(allCalegsByPartaiIdAndDapilId.getContent().get(1).getNomorUrut()).isEqualTo(2);
    }
}
