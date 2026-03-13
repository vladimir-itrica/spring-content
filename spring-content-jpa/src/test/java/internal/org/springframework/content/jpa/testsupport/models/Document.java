package internal.org.springframework.content.jpa.testsupport.models;

import com.github.f4b6a3.uuid.UuidCreator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;
import org.springframework.content.commons.annotations.MimeType;

@Entity
@Getter
@Setter
public class Document {

    @Id
//    @GeneratedValue
    @org.springframework.data.annotation.Id
    private String id = UuidCreator.getTimeOrdered().toString();

    @ContentId
    private String contentId;

    @ContentLength
    private Long contentLen;

    @MimeType
    private String contentMimeType;

    @ContentId
    private String renditionId;

    @ContentLength
    private long renditionLen;
}
