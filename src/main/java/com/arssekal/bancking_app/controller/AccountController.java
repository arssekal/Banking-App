package com.arssekal.bancking_app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arssekal.bancking_app.service.AccountService;
import com.arssekal.dto.AccountDto;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;
    
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // add acount rest api
    @PostMapping("/create-account")
    public ResponseEntity<AccountDto> createAccountDto(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccountDto(accountDto), HttpStatus.CREATED);
    }
    // get acount rest api
    @GetMapping("/get-account/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }
    // get acount rest api
    @PutMapping("/deposite/{id}/{amount}")
    public ResponseEntity<AccountDto> deposite(@PathVariable Long id, @PathVariable double amount) {
        AccountDto accountDto = accountService.deposite(id, amount);
        return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/withdraw/{id}/{amount}")
    public ResponseEntity<AccountDto> withDraw(@PathVariable Long id, @PathVariable double amount) {
        AccountDto accountDto = accountService.withDraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    @DeleteMapping("/delete-account/{id}")
    public ResponseEntity<AccountDto> deleteAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }
}
