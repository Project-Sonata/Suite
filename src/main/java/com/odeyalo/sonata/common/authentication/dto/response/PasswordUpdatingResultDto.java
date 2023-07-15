package com.odeyalo.sonata.common.authentication.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.odeyalo.sonata.common.shared.ErrorDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class PasswordUpdatingResultDto {
    boolean updated;
    @JsonProperty("error_details")
    ErrorDetails errorDetails;

    public static PasswordUpdatingResultDto updated() {
        return of(true, null);
    }

    public static PasswordUpdatingResultDto failed(ErrorDetails errorDetails) {
        return of(false, errorDetails);
    }
}
