package org.adrian.com.spring.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
@Getter
@ToString
public class AlgorithmsResult {
    private Object result;
    private String time;
    private Integer iterations;

    public static AlgorithmsResult build(Object result, String time, int iterations) {
        return AlgorithmsResult.builder().result(result).time(time).iterations(iterations).build();
    }
}