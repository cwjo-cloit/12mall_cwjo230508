package mallcwjo.domain;

import java.util.*;
import lombok.*;
import mallcwjo.domain.*;
import mallcwjo.infra.AbstractEvent;

@Data
@ToString
public class DeliverStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long productId;
    private String productName;
    private Integer productQty;
    private String status;
    private String userAddress;
}
