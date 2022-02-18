package com.zekademi.sms.repository;

import com.zekademi.sms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email); // user veritabanında email sorgulaması yapıyor.(var mı yok mu) varsa bilgileri döndürüyor.
// 2. Yöntem => @Query("SELECT u FROM User u WHERE u.email =?1")
// Normalde yazmaya gerek yok. Spring Boot kendisi oluşturuyor. yukarıda yapıyor.

}
