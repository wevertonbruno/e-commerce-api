package dev.weverton.ecommerce.exceptions;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardException implements Serializable {
    private Integer status;
    private String msg;
    private Instant timestamp;
}
