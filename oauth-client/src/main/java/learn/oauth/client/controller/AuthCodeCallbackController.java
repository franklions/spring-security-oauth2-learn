package learn.oauth.client.controller;

import learn.oauth.client.domain.TokenEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;


/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2018/6/15
 * @since Jdk 1.8
 */
@RestController
public class AuthCodeCallbackController {

    @Autowired
    RestTemplate restTemplate;

    private static final Log logger = LogFactory.getLog(AuthCodeCallbackController.class.getName());

    /**
     * 调用此接口方法， 通过认证服务器的重定向地址来访问
     * http://localhost:9090/oauth/authorize?client_id=client_4&response_type=code
     *      &redirect_uri=http://localhost:8080/code/callback
     *
     *  Authorization= Basic encoder(user_1:123456)
     *
     * @param code
     * @return
     */
    @GetMapping("/code/callback")
    public ResponseEntity<TokenEntity> codeCallback(String code){
        logger.info(code);

        String clientAndSecret = "client_4:123456";
        //这里需要注意为 Basic 而非 Bearer
        clientAndSecret = "Basic "+ Base64.getEncoder().encodeToString(clientAndSecret.getBytes());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization",clientAndSecret);
        String url = "http://localhost:9090/oauth/token?grant_type=authorization_code&code={code}&redirect_uri=http://localhost:8080/code/callback";
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
       ResponseEntity<TokenEntity> respResult = restTemplate.exchange(url, HttpMethod.GET,httpEntity,TokenEntity.class,code);
        logger.info(respResult.getBody().toString());
        return respResult;
    }

    @GetMapping("/token/callback")
    public ResponseEntity<?> tokenCallback(HttpServletRequest  token){
        logger.debug( token.getRequestURI());
        return ResponseEntity.ok("{}");
    }


    @GetMapping("/code/login")
    public ResponseEntity<?> codeLogin(){

        String tokenUrl ="http://localhost:9090/oauth/authorize?client_id=client_4&response_type=code&redirect_uri=http://localhost:8080/code/callback";
        String clientAndSecret = "user_1:123456";
        //这里需要注意为 Basic 而非 Bearer
        clientAndSecret = "Basic "+ Base64.getEncoder().encodeToString(clientAndSecret.getBytes());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization",clientAndSecret);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<TokenEntity> respResult = restTemplate.exchange(tokenUrl,HttpMethod.GET ,httpEntity,TokenEntity.class);
        return respResult;
    }

    @GetMapping("/token/login")
    public ResponseEntity<?> tokenLogin(){

        String tokenUrl ="http://localhost:9090/oauth/authorize?client_id=client_2&response_type=token&redirect_uri=http://localhost:8080/token/callback";
        String clientAndSecret = "user_1:123456";
        //这里需要注意为 Basic 而非 Bearer
        clientAndSecret = "Basic "+ Base64.getEncoder().encodeToString(clientAndSecret.getBytes());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization",clientAndSecret);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<Object> respResult = restTemplate.exchange(tokenUrl,HttpMethod.GET ,httpEntity,Object.class);
        return respResult;
    }
}
