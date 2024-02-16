package com.ghouse.memoirist.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class MemoiristApiException  {
    private String errorMessage;
    private String errorCode;
}
