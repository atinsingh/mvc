package io.pragra.learning.mvc2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Error {
    private String code;
    private String description;
    private Instant time;
}
