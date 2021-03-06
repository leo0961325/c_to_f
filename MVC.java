package com.example.demo.demo.controller;

import com.example.demo.demo.request.PersonRequest;
import com.example.demo.demo.response.PersonResponse;
import com.example.demo.demo.service.IIdentifyService;
import com.example.demo.demo.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {



    @Autowired
    ITestService iTestService;

    @GetMapping(value = "test")
    public String testone(){

        return iTestService.test();
    }


    @Autowired
    IIdentifyService iIdentifyService;

    @PostMapping(value = "people")
    public String ide() {



        return iIdentifyService.identify();
    }

    @PostMapping(value = "newpeople")
    public PersonResponse newpeople(@RequestBody PersonRequest personRequest) {



        PersonResponse response = new PersonResponse();

        response.setName(personRequest.getName());
        personRequest.getId().charAt(1);

        String sex = personRequest.getId().charAt(1)==49?"男":"女";
        response.setSex(sex);



        return response;
    }


@PostMapping(value = "try_again")
    public List<PersonResponse> try_again (@RequestBody PersonRequest personRequest) {

        PersonResponse response = new PersonResponse();

        String name = personRequest.getName();
        response.setName(name);

        String sex = personRequest.getId().charAt(1) ==49?"boy" : "girl";
        response.setSex(sex);

        List<PersonResponse> responseList = new ArrayList<>();
        for(int i=0 ; i<=7 ;i++){
            responseList.add(response);
        }

        return responseList;
    }




































}
