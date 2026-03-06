package it.typesupport.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

public class URIBasedContentEntity extends ContentEntity<URI> implements IdGenerator<URI> {
    @Override
    public URI generateId() {
        String baseUrl = "http://www.example.com";
        UUID randomId = UUID.randomUUID();
        try {
            return new URI(baseUrl + randomId);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Failed to generate a random URI in tests.", e);
        }
    }
}
