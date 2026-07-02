package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        countryService = context.getBean(CountryService.class);

        LOGGER.info("Inside main");

        testAddCountry();
    }

    private static void testAddCountry() {

        LOGGER.info("Start");

        // Add a new country
        Country country = new Country("XX", "New Paradise");

        countryService.addCountry(country);

        try {

            // Retrieve the same country
            Country newCountry = countryService.findCountryByCode("XX");

            LOGGER.debug("Country={}", newCountry);

        } catch (CountryNotFoundException e) {

            LOGGER.error(e.getMessage());

        }

        LOGGER.info("End");
    }
}