package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.CategorySecondDao;
import com.sr.shopping.entity.CategorySecond;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categorySecondDao")
@Transactional
public class CategorySecondDaoImpl extends BaseDaoImpl<CategorySecond> implements CategorySecondDao {


}
