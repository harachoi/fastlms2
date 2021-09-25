package com.zerobase.fastlms.admin.mapper;

import java.util.List;

import com.zerobase.fastlms.admin.dto.HistoryDto;
import com.zerobase.fastlms.admin.model.HistoryParam;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryMapper {
    long selectListCount(HistoryParam parameter);

    List<HistoryDto> selectList(HistoryParam parameter);
}
