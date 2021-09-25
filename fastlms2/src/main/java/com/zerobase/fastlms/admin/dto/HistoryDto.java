package com.zerobase.fastlms.admin.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.zerobase.fastlms.admin.entity.History;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoryDto {
    String id;

    String userName;
    LocalDateTime logDt;
    String clientIp;
    String userAgent;
    long seq;

    public static List<HistoryDto> of(List<History> categories, String userId) {
        if (categories != null) {
            List<HistoryDto> HistoryList = new ArrayList<>();
            int i = 1;
            for (History x : categories) {
                if (x.getUserName().equals(userId)) {
                    x.setSeq(i);
                    HistoryList.add(of(x));
                    i++;
                }
            }
            return HistoryList;
        }

        return null;
    }

    public static HistoryDto of(History history) {
        return HistoryDto.builder().seq(history.getSeq()).id(history.getId()).userName(history.getUserName())
                .logDt(history.getLogDt()).clientIp(history.getClientIp()).userAgent(history.getUserAgent()).build();
    }
}
