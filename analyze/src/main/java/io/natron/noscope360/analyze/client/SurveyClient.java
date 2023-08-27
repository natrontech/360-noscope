package io.natron.noscope360.analyze.client;

import io.natron.noscope360.analyze.model.dto.SurveyRecordDto;
import io.natron.noscope360.analyze.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class SurveyClient {

    private static final Logger log = LoggerFactory.getLogger(SurveyService.class);
    private RestTemplate restTemplate;

    public SurveyClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public boolean callSurveyAPI(String id) {
        log.info("Fetching survey with id {}", id);

        String apiUrl = "https://360.natron.cloud/api/collections/surveys/records/" + id;
        try {
            restTemplate.getForObject(apiUrl, SurveyRecordDto.class);
            log.info("Fetched survey with id {}", id);
            return true;
        } catch (HttpClientErrorException ex) {
            ProblemDetail detail = ex.getResponseBodyAs(ProblemDetail.class);
            assert detail != null;
            log.error("Problem accessing API: {}", detail.getDetail());
            return false;
        }
    }
}
