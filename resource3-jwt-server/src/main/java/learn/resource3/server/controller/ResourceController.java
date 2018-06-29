package learn.resource3.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2018/6/29
 * @since Jdk 1.8
 */
@RestController
public class ResourceController {
    @GetMapping(value = "/res")
    public ResponseEntity<?> getRes(){
        return ResponseEntity.ok("success");
    }
}
