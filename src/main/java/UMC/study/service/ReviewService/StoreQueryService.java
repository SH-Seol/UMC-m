package UMC.study.service.ReviewService;

import UMC.study.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long storeId);
}
