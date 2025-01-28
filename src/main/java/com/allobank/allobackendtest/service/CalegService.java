package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.model.dto.CalegDto;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface CalegService {
    CalegDto findCalegById(UUID id);

    List<CalegDto> findAllCalegsPageable(int page, int size, Sort sort);

    List<CalegDto> findAllByPartaiIdPageable(UUID partaiId, int page, int size, Sort sort);

    List<CalegDto> findAllByDapilId(UUID dapilId, int page, int size, Sort sort);


    List<CalegDto> findAllByPartaiIdAndDapilIdPageable(UUID partaiId, UUID dapilId, int page, int size, Sort sort);
}
