package com.telstra.codechallenge.repository;

import com.telstra.codechallenge.quotes.Quote;

import java.util.List;

public interface SpringBootRepositoriesService {
    List<RepositoryBean> getRepositories(String number);
}
