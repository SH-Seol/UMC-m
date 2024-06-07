package UMC.study.web._dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewDTO{
        @NotBlank
        private String title;
        @NotBlank
        private String content;
        @NotNull
        private int rating;
    }

}
