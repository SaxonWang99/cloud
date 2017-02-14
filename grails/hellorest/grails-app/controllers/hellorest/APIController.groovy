package hellorest


import grails.rest.*
import grails.converters.*

class APIController extends RestfulController {
    static responseFormats = ['json', 'xml']

    APIController() {
        super(Product)
    }

   def search(String q, Integer max ) { 
	    if(q) {
	        def query = Product.where { 
	            name ==~ "%${q}%"
	        }
	        respond query.list(max: Math.min( max ?: 10, 100)) 
	    }
	    else {
	        respond([]) 
	    }
	}


}
