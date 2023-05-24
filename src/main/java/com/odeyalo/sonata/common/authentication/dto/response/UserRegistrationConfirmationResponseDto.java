package com.odeyalo.sonata.common.authentication.dto.response;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * <p>
 * Simple response dto that used to return confirmation url and message to user after submitting valid registration form
 * The DTO supports HATEOAS for link representation in JSON
 * /p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class UserRegistrationConfirmationResponseDto extends RepresentationModel<UserRegistrationConfirmationResponseDto> {
    protected String message;
}
