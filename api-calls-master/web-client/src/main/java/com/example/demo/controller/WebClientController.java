package com.example.demo.controller;


import com.example.demo.dto.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/web")
public class WebClientController {
    WebClient client = WebClient.create();
    String url = "http://localhost:8081/students";


    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id){
        WebClient.ResponseSpec responseSpec = client.get()
                .uri(url + "/" + id)
                .retrieve();
        return responseSpec.bodyToMono(Student.class).block();

    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) throws URISyntaxException {
        Student response = client.post()
                .uri(new URI(url))
                .body(BodyInserters.fromValue(student))
                .retrieve()
                .bodyToMono(Student.class)
                .block();
        return response;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        client.delete().uri(url + "/" + id);
        return "student with id: " + id + "deleted successfully";
    }

    @PutMapping("/{id}")
    public Mono<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
            return client.put()
                    .uri(url + "/" + id)
                    .body(Mono.just(student), Student.class)
                    .retrieve()
                    .bodyToMono(Student.class);
    }
}
