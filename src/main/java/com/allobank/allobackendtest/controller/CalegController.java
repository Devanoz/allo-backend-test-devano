package com.allobank.allobackendtest.controller;

import com.allobank.allobackendtest.model.dto.CalegDto;
import com.allobank.allobackendtest.model.errors.GenericResponse;
import com.allobank.allobackendtest.service.CalegService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("calegs")
@RequiredArgsConstructor
public class CalegController {

    private final CalegService calegService;

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CalegDto>> getCalegById(@PathVariable UUID id) {
        return ResponseEntity.ok(GenericResponse.success(calegService.findCalegById(id)));
    }

    @GetMapping("")
    public ResponseEntity<GenericResponse<List<CalegDto>>> getAllCalegs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(name="partai", required = false) UUID partaiId,
            @RequestParam(name="dapil", required = false) UUID dapilId,
            @RequestParam(defaultValue = "nomor_urut,asc") String sort
    ) {
        Sort sorting;
        if(sort.contains(",")) {
            String [] sortSplit = sort.split(",");
            sorting = Sort.by(sortSplit[1].equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortSplit[0]);
        }else {
            throw new IllegalArgumentException("Invalid sort parameter");
        }

        if (partaiId != null && dapilId != null) {
            return ResponseEntity.ok(GenericResponse.success(calegService.findAllByPartaiIdAndDapilIdPageable(partaiId, dapilId, page, size, sorting)));
        } else if(partaiId != null) {
            return ResponseEntity.ok(GenericResponse.success(calegService.findAllByPartaiIdPageable(partaiId, page,size, sorting)));
        }else if (dapilId != null) {
            return ResponseEntity.ok(GenericResponse.success(calegService.findAllByDapilId(dapilId, page, size, sorting)));
        } else {
            return ResponseEntity.ok(GenericResponse.success(calegService.findAllCalegsPageable(page, size, sorting)));
        }
    }
}
