package aboot.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by bryan on 6/14/15.
 */
@Entity
class Applicant {
    @Id
    @GeneratedValue
    Long id;

    String name;

    String email;

    String phoneNumber;
}
