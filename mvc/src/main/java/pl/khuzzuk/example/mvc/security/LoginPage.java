package pl.khuzzuk.example.mvc.security;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.khuzzuk.example.mvc.ui.HomePage;

@RequiredArgsConstructor
@UIScope
@SpringComponent
@Route("login")
@Push
public class LoginPage extends Div implements InitializingBean {
    private final AuthenticationManager authenticationManager;

    private TextField username = new TextField("User name");
    private PasswordField password = new PasswordField("Password");
    private Button login = new Button("Login");

    @Override
    public void afterPropertiesSet() {
        add(username, password, login);
        login.addClickListener(event -> loginUser());
    }

    private void loginUser() {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username.getValue(), password.getValue()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        getUI().get().navigate(HomePage.class);
    }
}
