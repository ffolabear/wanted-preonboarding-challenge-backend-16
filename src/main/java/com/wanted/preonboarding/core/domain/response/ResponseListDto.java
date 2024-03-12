package com.wanted.preonboarding.core.domain.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseListDto<T> {

    private List<T> data;
}
