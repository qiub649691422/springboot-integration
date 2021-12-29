/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.mq.rabbit.cut.peak.ticket_api.controller;

import com.liqiubo.mq.rabbit.cut.peak.ticket_api.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

	@Autowired
	private ITicketService service;
	
	@RequestMapping(value="/createTicket", produces = "application/json;charset=UTF-8;")
	public String createTicket(@RequestParam String userId){
		return service.createTicket(userId);
	}
}
