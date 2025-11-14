package professionnelle.eventhub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import professionnelle.eventhub.Entite.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
