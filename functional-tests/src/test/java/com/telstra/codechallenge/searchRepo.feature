# See
# https://github.com/intuit/karate#syntax-guide
# for how to write feature scenarios
Feature: As an api user I want to retrieve some spring boot quotes

  Scenario: Get a random quote
    Given url microserviceUrl
    And path '/searchHottestRepositoriesLastWeek/4'
    When method GET
    Then status 200
    And match header Content-Type contains 'application/json'
    # see https://github.com/intuit/karate#schema-validation
    And match response ==
    """
    [{
     name : '#string',
     description : '#string',
     language : '#string',
     watchers_count : '#string',
     html_url : '#string'
    },
    {
         name : '#string',
         description : '#string',
         language : '#string',
         watchers_count : '#string',
         html_url : '#string'

        },
        {
             name : '#string',
             description : '#string',
             language : '#string',
             watchers_count : '#string',
             html_url : '#string'

            },
            {
                 name : '#string',
                 description : '#string',
                 language : '#string',
                 watchers_count : '#string',
                 html_url : '#string'

                }]
    """


