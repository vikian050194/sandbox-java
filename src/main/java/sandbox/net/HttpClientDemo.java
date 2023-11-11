package sandbox.net;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientDemo {

    public static void main(String[] args) throws Exception {
        var uri = new URI("http://www.google.com");

        var myHC = HttpClient.newHttpClient();

        var myReq = HttpRequest.newBuilder(uri).build();

        var myResp = myHC.send(myReq, HttpResponse.BodyHandlers.ofInputStream());

        System.out.println("Response code is " + myResp.statusCode());
        System.out.println("Request method is " + myReq.method());
        
        var hdrs = myResp.headers();
        var hdrMap = hdrs.map();
        var hdrField = hdrMap.keySet();

        System.out.println("Header:");
        for (var k : hdrField) {
            System.out.println(k + ": " + hdrMap.get(k));
        }
        
        System.out.println("Body:");
        var input = myResp.body();
        int c;
        while((c = input.read()) != -1){
            System.out.print((char) c);
        }
    }
}
