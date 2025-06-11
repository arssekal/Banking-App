package com.arssekal.mapper;

import com.arssekal.bancking_app.entity.Account;
import com.arssekal.dto.AccountDto;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(
            accountDto.getId(),
            accountDto.getAccountHolder(),
            accountDto.getBalance()
        );
    }

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
            account.getId(),
            account.getAccountHolder(),
            account.getBalance()
        );
    }
}
