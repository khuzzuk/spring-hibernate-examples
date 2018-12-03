package pl.khuzzuk.springtest.mvc;

import org.springframework.web.bind.annotation.*;
import pl.khuzzuk.springtest.bean.MyOtherBean;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("get")
    public MyOtherBean test() {
        MyOtherBean myOtherBean = new MyOtherBean();
        myOtherBean.setMyValue("test");
        return myOtherBean;
    }

    @PostMapping("post")
    public MyOtherBean postTest(@RequestBody MyOtherBean myOtherBean) {
        return myOtherBean;
    }
}
