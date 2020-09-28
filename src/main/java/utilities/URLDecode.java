package utilities;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLDecode {

    public static String URLdecode(String url)
    {
        try {
            String prevURL="";
            String decodeURL=url;
            while(!prevURL.equals(decodeURL))
            {
                prevURL=decodeURL;
                decodeURL= URLDecoder.decode( decodeURL, "UTF-8" );
            }
            return decodeURL;
        } catch (UnsupportedEncodingException e) {
            return url;
        }
    }
}
