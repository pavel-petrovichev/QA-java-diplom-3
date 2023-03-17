package site.nomoreparties.stellarburgers.tests.ui.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class CreateUserRequestVO {
    String email;
    String password;
    String name;
}
