package hello;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author H
 */
@ConfigurationProperties(prefix = "test.encrypt")
public class EncryptProperties {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
