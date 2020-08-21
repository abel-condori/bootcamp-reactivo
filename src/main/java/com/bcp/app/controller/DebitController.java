package com.bcp.app.controller;

import com.bcp.app.model.document.Debit;
import com.bcp.app.service.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/debit")
public class DebitController {

    @Autowired
    private DebitService debitService;

    /*@PostMapping
    public ResponseEntity<Void> create(@RequestBody Debit debit) {
        debitService.create(debit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Flux<Debit>> findAll() {
        return new ResponseEntity<>(debitService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Debit debit) {
        debitService.update(debit);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        debitService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Debit>> findById(@PathVariable String id) {
        return new ResponseEntity<>(debitService.findById(id),HttpStatus.OK);
    }*/
}
