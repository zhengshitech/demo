package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author H
 */
@RestController
public class GetProperties {

    @Autowired
    private EncryptProperties properties;

    @GetMapping("getPass")
    public String getPass() {
        return properties.getPassword();
    }

}
