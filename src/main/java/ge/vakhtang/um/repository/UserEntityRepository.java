package ge.vakhtang.um.repository;

import ge.vakhtang.um.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity getUserEntityByUsername(String username);
}
