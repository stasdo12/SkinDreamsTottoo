package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class ReviewDTO {

    @NotEmpty
    private String authorName;

    @NotEmpty
    private String text;

    @NotNull
    private int rating;

}
