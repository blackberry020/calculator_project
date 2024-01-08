package org.blackberry020.core.services;

import org.blackberry020.dto.CalculateRequest;
import org.blackberry020.dto.CalculateResponse;

public interface CalculationService {
    public CalculateResponse calculate(CalculateRequest request);
}
