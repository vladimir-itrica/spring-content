package it.typesupport.model;

import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;

import java.io.Serializable;

public class ContentEntity<SID extends Serializable> {
    @ContentId
    private SID contentId;

    @ContentLength
    private long contentLength;

    public SID getContentId() {
        return contentId;
    }

    public void setContentId(SID contentId) {
        this.contentId = contentId;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }
}
