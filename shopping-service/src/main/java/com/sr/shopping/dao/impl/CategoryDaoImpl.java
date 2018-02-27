package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.CategoryDao;
import com.sr.shopping.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {


}
