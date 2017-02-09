package hellorest

//import grails.test.mixin.TestMixin
//import grails.test.mixin.support.GrailsUnitTestMixin
//import spock.lang.*

import grails.plugin.json.view.mvc.JsonViewResolver
import grails.test.hibernate.HibernateSpec
import grails.test.mixin.TestFor

@TestFor(ProductController)
class ProductControllerSpec extends HibernateSpec {

    static doWithSpring = {
        jsonSmartViewResolver(JsonViewResolver)
    }

    void setup() {
        Product.saveAll(
            new Product(name: "Apple", price: 2.0),
            new Product(name: "Orange", price: 3.0),
            new Product(name: "Banana", price: 1.0),
            new Product(name: "Cake", price: 4.0)
        )
    }

    void "test the search action finds results"() {
        when:"A query is executed that finds results"
        controller.search('pp', 10)

        then:"The response is correct"
        response.json.size() == 1
        response.json[0].name == "Apple"
    }

}
