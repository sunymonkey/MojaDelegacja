package pl.sunymonkey.mojadelegacja.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Data
public class DokumentDetails extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "creator_user_id")
    private User createUser;
    private LocalDateTime createDateTime;
    @OneToOne
    @JoinColumn(name = "accept_user_id")
    private User acceptUser;
    private LocalDateTime acceptDateTime;
}