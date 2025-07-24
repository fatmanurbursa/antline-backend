package com.fatmabursa.iletisimformu.controller;

import com.fatmabursa.iletisimformu.model.Iletisim;
import com.fatmabursa.iletisimformu.repository.IletisimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/iletisim")
public class IletisimController {

    private final IletisimRepository repo;
@Autowired
    public IletisimController(IletisimRepository repo) {
        this.repo = repo;
    }


    @PostMapping
    public String iletisimKaydet(@RequestBody Iletisim iletisim){

        repo.save(iletisim);
        return "Bilgiler başarıyla kaydedildi!";
    }

    @GetMapping("/tum")
    public List<Iletisim> tumKayitlariGetir() {
        return repo.findAll();
    }
}
