package learn.resource1.server.controller;

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
 * @date 2018/6/14
 * @since Jdk 1.8
 */
@RestController
public class ResourceController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/res")
    public ResponseEntity<?> getRes(){
        return ResponseEntity.ok("资源服务器1的受保护的资源.");
    }

    @GetMapping(value = "/res2/res")
    public ResponseEntity<?> getRes2(@RequestHeader("Authorization") String authorization){
        HttpHeaders entityHeader = new HttpHeaders();
        entityHeader.set("Authorization",authorization);
        HttpEntity httpEntity = new HttpEntity(entityHeader);

        return restTemplate.exchange("http://localhost:8082/res", HttpMethod.GET,
                httpEntity,String.class);
    }
}
