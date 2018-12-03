package pl.khuzzuk.springtest.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@AllArgsConstructor
@Component
public class MyBean {
    private MyOtherBean myOtherBean;

    public void warnTest() {
        log.warn("test warn from myBean");
        myOtherBean.warnTest();
    }
}
