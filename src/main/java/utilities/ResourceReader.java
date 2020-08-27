package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResourceReader {
    public static List<String> readFileFromResources(String filePath) {

        List<String> fileContents = new ArrayList<>();
        try{
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream(filePath);
            BufferedReader bfr = new BufferedReader(new InputStreamReader(Objects.requireNonNull(is), StandardCharsets.UTF_8));


            for (String line; (line = bfr.readLine()) != null; ) {
                fileContents.add(line);
            }

        }catch (IOException | NullPointerException x){
//            LOGGER.error("Could not read resources file: "+filePath);
//            LOGGER.error("Check if file exists");
        }

        if(fileContents.size() == 0){
//            LOGGER.info("Empty file src/main/resources/"+filePath);
        }

        return fileContents;

    }
}
