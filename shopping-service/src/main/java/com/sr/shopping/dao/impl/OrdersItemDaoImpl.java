package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.OrdersItemDao;
import com.sr.shopping.entity.OrdersItem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ordersItemDao")
@Transactional
public class OrdersItemDaoImpl extends BaseDaoImpl<OrdersItem> implements OrdersItemDao {


}
