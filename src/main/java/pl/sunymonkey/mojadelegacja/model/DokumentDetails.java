package pl.sunymonkey.mojadelegacja.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class DokumentDetails extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "creator_user_id")
    private User createUser;
    private LocalDateTime createDateTime;
    @OneToOne
    @JoinColumn(name = "accept_user_id")
    private User acceptUser;
    private LocalDateTime acceptDateTime;
    @OneToOne
    @JoinColumn(name = "send_user_id")
    private User sendUser;
    private LocalDateTime sendDateTime;
    @OneToOne
    @JoinColumn(name = "reject_user_id")
    private User rejectUser;
    private LocalDateTime rejectDateTime;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}
