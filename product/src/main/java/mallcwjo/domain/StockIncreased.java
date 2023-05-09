package mallcwjo.domain;

import java.util.*;
import lombok.*;
import mallcwjo.domain.*;
import mallcwjo.infra.AbstractEvent;

@Data
@ToString
public class StockIncreased extends AbstractEvent {

    private Long id;
    private String productName;
    private String productQty;

    public StockIncreased(Inventory aggregate) {
        super(aggregate);
    }

    public StockIncreased() {
        super();
    }
}
