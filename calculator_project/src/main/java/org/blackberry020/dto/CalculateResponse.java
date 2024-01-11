package org.blackberry020.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalculateResponse extends CoreResponse {
    double resultValue;

    public CalculateResponse(List<ValidationError> errors) {
        super(errors);
    }
}
