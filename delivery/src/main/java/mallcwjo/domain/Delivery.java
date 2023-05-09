package mallcwjo.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mallcwjo.DeliveryApplication;
import mallcwjo.domain.DeliverCanceled;
import mallcwjo.domain.DeliverStarted;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Long productId;

    private String productName;

    private Integer productQty;

    private String status;

    private String userAddress;

    @PostPersist
    public void onPostPersist() {
        DeliverStarted deliverStarted = new DeliverStarted(this);
        deliverStarted.publishAfterCommit();

        DeliverCanceled deliverCanceled = new DeliverCanceled(this);
        deliverCanceled.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void deliveryStart(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        DeliverStarted deliverStarted = new DeliverStarted(delivery);
        deliverStarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliverStarted deliverStarted = new DeliverStarted(delivery);
            deliverStarted.publishAfterCommit();

         });
        */

    }

    public static void deliveryCancel(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        DeliverCanceled deliverCanceled = new DeliverCanceled(delivery);
        deliverCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliverCanceled deliverCanceled = new DeliverCanceled(delivery);
            deliverCanceled.publishAfterCommit();

         });
        */

    }
}
