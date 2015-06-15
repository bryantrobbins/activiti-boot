package aboot.model

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by bryan on 6/14/15.
 */
public interface TicketRequestRepository extends JpaRepository<TicketRequest, Long> {
    // .. No methods necessary
}
