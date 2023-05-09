package mallcwjo.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import mallcwjo.config.kafka.KafkaProcessor;
import mallcwjo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliverStarted'"
    )
    public void wheneverDeliverStarted_NotifyToWaitingUser(
        @Payload DeliverStarted deliverStarted
    ) {
        DeliverStarted event = deliverStarted;
        System.out.println(
            "\n\n##### listener NotifyToWaitingUser : " +
            deliverStarted +
            "\n\n"
        );

        // Sample Logic //
        Order.notifyToWaitingUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliverCanceled'"
    )
    public void wheneverDeliverCanceled_UpdateStatus(
        @Payload DeliverCanceled deliverCanceled
    ) {
        DeliverCanceled event = deliverCanceled;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliverCanceled + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }
}
