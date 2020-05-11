package com.telstra.codechallenge.repository;

import com.telstra.codechallenge.quotes.Quote;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpringBootRepositoriesServiceImpl implements SpringBootRepositoriesService {

    @Value("${repositories.base.url}")
    private String repoBaseUrl;

    private final String searchUrl = "search/repositories?";
    private final String parametersDate = "created:>";
    private final String parametersSort = "&sort=";
    private final String parametersOrder = "&order=";

    private RestTemplate restTemplate;

    public SpringBootRepositoriesServiceImpl(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }
    @Override
    public List<RepositoryBean> getRepositories(String number) {
        int limit = Integer.parseInt(number);
        int count = 0;
        LocalDate date = LocalDate.now().minusDays(7);
        String repoUrl = repoBaseUrl+ "/" + searchUrl;
        String queries = "q="+parametersDate+date.toString()+parametersSort+"stars"+
                parametersOrder+"desc";
        String url = repoUrl + queries;
        Repository repository = restTemplate.getForObject(url , Repository.class);
        RepositoryBean repositoryBean = null;
        List<RepositoryBean> repositoryBeans = new ArrayList<>();
        for(Items item : repository.getItems()) {

            if(item.getLanguage() != null) {
                count++;
                repositoryBean = new RepositoryBean();
                repositoryBean.setName(item.getName());
                repositoryBean.setDescription(item.getDescription());
                repositoryBean.setLanguage(item.getLanguage());
                repositoryBean.setWatchers_count(item.getWatchers_count());
                repositoryBean.setHtml_url(item.getHtml_url());
                repositoryBeans.add(repositoryBean);
                if (count == limit)
                    break;
            }
        }
        return repositoryBeans;
    }
}
