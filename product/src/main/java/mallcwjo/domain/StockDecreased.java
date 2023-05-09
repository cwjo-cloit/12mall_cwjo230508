package mallcwjo.domain;

import java.util.*;
import lombok.*;
import mallcwjo.domain.*;
import mallcwjo.infra.AbstractEvent;

@Data
@ToString
public class StockDecreased extends AbstractEvent {

    private Long id;
    private String productName;
    private String productQty;

    public StockDecreased(Inventory aggregate) {
        super(aggregate);
    }

    public StockDecreased() {
        super();
    }
}
