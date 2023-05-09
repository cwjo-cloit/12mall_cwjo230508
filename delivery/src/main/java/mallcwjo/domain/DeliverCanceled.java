package mallcwjo.domain;

import java.util.*;
import lombok.*;
import mallcwjo.domain.*;
import mallcwjo.infra.AbstractEvent;

@Data
@ToString
public class DeliverCanceled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long productId;
    private String productName;
    private Integer productQty;
    private String deliveryStatus;
    private String userAddress;

    public DeliverCanceled(Delivery aggregate) {
        super(aggregate);
    }

    public DeliverCanceled() {
        super();
    }
}
