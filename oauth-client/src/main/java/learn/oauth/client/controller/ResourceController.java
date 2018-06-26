package learn.oauth.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2018/6/19
 * @since Jdk 1.8
 */
@RestController
public class ResourceController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/res1")
    public ResponseEntity<?> getRes1(@RequestHeader("Authorization") String authorization ){
        String url ="http://localhost:8081/res";
        HttpHeaders entityHeader = new HttpHeaders();
        entityHeader.set("Authorization",authorization);
        HttpEntity httpEntity = new HttpEntity(entityHeader);

        ResponseEntity<String> respRetval = restTemplate.exchange(url, HttpMethod.GET,httpEntity,String.class);
        return respRetval;
    }
}
