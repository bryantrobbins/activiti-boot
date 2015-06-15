package aboot.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by bryan on 6/14/15.
 */
@Entity
class TicketRequest {
    @Id
    @GeneratedValue
    Long id

    TicketRequestStatus status = TicketRequestStatus.PENDING

    String summary

    String notes

    String assignee

    String templateId

    public enum TicketRequestStatus {
       PENDING, COMPLETE
    }
}
