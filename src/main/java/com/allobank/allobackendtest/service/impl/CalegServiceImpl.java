package com.allobank.allobackendtest.service.impl;

import com.allobank.allobackendtest.common.errors.ResourceNotFoundException;
import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.dto.CalegDto;
import com.allobank.allobackendtest.repository.CalegRepository;
import com.allobank.allobackendtest.service.CalegService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CalegServiceImpl implements CalegService {

    private final CalegRepository calegRepository;

    @Override
    public CalegDto findCalegById(UUID id) {
        Caleg caleg = calegRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Caleg with id " + id + " not found"));
        return CalegDto.fromCaleg(caleg);
    }

    @Override
    public List<CalegDto> findAllCalegsPageable(int page, int size, Sort sort) {
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Caleg> allCalegsPageable = calegRepository.findAllCalegsPageable(pageRequest);
        return allCalegsPageable.stream().map(CalegDto::fromCaleg).toList();
    }

    @Override
    public List<CalegDto> findAllByPartaiIdPageable(UUID partaiId, int page, int size, Sort sort) {
        Page<Caleg> allCalegsByPartaiId = calegRepository.findAllCalegsByPartaiId(partaiId, PageRequest.of(page, size, sort));
        return allCalegsByPartaiId.stream().map(CalegDto::fromCaleg).toList();
    }

    @Override
    public List<CalegDto> findAllByDapilId(UUID dapilId, int page, int size, Sort sort) {
        Page<Caleg> allCalegsByDapilId = calegRepository.findAllCalegsByDapilId(dapilId, PageRequest.of(page, size, sort));
        return allCalegsByDapilId.stream().map(CalegDto::fromCaleg).toList();
    }

    @Override
    public List<CalegDto> findAllByPartaiIdAndDapilIdPageable(UUID partaiId, UUID dapilId, int page, int size, Sort sort) {
        Page<Caleg> allCalegsByPartaiIdAndDapilId = calegRepository.findAllCalegsByPartaiIdAndDapilIdPageable(partaiId, dapilId, PageRequest.of(page, size, sort));
        return allCalegsByPartaiIdAndDapilId.stream().map(CalegDto::fromCaleg).toList();
    }

}
