package org.spring.ComponentHunhe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by hadoop on 16-9-13.
 */
public class CustomerService {
    private CustomerDao customerDao;
    @Autowired
    @Qualifier("orderDao")
    private OrderDao orderDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
//    @Autowired //类型注入
//    public void setOrderDao(OrderDao orderDao) {
//        this.orderDao = orderDao;
//    }

    @Override
    public String toString() {
        return "CustomerService{" +
                "customerDao=" + customerDao +
                ", orderDao=" + orderDao +
                '}';
    }
}
