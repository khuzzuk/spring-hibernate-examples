package pl.khuzzuk.springtest.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
public class MyOtherBean {
    private String myValue;

    public void warnTest() {
        log.warn("test warn from myOtherBean");
    }
}
