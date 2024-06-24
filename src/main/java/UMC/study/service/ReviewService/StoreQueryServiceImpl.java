package UMC.study.service.ReviewService;

import UMC.study.domain.Review;
import UMC.study.domain.Store;
import UMC.study.repository.ReviewRepository;
import UMC.study.repository.StoreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public class StoreQueryServiceImpl implements StoreQueryService {

    StoreRepository storeRepository;
    ReviewRepository reviewRepository;

    @Override
    public Optional<Store> findStore(Long storeId){
        return storeRepository.findById(storeId);
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page){

        Store store = storeRepository.findById(storeId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));

        return StorePage;
    }
}
