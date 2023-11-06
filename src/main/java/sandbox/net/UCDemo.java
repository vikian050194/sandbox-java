package sandbox.net;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class UCDemo {
    public static void main(String[] args) throws MalformedURLException, IOException {
        var hp = new URL("http://www.internic.net");
        var hpCon = hp.openConnection();
        
        long d = hpCon.getDate();
        System.out.println("Date: " + new Date(d));
        
        d = hpCon.getExpiration();
        System.out.println("Expiration: " + new Date(d));
        
        d = hpCon.getLastModified();
        System.out.println("LastModified: " + new Date(d));
        
        var len = hpCon.getContentLengthLong();
        System.out.println("ContentLength: " + len);
        
        System.out.println("===Content===");
        int c;
        try (java.io.InputStream input = hpCon.getInputStream()) {
            while((c = input.read()) != -1){
                System.out.print((char) c);
            }
        }
    }
}
