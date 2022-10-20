package com.example.backend.rest;

import com.example.backend.repository.ShawarmaRepository;
import com.example.backend.model.Shawarma;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/shawarmas",produces = "application/json")
@CrossOrigin(origins = "http:/localhost:8080")
public class ShawarmaController {
    private ShawarmaRepository shawarmaRepository;


    public ShawarmaController(ShawarmaRepository shawarmaRepository) {
        this.shawarmaRepository = shawarmaRepository;
    }

    @GetMapping(params = "recent")
    public Iterable<Shawarma> recentShawarmas(){
        PageRequest page = PageRequest.of(0,12, Sort.by("createdAt").descending());
        return shawarmaRepository.findAll(page).getContent();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Shawarma> shawarmaById(@PathVariable("id") Long id){
        Optional<Shawarma> optionalShawarma = shawarmaRepository.findById(id);
        return optionalShawarma.map(shawarma -> new ResponseEntity<>(shawarma, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Shawarma postShawarma(@RequestBody Shawarma shawarma){
        return shawarmaRepository.save(shawarma);
    }
//    @PutMapping(path = "/{orderId}", consumes = "application/json")
//    public ShawarmaOrder patchOrder(@PathVariable("orderId") Long orderId,@RequestBody ShawarmaOrder patch){
//        ShawarmaOrder shawarmaOrder = order.findById(orderId);
//    }
}
