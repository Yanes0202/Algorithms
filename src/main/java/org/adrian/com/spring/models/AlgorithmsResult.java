package org.adrian.com.spring.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class AlgorithmsResult {
    private Object result;
    private String time;
    private int iterations;

    public AlgorithmsResult build (Object result, String time, int iterations) {
        return AlgorithmsResult.builder().result(result).time(time).iterations(iterations).build();
    }
}