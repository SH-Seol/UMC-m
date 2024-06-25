package UMC.study.service.ReviewService;

import UMC.study.domain.Mission;
import UMC.study.domain.Review;
import UMC.study.domain.Store;
import UMC.study.repository.MissionRepository;
import UMC.study.repository.ReviewRepository;
import UMC.study.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

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

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page){
        Store store = storeRepository.findById(storeId).get();
        Page<Mission> MissionPage = missionRepository.findMissionsByStore(store, PageRequest.of(page, 10));

        return MissionPage;
    }
}
