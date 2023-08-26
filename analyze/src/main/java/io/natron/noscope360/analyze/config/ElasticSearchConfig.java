package io.natron.noscope360.analyze.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
public class ElasticSearchConfig extends ElasticsearchConfiguration {

    private final String host;
    private final Integer port;

    public ElasticSearchConfig(
            @Value("noscope360.elastic.host") String host,
            @Value("noscope360.elastic.port") Integer port)
    {
        this.host = host;
        this.port = port;
    }

    @Override
    public ClientConfiguration clientConfiguration() {

        return ClientConfiguration.builder()
                .connectedTo(host + ":" + port)
                .build();
    }
}
