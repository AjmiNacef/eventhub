package professionnelle.eventhub.Entite;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id; // même ID que celui de Keycloak

    private String username;
    private String email;
    private String fullName;
    private String avatarUrl;
    private String phone;
}
