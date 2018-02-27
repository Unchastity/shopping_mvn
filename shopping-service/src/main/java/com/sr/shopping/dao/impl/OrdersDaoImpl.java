package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.OrdersDao;
import com.sr.shopping.entity.Orders;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ordersDao")
@Transactional
public class OrdersDaoImpl extends BaseDaoImpl<Orders> implements OrdersDao {


}
