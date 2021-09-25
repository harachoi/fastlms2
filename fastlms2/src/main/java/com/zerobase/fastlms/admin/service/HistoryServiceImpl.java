package com.zerobase.fastlms.admin.service;

import java.util.List;

import com.zerobase.fastlms.admin.dto.HistoryDto;
import com.zerobase.fastlms.admin.entity.History;
import com.zerobase.fastlms.admin.model.HistoryParam;
import com.zerobase.fastlms.admin.repository.HistoryRepository;
import com.zerobase.fastlms.member.repository.MemberRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    private Sort getSortBySortValueDesc() {
        return Sort.by(Sort.Direction.DESC, "logDt");
    }

    // @Override
    // public List<HistoryDto> list() {
    // List<History> histories =
    // historyRepository.findAll(getSortBySortValueDesc());
    // return HistoryDto.of(histories);
    // }

    @Override
    public List<HistoryDto> list(HistoryParam parameter, String userId) {
        List<History> histories = historyRepository.findAll(getSortBySortValueDesc());
        return HistoryDto.of(histories, userId);
    }
}
