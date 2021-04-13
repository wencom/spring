package com.wencom.service.impl;

import com.wencom.dao.AccountDao;
import com.wencom.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void transfer(String outName, String inName, Integer money) {
        accountDao.out(outName, money);
        int i = 1/0;
        accountDao.in(inName, money);
    }
}
