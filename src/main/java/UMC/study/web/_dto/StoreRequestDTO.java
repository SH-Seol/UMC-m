package UMC.study.web._dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class ReviewDTO{
        @NotBlank
        private String title;
        @NotBlank
        private String content;
        @NotNull
        private int rating;
    }

    @Getter
    public static class MissionDTO{
        @NotNull
        private Long storeId;
    }

}
