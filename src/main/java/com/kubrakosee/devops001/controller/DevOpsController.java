package com.kubrakosee.devops001.controller;
//dış dünyaya açmak için restController diyoruz

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
//DIŞ TARAFLA KONUŞABİLMESİ İÇİN ADRESSTE VERİLMESİ GEREKİR
//HTTPS://LOCALHOST:8080 aslında
@RequestMapping
public class DevOpsController {
    //HTTPS://LOCALHOST:8080
    @GetMapping
    public String devopsHello() {
        return "Hello World:"+new Date();
    }
    //HTTPS://LOCALHOST:8080/Info
    @GetMapping("/info")
    public String info() {
        return " DEVOPS INFO:"+new Date();
    }
}
