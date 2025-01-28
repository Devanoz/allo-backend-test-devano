package com.allobank.allobackendtest.caleg.service;

import com.allobank.allobackendtest.common.errors.ResourceNotFoundException;
import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.model.dto.CalegDto;
import com.allobank.allobackendtest.repository.CalegRepository;
import com.allobank.allobackendtest.service.CalegService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CalegServiceTest {

    @Autowired
    private CalegService calegService;

    @MockBean
    private CalegRepository calegRepository;

    @Test
    @DisplayName("Test find caleg by id should return caleg with the given id")
    public void testFindCalegById() {
        UUID id = UUID.randomUUID();
        when(calegRepository.findById(id)).thenReturn(
                Optional.of(Caleg.builder()
                        .id(id)
                        .nama("Caleg 1")
                        .partai(Partai.builder().id(UUID.randomUUID()).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                        .dapil(Dapil.builder().id(UUID.randomUUID()).namaDapil("Dapil 1").build())
                        .build())
        );
        CalegDto calegDto = calegService.findCalegById(id);
        verify(calegRepository, times(1)).findById(id);
        assertNotNull(calegDto);
        assertEquals(id, calegDto.getId());
    }

    @Test
    @DisplayName("Test find caleg by id, given non existing id, should throw ResourceNotFoundException")
    public void testFindCalegByIdNonExistingId() {
        UUID id = UUID.randomUUID();
        when(calegRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            calegService.findCalegById(id);
            verify(calegRepository, times(1)).findById(id);
        });

    }

    @Test
    @DisplayName("Test find all calegs pageable (sort by nomor_urut ASC) should return list of calegs")
    public void testFindAllCalegsPageable() {
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "nomor_urut"));
        when(calegRepository.findAllCalegsPageable(pageRequest)).thenReturn(
                new PageImpl<>(List.of(
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 1")
                                .partai(Partai.builder().id(UUID.randomUUID()).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(UUID.randomUUID()).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 2")
                                .partai(Partai.builder().id(UUID.randomUUID()).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(UUID.randomUUID()).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 3")
                                .partai(Partai.builder().id(UUID.randomUUID()).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(UUID.randomUUID()).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 4")
                                .partai(Partai.builder().id(UUID.randomUUID()).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(UUID.randomUUID()).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 5")
                                .partai(Partai.builder().id(UUID.randomUUID()).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(UUID.randomUUID()).namaDapil("Dapil 1").build())
                                .build()
                ))
        );

        List<CalegDto> calegs = calegService.findAllCalegsPageable(0, 5, Sort.by(Sort.Direction.ASC, "nomor_urut"));
        verify(calegRepository, times(1)).findAllCalegsPageable(pageRequest);
        assertEquals(5, calegs.size());
    }

    @Test
    @DisplayName("Test find all calegs by partai id pageable (sort by nomor_urut ASC) should return list of calegs with the given partai id")
    public void testFindAllByPartaiIdPageable() {
        UUID partaiId = UUID.randomUUID();
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "nomor_urut"));
        when(calegRepository.findAllCalegsByPartaiId(partaiId, pageRequest)).thenReturn(
                new PageImpl<>(List.of(
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 1")
                                .partai(Partai.builder().id(partaiId).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(UUID.randomUUID()).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 2")
                                .partai(Partai.builder().id(partaiId).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(UUID.randomUUID()).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 3")
                                .partai(Partai.builder().id(partaiId).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(UUID.randomUUID()).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 4")
                                .partai(Partai.builder().id(partaiId).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(UUID.randomUUID()).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 5")
                                .partai(Partai.builder().id(partaiId).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(UUID.randomUUID()).namaDapil("Dapil 1").build())
                                .build()
                ))
        );
        List<CalegDto> calegs = calegService.findAllByPartaiIdPageable(partaiId, 0, 5, Sort.by(Sort.Direction.ASC, "nomor_urut"));
        verify(calegRepository, times(1)).findAllCalegsByPartaiId(partaiId, pageRequest);
        assertEquals(5, calegs.size());
        calegs.forEach(caleg -> {
            assertEquals(partaiId, caleg.getPartai().getId());
        });
    }

    @Test
    @DisplayName("Test find all calegs by dapil id pageable (sort by nomor_urut ASC) should return list of calegs with the given dapil id")
    public void testFindAllByDapilId() {
        UUID dapilId = UUID.randomUUID();
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "nomor_urut"));
        when(calegRepository.findAllCalegsByDapilId(dapilId, pageRequest)).thenReturn(
                new PageImpl<>(List.of(
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 1")
                                .partai(Partai.builder().id(UUID.randomUUID()).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(dapilId).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 2")
                                .partai(Partai.builder().id(UUID.randomUUID()).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(dapilId).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 3")
                                .partai(Partai.builder().id(UUID.randomUUID()).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(dapilId).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 4")
                                .partai(Partai.builder().id(UUID.randomUUID()).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(dapilId).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 5")
                                .partai(Partai.builder().id(UUID.randomUUID()).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(dapilId).namaDapil("Dapil 1").build())
                                .build()
                ))
        );
        List<CalegDto> calegs = calegService.findAllByDapilId(dapilId, 0, 5, Sort.by(Sort.Direction.ASC, "nomor_urut"));
        verify(calegRepository, times(1)).findAllCalegsByDapilId(dapilId, pageRequest);
        assertEquals(5, calegs.size());
        calegs.forEach(caleg -> {
            assertEquals(dapilId, caleg.getDapil().getId());
        });
    }

    @Test
    @DisplayName("Test find all calegs by partai id and dapil id pageable (sort by nomor_urut ASC) should return list of calegs with the given partai id and dapil id")
    public void testFindAllByPartaiIdAndDapilIdPageable() {
        UUID partaiId = UUID.randomUUID();
        UUID dapilId = UUID.randomUUID();
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "nomor_urut"));
        when(calegRepository.findAllCalegsByPartaiIdAndDapilIdPageable(partaiId, dapilId, pageRequest)).thenReturn(
                new PageImpl<>(List.of(
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 1")
                                .partai(Partai.builder().id(partaiId).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(dapilId).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 2")
                                .partai(Partai.builder().id(partaiId).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(dapilId).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 3")
                                .partai(Partai.builder().id(partaiId).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(dapilId).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 4")
                                .partai(Partai.builder().id(partaiId).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(dapilId).namaDapil("Dapil 1").build())
                                .build(),
                        Caleg.builder()
                                .id(UUID.randomUUID())
                                .nama("Caleg 5")
                                .partai(Partai.builder().id(partaiId).namaPartai("PDI Perjuangan").nomorUrut(1).build())
                                .dapil(Dapil.builder().id(dapilId).namaDapil("Dapil 1").build())
                                .build()
                ))
        );
        List<CalegDto> calegs = calegService.findAllByPartaiIdAndDapilIdPageable(partaiId, dapilId, 0, 5, Sort.by(Sort.Direction.ASC, "nomor_urut"));
        verify(calegRepository, times(1)).findAllCalegsByPartaiIdAndDapilIdPageable(partaiId, dapilId, pageRequest);
        assertEquals(5, calegs.size());
        calegs.forEach(caleg -> {
            assertEquals(partaiId, caleg.getPartai().getId());
            assertEquals(dapilId, caleg.getDapil().getId());
        });
    }
}
