package pl.khuzzuk.example.mvc.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;

@UIScope
@SpringComponent
@Route("")
public class HomePage extends Div {
    private Label hello = new Label("Hello world");

    @PostConstruct
    private void init() {
        add(hello);
    }
}
