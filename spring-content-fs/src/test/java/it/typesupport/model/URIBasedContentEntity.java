package it.typesupport.model;

import com.github.f4b6a3.uuid.UuidCreator;

import java.net.URI;
import java.net.URISyntaxException;

public class URIBasedContentEntity extends ContentEntity<URI> implements IdGenerator<URI> {
    @Override
    public URI generateId() {
        String baseUrl = "http://www.example.com/";
        try {
            return new URI(baseUrl + UuidCreator.getTimeOrdered());
        } catch (URISyntaxException e) {
            throw new RuntimeException("Failed to generate a random URI in tests.", e);
        }
    }
}
