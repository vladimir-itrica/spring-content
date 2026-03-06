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
        // TODO: implement
        return null;
    }

    @Bean
    public URIBasedContentEntityStore uriStore() {
        // TODO: implement
        return null;
    }

    @Bean
    public LongBasedContentEntityStore longStore() {
        // TODO: implement
        return null;
    }

    @Bean
    public BigIntegerBasedContentEntityStore bigIntStore() {
        // TODO: implement
        return null;
    }
}
