package pl.khuzzuk.example.mvc.config;

import org.springframework.format.Formatter;
import pl.khuzzuk.example.mvc.model.User;

import java.text.ParseException;
import java.util.Locale;

public class UserFormatter implements Formatter<User> {

    @Override
    public User parse(String text, Locale locale) throws ParseException {
        User user = new User();
        user.setName(text);
        return user;
    }

    @Override
    public String print(User user, Locale locale) {
        return user.getName();
    }
}
