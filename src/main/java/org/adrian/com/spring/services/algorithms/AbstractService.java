package org.adrian.com.spring.services.algorithms;

import org.adrian.com.utils.Counter;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractService {
    Integer iterations;
    Counter counter = new Counter();
}
