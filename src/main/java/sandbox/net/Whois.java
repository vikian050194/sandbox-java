package sandbox.net;

import java.io.IOException;
import java.net.Socket;

public class Whois {

    public static void main(String[] args) throws IOException {
        int c;

        try (var s = new Socket("whois.internic.net", 43)) {
            var in = s.getInputStream();
            var out = s.getOutputStream();

            var target = "mhprofessional.com";
            var buffer = target.getBytes();

            out.write(buffer);

            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }
}
