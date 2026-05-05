package br.edu.utfpr.apicore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.apicore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);

    /**
     * 
     * @param name
     * @param pageable
     * @return
     */

    public Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
