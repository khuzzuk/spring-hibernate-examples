import pl.khuzzuk.springtest.bean.MyBean
import pl.khuzzuk.springtest.bean.MyOtherBean

beans {
    myOtherBean(MyOtherBean) {
        myValue = 'my value'
    }
    myBean(MyBean, myOtherBean)
}