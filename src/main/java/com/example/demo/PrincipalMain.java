package com.example.demo;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PrincipalMain {


    public static void main(String[] args) {

        SpringApplication.run(PrincipalMain.class, args);
    }


    /*
    este metodo tem como url de mapeameto o "server/primeFactors" e tem paramentro number que
     recebe um inteiro e eh acedido da seguinte maneira ("server/primeFactors?number=20") e
     devolve um JSON contendo o number e um array da decomposicao do number
    * */
    @GetMapping("/primeFactors")
    public String primeFactors(@RequestParam(value = "number", defaultValue = "1") int number) throws JSONException {

        JSONArray ret= new JSONArray();
        int result=number;

        while (result!=1){
            int divid=2;
            while (result%divid != 0){
                divid++;
            }
            ret.put(divid);
            result = result/divid;
        }
        JSONObject retorno = new JSONObject();
        retorno.put("number",number);

        retorno.put("decomposition", ret);

        return retorno.toString();
    }

}
