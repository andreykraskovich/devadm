package com.example.devadmin.controller;

import com.example.devadmin.model.City;
import com.example.devadmin.service.impl.CityServiceImpl;
import com.example.devadmin.service.impl.QueryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
@Tag(name = "Controller for working with cities", description = "CRUD operations")
public class CityController {

    private final CityServiceImpl cityService;

    private final QueryServiceImpl queryService;

    @Operation(summary = "Getting a list of cities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The list is loaded",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @GetMapping
    public Page<City> getAllCities(Pageable pageable) {
        return cityService.getAll(pageable);
    }

    @Operation(summary = "Getting a city by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The city is loaded",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @Operation(summary = "Adding a city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City added",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @PostMapping
    public void addCity(@RequestBody City city) {
        cityService.save(city);
    }

    @Operation(summary = "Updating the city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City updated",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @PutMapping("/{id}")
    public void updateCity(@PathVariable Long id, @RequestBody City city) {
        city.setId(id);
        cityService.update(city);
    }

    @Operation(summary = "Deleting a city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City deleted",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteById(id);
    }


}
