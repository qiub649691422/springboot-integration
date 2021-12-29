/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.mq.rabbit.cut.peak.ticket_api.entity;

public class Ticket {

	private String ticketId;
	private String userId;
	
	public Ticket() {}
	/**
	 * @param ticketId
	 * @param userId
	 */
	public Ticket(String ticketId, String userId) {
		super();
		this.ticketId = ticketId;
		this.userId = userId;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
