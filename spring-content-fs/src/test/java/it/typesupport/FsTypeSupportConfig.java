package it.typesupport;

import it.typesupport.model.BigIntegerBasedContentEntityStore;
import it.typesupport.model.LongBasedContentEntityStore;
import it.typesupport.model.URIBasedContentEntityStore;
import it.typesupport.model.UUIDBasedContentEntityStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FsTypeSupportConfig {
    @Bean
    public UUIDBasedContentEntityStore uuidStore() {
        return new UUIDBasedContentEntityStore();
    }

    @Bean
    public URIBasedContentEntityStore uriStore() {
        return new URIBasedContentEntityStore();
    }

    @Bean
    public LongBasedContentEntityStore longStore() {
        return new LongBasedContentEntityStore();
    }

    @Bean
    public BigIntegerBasedContentEntityStore bigIntStore() {
        return new BigIntegerBasedContentEntityStore();
    }
}
