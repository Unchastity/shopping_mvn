package com.sr.shopping.service;

import com.sr.shopping.entity.Wallet;

public interface WalletService {

    public Wallet getWalletByUserId(Integer uid);

    public void  updateWallet(Wallet wallet);

}
