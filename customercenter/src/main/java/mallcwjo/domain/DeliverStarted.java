package mallcwjo.domain;

import java.util.*;
import lombok.Data;
import mallcwjo.infra.AbstractEvent;

@Data
public class DeliverStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long productId;
    private String productName;
    private Integer productQty;
    private String status;
    private String userAddress;
}
