package UMC.study.category;

import UMC.study.service.ReviewService.ReviewService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoresExistValidator implements ConstraintValidator<ExistStores, List<Long>> {

    private ReviewService reviewService;

    @Override
    public void initialize(ExistStores constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> storesList, ConstraintValidatorContext context) {
        boolean isValid = storesList.stream().allMatch(storeId -> storeId == 0);

        return isValid;
    }
}
