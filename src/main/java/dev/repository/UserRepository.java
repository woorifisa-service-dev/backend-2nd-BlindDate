//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dev.repository;

import dev.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
        Optional<User> findByEmailAndPassword(String email, String password);
        Optional<User> findByEmail(String email);

        Optional<User> findByUserId(Long userId);

}
