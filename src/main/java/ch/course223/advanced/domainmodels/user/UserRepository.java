package ch.course223.advanced.domainmodels.user;

import ch.course223.advanced.core.ExtendedJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends ExtendedJpaRepository<User> {
    Optional<User> findByEmail(String email);


}
