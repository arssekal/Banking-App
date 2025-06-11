package com.arssekal.bancking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arssekal.bancking_app.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
  