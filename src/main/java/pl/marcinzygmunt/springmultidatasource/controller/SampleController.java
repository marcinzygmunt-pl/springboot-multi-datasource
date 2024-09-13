package pl.marcinzygmunt.springmultidatasource.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marcinzygmunt.springmultidatasource.primary.PrimaryEntityRepository;
import pl.marcinzygmunt.springmultidatasource.secondary.SecondaryEntityRepository;

@RestController
@RequestMapping(value = "/api")
public class SampleController {

    private final PrimaryEntityRepository primaryEntityRepository;
    private final SecondaryEntityRepository secondaryEntityRepository;

    public SampleController(PrimaryEntityRepository primaryEntityRepository, SecondaryEntityRepository secondaryEntityRepository) {
        this.primaryEntityRepository = primaryEntityRepository;
        this.secondaryEntityRepository = secondaryEntityRepository;
    }

    @GetMapping("primary")
    public ResponseEntity<?> getPrimary(){
        return ResponseEntity.ok().body(primaryEntityRepository.findAll());
    }

    @GetMapping("secondary")
    public ResponseEntity<?> getSecondary(){
        return ResponseEntity.ok().body(secondaryEntityRepository.findAll());
    }

}
