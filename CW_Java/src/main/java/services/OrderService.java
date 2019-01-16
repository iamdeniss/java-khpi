package main.java.services;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.java.domains.Order;
import main.java.repository.OrderRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination orderDestination;
	
	public int create(final Order src) {
		int orderID = 0;
		orderID = orderRepository.insertOrder(src);
		sendOrder(src);
		return orderID;
    }
	
	private void sendOrder(Order order) {
        jmsTemplate.send(orderDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setInt("orderId", order.getOrderId());
                message.setStringProperty("login", order.getUserId().getLogin());
                message.setInt("total", order.getTotal());
                message.setStringProperty("goods", order.getGoods());
                return message;
            }
        });
    }
}