package com.example.devadmin.controller;

import com.example.devadmin.model.City;
import com.example.devadmin.service.impl.CityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {

    private final CityServiceImpl cityService;

    @GetMapping
    public Page<City> getAllCities(Pageable pageable) {
        return cityService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @PostMapping
    public void addCity(@RequestBody City city) {
        cityService.save(city);
    }

    @PutMapping("/{id}")
    public void updateVacancy(@PathVariable Long id, @RequestBody City city) {
        city.setId(id);
        cityService.update(city);
    }

    @DeleteMapping("/{id}")
    public void deleteCompanyFeedBack(@PathVariable Long id) {
        cityService.deleteById(id);
    }
}
