package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.ProductDao;
import com.sr.shopping.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDao")
@Transactional
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {


}
