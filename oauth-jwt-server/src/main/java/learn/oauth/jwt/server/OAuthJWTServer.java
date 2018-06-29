package learn.oauth.jwt.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2018/6/28
 * @since Jdk 1.8
 */
@SpringBootApplication
public class OAuthJWTServer {
    public static void main(String[] args) {
        SpringApplication.run(OAuthJWTServer.class,args);
    }
}
