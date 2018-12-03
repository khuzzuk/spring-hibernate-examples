package pl.khuzzuk.springtest.bean;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

public class XmlConfiguredBean {
    @Getter
    @Value("${some.property}")
    private String someValue;
}
