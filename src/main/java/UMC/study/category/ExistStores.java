package UMC.study.category;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoriesExistValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStores {
    String message() default "해당하는 음식점이 존재하지 않습니다.";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
