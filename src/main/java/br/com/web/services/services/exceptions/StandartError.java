package br.com.web.services.services.exceptions;

import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
public class StandartError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
}
