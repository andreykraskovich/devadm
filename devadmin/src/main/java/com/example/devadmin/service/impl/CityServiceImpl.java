package com.example.devadmin.service.impl;

import com.example.devadmin.exception.ObjectNotFoundException;
import com.example.devadmin.model.City;
import com.example.devadmin.repository.CityRepository;
import com.example.devadmin.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public Page<City> getAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public City findById(Long id) {
        City city = cityRepository
                .findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException("City with id: " + id + " not found")
                );
        return city;
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void update(City city) {
        cityRepository.save(city);
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }
}
