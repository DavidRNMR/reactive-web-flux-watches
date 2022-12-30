package com.reactivestore.demo.controller;

import com.reactivestore.demo.domain.Watch;
import com.reactivestore.demo.service.WatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@Slf4j
public class WatchController {

    @Autowired
    private WatchService service;

    @GetMapping("/getAll")
    public Flux<Watch> findAll(){
        return service.getAll();
    }

    @GetMapping("getAllByBrand/{brand}")
    public Flux<Watch> findAllbyBrand (@PathVariable String brand){

        return service.getAllbyBrand(brand);
    }

    @PostMapping("/watch")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Watch>  addOne (@RequestBody @Valid Watch watch){

        return service.addOne(watch);
    }

    @GetMapping("/watch/{id}")
    public Mono<Watch> getOne (@PathVariable String id){
        return service.getById(id);
    }

     @PutMapping("/watch/{id}")
    public Mono<ResponseEntity<Watch>> update (@PathVariable String id, @RequestBody Watch watch){

     return service.update(watch,id)
           .map(ResponseEntity.ok()::body)
          .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
     }

    @DeleteMapping("/watch/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete (@PathVariable String id){

        return service.delete(id);
    }


}
