package UMC.study.service.ReviewService;

import UMC.study.domain.Store;
import UMC.study.repository.StoreRepository;

import java.util.Optional;

public class StoreQueryServiceImpl implements StoreQueryService {

    StoreRepository storeRepository;

    @Override
    public Optional<Store> findStore(Long storeId){
        return storeRepository.findById(storeId);
    }
}
