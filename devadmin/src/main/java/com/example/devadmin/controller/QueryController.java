package com.example.devadmin.controller;

import com.example.devadmin.service.impl.QueryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/queries")
@Tag(name = "Controller for working with queries")
public class QueryController {

    private final QueryServiceImpl queryService;

    @Operation(summary = "Send some query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request completed",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @PostMapping
    public void query(@RequestBody String query){
        queryService.query(query);
//        some examples:
//        create table meal(meal_id bigint primary key, name varchar(50) not null unique, category varchar(50) not null);
//        insert into meal (meal_id, name, category) values (0, 'Chicken Fajita', 'lunch');
    }
}
