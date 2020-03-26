package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestControladora {

    @GetMapping("/ping")
    public ResponseEntity<Object> ping(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alive", true);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
  /*  @GetMapping("/primeFactors?number=16")
    public ResponseEntity<Object> primeFactors(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(new String[]{"number :", "2","decomposition :" ,"[ 2, 2, 2, 2 ]"});
    return new ResponseEntity<Object>(map,HttpStatus.OK);
    }*/
}
