package mallcwjo.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MyOrderSearch_table")
@Data
public class MyOrderSearch {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String productName;
    private String productQty;
    private Long orderId;
    private String orderStatus;
    private Long deliveryId;
    private String status;
}
