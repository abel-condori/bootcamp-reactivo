package com.bcp.app.model.request;

import com.bcp.app.model.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BaseResponse<T> {
    private ErrorCode errorCode;
    private T data;

    public static BaseResponse successNoData() {
        return BaseResponse.builder()
                .build();
    }

    public static <T> BaseResponse<T> successWithData(T data) {
        return BaseResponse.<T>builder()
                .data(data)
                .build();
    }

    public static BaseResponse error(ErrorCode errorCode) {
        return BaseResponse.builder()
                .errorCode(errorCode)
                .build();
    }
}
