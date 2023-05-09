package mallcwjo.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mallcwjo.OrderApplication;
import mallcwjo.domain.OrderCanceled;
import mallcwjo.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;

    private String productName;

    private String productQty;

    private Long userId;

    private String userAddress;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void notifyToWaitingUser(DeliverStarted deliverStarted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliverStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void updateStatus(DeliverCanceled deliverCanceled) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliverCanceled.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
