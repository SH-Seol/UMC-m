package UMC.study.web._dto;

import UMC.study.category.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDTO{
        @NotBlank
        String name;
        @NotNull
        Integer birth;
        @Size(min=5, max=20)
        String address;
        @Size(min=5, max=20)
        String specAddress;
        @NotNull
        Integer gender;
        @ExistCategories
        List<Long> preferCategory;
    }
}
