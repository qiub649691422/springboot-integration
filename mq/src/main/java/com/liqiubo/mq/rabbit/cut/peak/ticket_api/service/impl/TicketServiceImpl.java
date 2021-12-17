/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.mq.rabbit.cut.peak.ticket_api.service.impl;

import com.liqiubo.mq.rabbit.cut.peak.ticket_api.entity.Ticket;
import com.liqiubo.mq.rabbit.cut.peak.ticket_api.mapper.ITicketMapper;
import com.liqiubo.mq.rabbit.cut.peak.ticket_api.utils.JsonUtil;
import com.liqiubo.mq.rabbit.cut.peak.ticket_api.utils.SnowflakeOrderServiceImpl;
import com.liqiubo.mq.rabbit.cut.peak.ticket_api.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author 小五老师-云析学院
 * @createTime 2018年10月24日 下午9:36:17
 * 
 */
@Service
public class TicketServiceImpl implements ITicketService {
	
	@Autowired
	private ITicketMapper ticketMapper;
	@Autowired
	private SnowflakeOrderServiceImpl idGeneration;
	@Override
	public String createTicket(String userId) {
		try {
			Ticket ticket = new Ticket(String.valueOf(idGeneration.nextId()), userId);
			System.out.println("insert into ticket:ticketId="+ticket.getTicketId());
			int row = ticketMapper.createTicket(ticket);
			if(row>0){
				return JsonUtil.fromBean(ticket);
			}
			System.out.println("--------------------null");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
