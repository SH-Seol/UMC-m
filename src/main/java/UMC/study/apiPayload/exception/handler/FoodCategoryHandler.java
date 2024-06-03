package UMC.study.apiPayload.exception.handler;

import UMC.study.apiPayload.code.status.ErrorStatus;
import UMC.study.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(ErrorStatus errorCode) {super(errorCode);}
}
