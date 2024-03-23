package org.adrian.com.spring.models;

import lombok.Data;

@Data
public class SectionSortSmallestResult {
    private int iteration;
    private int result;

    public SectionSortSmallestResult() {
        iteration = 0;
    }
}
