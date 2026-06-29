package com.example.demo.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationRequest {
    @Valid
    @NotBlank(message = "VALIDATION.REGISTRATION.NAME.NOT_BLANK")
    @Size(min = 2, max = 50, message = "VALIDATION.REGISTRATION.NAME.SIZE")
    @Schema(example = "John Doe")
    private String name ;
    @Valid
    @NotBlank(message = "VALIDATION.REGISTRATION.EMAIL.NOT_BLANK")
    @Size(min = 2, max = 100, message = "VALIDATION.REGISTRATION.EMAIL.SIZE")
    @Schema(example = "john.doe@example.com")
    private String email ;
    @Valid
    @NotBlank(message = "VALIDATION.REGISTRATION.PASSWORD.NOT_BLANK")
    @Size(min = 6, max = 100, message = "VALIDATION.REGISTRATION.PASSWORD.SIZE")
    @Schema(example = "password123")
    private String password ;
    @Valid
    @NotBlank(message = "VALIDATION.REGISTRATION.CONFIRMED_PASSWORD.NOT_BLANK")
    @Size(min = 6, max = 100, message = "VALIDATION.REGISTRATION.CONFIRMED_PASSWORD.SIZE")
    @Schema(example = "password123")
    private String confirmedPassword ;
}
