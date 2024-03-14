package org.adrian.com.spring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionSortSmallestResult {
    private int iteration;
    private int result;

    public SectionSortSmallestResult() {
        iteration = 0;
    }
}
