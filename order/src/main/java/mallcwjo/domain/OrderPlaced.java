package mallcwjo.domain;

import java.util.*;
import lombok.*;
import mallcwjo.domain.*;
import mallcwjo.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productId;
    private String productName;
    private String productQty;
    private Long userId;
    private String status;
    private String userAddress;

    public OrderPlaced(Order aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
