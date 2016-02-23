
// REF:  http://restlet.com/technical-resources/restlet-framework/guide/2.3/editions/jse/overview

import org.restlet.resource.ClientResource;

/**
 * Creates and launches a HTTP client invoking the server listening on port
 * 8080, and writing the response entity on the console.
 */
public class HelloClient {

    public static void main(String[] args) throws Exception {
        ClientResource helloClientresource = new ClientResource(
                "http://cloud-paulnguyen.c9users.io:8080/restlet/hello");
        helloClientresource.get().write(System.out);
    }
}

/*

http://cloud-paulnguyen.c9users.io:8080/restlet/hello

*/