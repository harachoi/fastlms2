package com.zerobase.fastlms.admin.service;

import java.util.List;

import com.zerobase.fastlms.admin.dto.HistoryDto;
import com.zerobase.fastlms.admin.model.HistoryParam;

public interface HistoryService {
    List<HistoryDto> list(HistoryParam parameter, String userId);
}
