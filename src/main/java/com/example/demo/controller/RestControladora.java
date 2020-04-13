package com.example.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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


    /*
    este metodo tem como url de mapeameto o "server/primeFactors" e tem paramentro number que
     recebe um inteiro e eh acedido da seguinte maneira ("server/primeFactors?number=") e
     devolve um JSON contendo o number e um array da decomposicao do number
    * */
    @GetMapping("/primeFactors")
    public ResponseEntity<Object> primeFactors(@RequestParam(value = "number", defaultValue = "1") ArrayList<String> number) {
        ArrayList<Map> response = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        for (String num:number) {
            map = new HashMap<>();
            try {
                int result = Integer.parseInt(num);
                if(result>1000000){
                    map.put("number", num);
                    map.put("error", "too big number (>1e6)");
                }else{
                    ArrayList<Integer> ret= new ArrayList<>();
                    while (result != 1) {
                        int divid = 2;
                        while (result % divid != 0) {
                            divid++;
                        }
                        ret.add(divid);
                        result = result / divid;
                    }
                    map.put("number", num);
                    map.put("decomposition", ret);
                }
            } catch (NumberFormatException e) {
                map.put("number", num);
                map.put("error", "not a number");
            }
            if(number.size()==1) return new ResponseEntity<>(map,HttpStatus.OK);
            response.add(map);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
