package professionnelle.eventhub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import professionnelle.eventhub.Entite.Registration;

import java.util.List;
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByUserId(String userId);
    List<Registration> findByEventId(Long eventId);
}
