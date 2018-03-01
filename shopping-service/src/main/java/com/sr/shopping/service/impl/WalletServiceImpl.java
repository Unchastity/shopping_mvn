package com.sr.shopping.service.impl;

import com.sr.shopping.dao.WalletDao;
import com.sr.shopping.entity.Wallet;
import com.sr.shopping.service.WalletService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("walletService")
@Transactional
public class WalletServiceImpl implements WalletService {

    @Resource private WalletDao walletDao;

    @Override
    public Wallet getWalletByUserId(Integer uid) {


        return null;
    }

    @Override
    public void updateWallet(Wallet wallet) {

    }
}
