package com.arssekal.bancking_app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arssekal.bancking_app.entity.Account;
import com.arssekal.bancking_app.repository.AccountRepository;
import com.arssekal.bancking_app.service.AccountService;
import com.arssekal.dto.AccountDto;
import com.arssekal.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccountDto(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
    @Override 
    public AccountDto getAccountById(Long id) {
        Account account= accountRepository.findById(id).orElseThrow(()-> new RuntimeException("there is no account with this id"));
        return AccountMapper.mapToAccountDto(account);
    }
    @Override
    public AccountDto deposite(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("there is no account with this id"));
        account.setBalance(account.getBalance() + amount);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
    @Override
    public AccountDto withDraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("there is no account with this id"));
        if(amount > account.getBalance()) {
            // impossible to do the withdraw
            throw new RuntimeException("unsufficient balance");
        } else {

        }
        account.setBalance(account.getBalance() - amount);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll()
                                .stream()
                                .map(account -> AccountMapper.mapToAccountDto(account))
                                .collect(Collectors.toList());
    }

    @Override
    public AccountDto deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("there is no account with this id"));
        accountRepository.delete(account);
        return AccountMapper.mapToAccountDto(account);
    }

}
