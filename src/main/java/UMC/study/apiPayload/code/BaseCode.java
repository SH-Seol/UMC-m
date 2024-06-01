package UMC.study.apiPayload.code;


import org.springframework.http.HttpStatus;

import java.awt.desktop.UserSessionEvent;

public interface BaseCode {
    public HttpStatus getHttpStatus();
    public String getCode();
    public String getMessage();
    public ReasonDTO getReason();
    public ReasonDTO getReasonHttpStatus();
}
