package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.WalletDao;
import com.sr.shopping.dao.WarnDao;
import com.sr.shopping.entity.Warn;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("warnDao")
@Transactional
public class WarnDaoImpl extends BaseDaoImpl<Warn> implements WarnDao {


}
