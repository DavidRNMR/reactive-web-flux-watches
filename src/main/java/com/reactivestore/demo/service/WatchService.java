package com.reactivestore.demo.service;

import com.reactivestore.demo.repository.WatchRepository;
import com.reactivestore.demo.domain.Watch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WatchService {

    @Autowired
    private WatchRepository repository;


    public Flux<Watch> getAll (){
        return repository.findAll();
    }

    public Flux<Watch> getAllbyBrand(String brand){
        return repository.findByBrand(brand);
    }

    public Mono<Watch> getById(String id){
        return repository.findById(id);
    }

    public Mono<Watch> addOne (Watch watch){
        return repository.save(watch);
    }

    public Mono<Watch> update (Watch watch, String id){

        return repository.findById(id)
                     .flatMap(watchUpdated -> {

       watchUpdated.setBrand(watch.getBrand());
        watchUpdated.setPrize(watch.getPrize());
       watchUpdated.setType(watch.getType());

         return repository.save(watchUpdated);
       });
    }

    public Mono<Void> delete (String id){
        return repository.deleteById(id);
    }


}
