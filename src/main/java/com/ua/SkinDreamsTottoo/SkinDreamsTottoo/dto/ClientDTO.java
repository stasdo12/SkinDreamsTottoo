package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {

    @NotEmpty
    private String name;


    @NotEmpty
    @Pattern(regexp="[0-9]{10}")
    private String phone;



    @Email
    private String email;

}
