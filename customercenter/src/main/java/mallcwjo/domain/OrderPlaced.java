package mallcwjo.domain;

import java.util.*;
import lombok.Data;
import mallcwjo.infra.AbstractEvent;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productId;
    private String productName;
    private String productQty;
    private Long userId;
    private String status;
    private String userAddress;
}
