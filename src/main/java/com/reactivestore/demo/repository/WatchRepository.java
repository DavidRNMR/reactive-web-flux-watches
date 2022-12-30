package com.reactivestore.demo.repository;

import com.reactivestore.demo.domain.Watch;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface WatchRepository extends ReactiveMongoRepository<Watch,String> {

    Flux <Watch> findByBrand(String brand);
}
