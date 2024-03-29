/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.mq.rabbit.cut.peak.ticket_api.mapper;

import com.liqiubo.mq.rabbit.cut.peak.ticket_api.entity.Ticket;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ITicketMapper {

	@Insert("insert into t_ticketinfo (ticket_id, user_id) values(#{ticket.ticketId}, #{ticket.userId})")
	public int createTicket(@Param("ticket") Ticket ticket);
}
