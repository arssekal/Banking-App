package com.arssekal.bancking_app.service;

import java.util.List;

import com.arssekal.dto.AccountDto;

public interface AccountService {
    AccountDto createAccountDto(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    // deposite by account holderName
    AccountDto deposite(Long id, double amount);
    AccountDto withDraw(Long id, double amount);
    List<AccountDto> getAllAccounts();
    AccountDto deleteAccount(Long id);
}
