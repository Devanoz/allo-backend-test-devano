package com.allobank.allobackendtest.caleg.controller;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.model.dto.CalegDto;
import com.allobank.allobackendtest.model.errors.GenericResponse;
import com.allobank.allobackendtest.repository.CalegRepository;
import com.allobank.allobackendtest.repository.DapilRepository;
import com.allobank.allobackendtest.repository.PartaiRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Transactional
public class CalegIntegrationTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    private CalegRepository calegRepository;
    @Autowired
    private DapilRepository dapilRepository;
    @Autowired
    private PartaiRepository partaiRepository;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @DisplayName("Find caleg by id should return caleg with the given id")
    public void findCalegById() throws Exception {
        Dapil dapil1 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 1").wilayahDapilList(List.of("Wilayah 1", "Wilayah 2")).build());
        Partai partai1 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 1").build());
        Caleg caleg1 = calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 1").dapil(dapil1).partai(partai1).build());
        UUID caleg1Id = caleg1.getId();
        mockMvc.perform(get("/calegs/{id}", caleg1Id)).andExpect(status().isOk())
                .andExpect(result -> {
                    String contentAsString = result.getResponse().getContentAsString();
                    GenericResponse<CalegDto> response = new ObjectMapper().readValue(contentAsString, new TypeReference<>() {
                    });
                    assertTrue(response.isSuccess());
                    assertEquals("SUCCESS!", response.getMessage());
                    assertThat(response.getData().getNama()).isEqualTo("Caleg 1");
                });
    }

    @Test
    @DisplayName("Find caleg by id given non existent id should return 404")
    public void findCalegByIdGivenNonExistentId() throws Exception {
        Dapil dapil1 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 1").wilayahDapilList(List.of("Wilayah 1", "Wilayah 2")).build());
        Partai partai1 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 1").build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 1").dapil(dapil1).partai(partai1).build());

        mockMvc.perform(get("/calegs/{id}", UUID.randomUUID())).andExpect(status().isNotFound())
                .andExpect(result -> {
                    String contentAsString = result.getResponse().getContentAsString();
                    GenericResponse<Object> response = new ObjectMapper().readValue(contentAsString, new TypeReference<>() {
                    });
                    assertFalse(response.isSuccess());
                });
    }

    @Test
    @DisplayName("Find all calegs should return list of calegs")
    public void findAllCalegs() throws Exception {
        Dapil dapil1 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 1").wilayahDapilList(List.of("Wilayah 1", "Wilayah 2")).build());
        Partai partai1 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 1").build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 1").dapil(dapil1).partai(partai1).build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 2").dapil(dapil1).partai(partai1).build());

        mockMvc.perform(get("/calegs")).andExpect(status().isOk())
                .andExpect(result -> {
                    String contentAsString = result.getResponse().getContentAsString();
                    GenericResponse<List<CalegDto>> response = new ObjectMapper().readValue(contentAsString, new TypeReference<>() {
                    });
                    assertTrue(response.isSuccess());
                    assertEquals("SUCCESS!", response.getMessage());
                    assertThat(response.getData()).hasSize(2);
                });
    }

    @Test
    @DisplayName("Find all calegs given partai id should return list of calegs with the given partai id")
    public void findAllCalegsGivenPartaiId() throws Exception {
        Dapil dapil1 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 1").wilayahDapilList(List.of("Wilayah 1", "Wilayah 2")).build());
        Partai partai1 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 1").build());
        Partai partai2 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 2").build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 1").dapil(dapil1).partai(partai1).build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 2").dapil(dapil1).partai(partai2).build());

        mockMvc.perform(get("/calegs?partai={partaiId}", partai1.getId())).andExpect(status().isOk())
                .andExpect(result -> {
                    String contentAsString = result.getResponse().getContentAsString();
                    GenericResponse<List<CalegDto>> response = new ObjectMapper().readValue(contentAsString, new TypeReference<>() {
                    });
                    assertTrue(response.isSuccess());
                    assertEquals("SUCCESS!", response.getMessage());
                    assertThat(response.getData()).hasSize(1);
                    response.getData().forEach(calegDto -> assertThat(calegDto.getPartai().getId()).isEqualTo(partai1.getId()));
                });
    }

    @Test
    @DisplayName("Find all calegs given dapil id should return list of calegs with the given dapil id")
    public void findAllCalegsGivenDapilId() throws Exception {
        Dapil dapil1 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 1").wilayahDapilList(List.of("Wilayah 1", "Wilayah 2")).build());
        Dapil dapil2 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 2").wilayahDapilList(List.of("Wilayah 3", "Wilayah 4")).build());
        Partai partai1 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 1").build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 1").dapil(dapil1).partai(partai1).build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 2").dapil(dapil2).partai(partai1).build());

        mockMvc.perform(get("/calegs?dapil={dapilId}", dapil1.getId())).andExpect(status().isOk())
                .andExpect(result -> {
                    String contentAsString = result.getResponse().getContentAsString();
                    GenericResponse<List<CalegDto>> response = new ObjectMapper().readValue(contentAsString, new TypeReference<>() {
                    });
                    assertTrue(response.isSuccess());
                    assertEquals("SUCCESS!", response.getMessage());
                    assertThat(response.getData()).hasSize(1);
                    response.getData().forEach(calegDto -> assertThat(calegDto.getDapil().getId()).isEqualTo(dapil1.getId()));
                });
    }

    @Test
    @DisplayName("Find all calegs given partai id and dapil id should return list of calegs with the given partai id and dapil id")
    public void findAllCalegsGivenPartaiIdAndDapilId() throws Exception {
        Dapil dapil1 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 1").wilayahDapilList(List.of("Wilayah 1", "Wilayah 2")).build());
        Dapil dapil2 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 2").wilayahDapilList(List.of("Wilayah 3", "Wilayah 4")).build());
        Partai partai1 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 1").build());
        Partai partai2 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 2").build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 1").dapil(dapil1).partai(partai1).build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 2").dapil(dapil2).partai(partai1).build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 3").dapil(dapil1).partai(partai2).build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 4").dapil(dapil1).partai(partai1).build());

        mockMvc.perform(get("/calegs?partai={partaiId}&dapil={dapilId}", partai1.getId(), dapil1.getId())).andExpect(status().isOk())
                .andExpect(result -> {
                    String contentAsString = result.getResponse().getContentAsString();
                    GenericResponse<List<CalegDto>> response = new ObjectMapper().readValue(contentAsString, new TypeReference<>() {
                    });
                    assertTrue(response.isSuccess());
                    assertEquals("SUCCESS!", response.getMessage());
                    assertThat(response.getData()).hasSize(2);
                    response.getData().forEach(calegDto -> {
                        assertThat(calegDto.getPartai().getId()).isEqualTo(partai1.getId());
                        assertThat(calegDto.getDapil().getId()).isEqualTo(dapil1.getId());
                    });
                });
    }

    @Test
    @DisplayName("Find all calegs given partai id and dapil id sorted by nomor_urut should return list of calegs with the given partai id and dapil id with correct sorting")
    public void findAllCalegsGivenPartaiIdAndDapilIdSortedByNomorUrut() throws Exception {
        Dapil dapil1 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 1").wilayahDapilList(List.of("Wilayah 1", "Wilayah 2")).build());
        Dapil dapil2 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 2").wilayahDapilList(List.of("Wilayah 3", "Wilayah 4")).build());
        Partai partai1 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 1").build());
        Partai partai2 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 2").build());

        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 2").nomorUrut(1).dapil(dapil2).partai(partai1).build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 3").nomorUrut(3).dapil(dapil1).partai(partai2).build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 4").nomorUrut(4).dapil(dapil1).partai(partai1).build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 1").nomorUrut(2).dapil(dapil1).partai(partai1).build());

        mockMvc.perform(get("/calegs?partai={partaiId}&dapil={dapilId}&sort=nomor_urut,asc", partai1.getId(), dapil1.getId())).andExpect(status().isOk())
                .andExpect(result -> {
                    String contentAsString = result.getResponse().getContentAsString();
                    GenericResponse<List<CalegDto>> response = new ObjectMapper().readValue(contentAsString, new TypeReference<>() {
                    });
                    assertTrue(response.isSuccess());
                    assertEquals("SUCCESS!", response.getMessage());
                    assertThat(response.getData()).hasSize(2);
                    assertThat(response.getData().get(0).getNomorUrut()).isEqualTo(2);
                    assertThat(response.getData().get(1).getNomorUrut()).isEqualTo(4);
                });
    }

    @Test
    @DisplayName("Find all calegs given partai id and dapil id sorted by nomor_urut descending should return list of calegs with the given partai id and dapil id with correct sorting")
    public void findAllCalegsGivenPartaiIdAndDapilIdSortedByNomorUrutDescending() throws Exception {
        Dapil dapil1 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 1").wilayahDapilList(List.of("Wilayah 1", "Wilayah 2")).build());
        Dapil dapil2 = dapilRepository.saveAndFlush(Dapil.builder().namaDapil("Dapil 2").wilayahDapilList(List.of("Wilayah 3", "Wilayah 4")).build());
        Partai partai1 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 1").build());
        Partai partai2 = partaiRepository.saveAndFlush(Partai.builder().namaPartai("Partai 2").build());

        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 2").nomorUrut(1).dapil(dapil2).partai(partai1).build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 3").nomorUrut(3).dapil(dapil1).partai(partai2).build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 4").nomorUrut(4).dapil(dapil1).partai(partai1).build());
        calegRepository.saveAndFlush(Caleg.builder().nama("Caleg 1").nomorUrut(2).dapil(dapil1).partai(partai1).build());

        mockMvc.perform(get("/calegs?partai={partaiId}&dapil={dapilId}&sort=nomor_urut,desc", partai1.getId(), dapil1.getId())).andExpect(status().isOk())
                .andExpect(result -> {
                    String contentAsString = result.getResponse().getContentAsString();
                    GenericResponse<List<CalegDto>> response = new ObjectMapper().readValue(contentAsString, new TypeReference<>() {
                    });
                    assertTrue(response.isSuccess());
                    assertEquals("SUCCESS!", response.getMessage());
                    assertThat(response.getData()).hasSize(2);
                    assertThat(response.getData().get(0).getNomorUrut()).isEqualTo(4);
                    assertThat(response.getData().get(1).getNomorUrut()).isEqualTo(2);
                });
    }
}
