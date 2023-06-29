package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto;

import jakarta.validation.constraints.NotEmpty;
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
public class BlogDTO {

    @NotEmpty
    private String title;

    @NotEmpty
    private String text;

}
