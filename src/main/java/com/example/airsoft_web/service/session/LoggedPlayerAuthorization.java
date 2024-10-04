package com.example.airsoft_web.service.session;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class LoggedPlayerAuthorization {

    private String firstName;
    private String lastName;
    private String email;
    private String city;

    public void defaultReset() {
        setFirstName(null);
        setLastName(null);
        setEmail(null);
    }
}
