package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.TicketDao;
import com.sr.shopping.entity.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ticketDao")
@Transactional
public class TicketDaoImpl extends BaseDaoImpl<Ticket> implements TicketDao {

}
