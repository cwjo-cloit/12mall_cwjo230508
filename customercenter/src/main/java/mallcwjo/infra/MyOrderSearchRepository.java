package mallcwjo.infra;

import java.util.List;
import mallcwjo.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "myOrderSearches",
    path = "myOrderSearches"
)
public interface MyOrderSearchRepository
    extends PagingAndSortingRepository<MyOrderSearch, Long> {
    List<MyOrderSearch> findByOrderId(Long orderId);
}
