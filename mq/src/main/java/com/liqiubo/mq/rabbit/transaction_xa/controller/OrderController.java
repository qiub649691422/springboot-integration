/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.mq.rabbit.transaction_xa.controller;

import com.liqiubo.mq.rabbit.transaction_xa.dao.exp.ReduceStockException;
import com.liqiubo.mq.rabbit.transaction_xa.model.Order;
import com.liqiubo.mq.rabbit.transaction_xa.service.jta.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    @ResponseBody
    public int save() {
        Order order = new Order();
        order.setProductId(1);
        order.setCustomer("Five");
        order.setNumber(1);
        log.info("==========> save()");

        try {
            orderService.createOrder(order);
            return 0;
        } catch (ReduceStockException e) {
            log.error("==========> error:" + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    // @RequestMapping(value = "/saveByTxTemplate", method = RequestMethod.GET)
    // @ResponseBody
    // public int saveByTxTemplate() {
    // Order order = new Order();
    // order.setProductId(1);
    // order.setAmount(1);
    // log.info("==========> saveByTxTemplate()");
    // return orderService.createOrderByTxTemplate(order);
    // }
    //
    // @RequestMapping(value = "/saveByTxManual", method = RequestMethod.GET)
    // @ResponseBody
    // public int saveByTxManual() {
    // Order order = new Order();
    // order.setProductId(1);
    // order.setAmount(1);
    // log.info("==========> saveByTxManual()");
    // return orderService.createOrderByTxManual(order);
    // }
}

