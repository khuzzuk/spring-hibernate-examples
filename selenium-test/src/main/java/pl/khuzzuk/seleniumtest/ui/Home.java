package pl.khuzzuk.seleniumtest.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@UIScope
@Route("home")
public class Home extends Div {
    private Label label = new Label("Hello World");

    @PostConstruct
    private void init() {
        add(label);
    }
}
