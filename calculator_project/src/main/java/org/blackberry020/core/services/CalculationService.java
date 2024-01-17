package org.blackberry020.core.services;

import org.blackberry020.app.dto.CalculateRequest;
import org.blackberry020.app.dto.CalculateResponse;

public interface CalculationService {
    public CalculateResponse calculate(CalculateRequest request);
}
