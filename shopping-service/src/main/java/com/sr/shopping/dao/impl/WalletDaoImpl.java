package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.WalletDao;
import com.sr.shopping.entity.Wallet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("walletDao")
@Transactional
public class WalletDaoImpl extends BaseDaoImpl<Wallet> implements WalletDao {

}
