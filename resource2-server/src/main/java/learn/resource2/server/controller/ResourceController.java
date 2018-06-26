package learn.resource2.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2018/6/14
 * @since Jdk 1.8
 */
@RestController
public class ResourceController {

    @GetMapping("/res")
    public ResponseEntity<?> getRes(){
        return ResponseEntity.ok("这是资源服务器2的受保护资源");
    }
}
