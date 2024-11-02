package sandbox.net;

import java.io.IOException;
import java.net.*;

public class HttpURLDemo {

    public static void main(String[] args) throws MalformedURLException, IOException {
        var hp = new URL("http://www.google.com");
        var hpCon = (HttpURLConnection) hp.openConnection();

        System.out.println("Request method: " + hpCon.getRequestMethod());
        System.out.println("Response code: " + hpCon.getResponseCode());
        System.out.println("Response message: " + hpCon.getResponseMessage());

        var hdrMap = hpCon.getHeaderFields();
        var hdrField = hdrMap.keySet();

        System.out.println("Header:");
        for (var k : hdrField) {
            System.out.println(k + ": " + hdrMap.get(k));
        }
    }
}
