package krugers.microservicio.auth.authmicroservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import krugers.microservicio.auth.authmicroservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
    
    @Query("FROM User u WHERE u.role= CUSTOMER")
    List<User> findAllCustomers();
    
}
