package com.example.airsoft_web.service.session;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

@Getter
@Setter
@Component
@SessionAttributes("loggedPlayer")
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
