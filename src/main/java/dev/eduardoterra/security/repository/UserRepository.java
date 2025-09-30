package dev.eduardoterra.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.security.core.userdetails.UserDetails;
import dev.eduardoterra.security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<UserDetails> findUserByEmail(String email);

}
