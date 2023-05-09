package mallcwjo.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import mallcwjo.config.kafka.KafkaProcessor;
import mallcwjo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MyOrderSearchViewHandler {

    @Autowired
    private MyOrderSearchRepository myOrderSearchRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            MyOrderSearch myOrderSearch = new MyOrderSearch();
            // view 객체에 이벤트의 Value 를 set 함
            myOrderSearch.setId(orderPlaced.getId());
            myOrderSearch.setProductName(orderPlaced.getProductName());
            myOrderSearch.setProductQty(orderPlaced.getProductQty());
            // view 레파지 토리에 save
            myOrderSearchRepository.save(myOrderSearch);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliverStarted_then_UPDATE_1(
        @Payload DeliverStarted deliverStarted
    ) {
        try {
            if (!deliverStarted.validate()) return;
            // view 객체 조회

            List<MyOrderSearch> myOrderSearchList = myOrderSearchRepository.findByOrderId(
                deliverStarted.getOrderId()
            );
            for (MyOrderSearch myOrderSearch : myOrderSearchList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myOrderSearch.setStatus(deliverStarted.getStatus());
                // view 레파지 토리에 save
                myOrderSearchRepository.save(myOrderSearch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
