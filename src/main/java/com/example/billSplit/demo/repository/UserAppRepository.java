package com.example.billSplit.demo.repository;

import com.example.billSplit.demo.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Integer> {

    Optional<List<UserApp>> findByName(String name);

    Optional<UserApp> findById(Integer userId);

}
