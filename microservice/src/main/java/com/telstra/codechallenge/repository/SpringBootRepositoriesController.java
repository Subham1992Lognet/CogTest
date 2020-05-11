package com.telstra.codechallenge.repository;


import com.telstra.codechallenge.quotes.Quote;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SpringBootRepositoriesController {

    private SpringBootRepositoriesService springBootRepositoriesService;
    @Autowired
    public SpringBootRepositoriesController(SpringBootRepositoriesService
                                                        springBootRepositoriesService) {
        this.springBootRepositoriesService = springBootRepositoriesService;
    }

    @RequestMapping(path = "/searchHottestRepositoriesLastWeek/{number}",
            method = RequestMethod.GET)
    public List<RepositoryBean> getRepositories(@PathVariable("number") String number) {
        return springBootRepositoriesService.getRepositories(number);
    }

}
