package it.typesupport.model;

import org.springframework.content.commons.annotations.ContentId;

import java.io.Serializable;

public class ContentEntity<SID extends Serializable> {
    @ContentId
    private SID contentId;

    public SID getContentId() {
        return contentId;
    }

    public void setContentId(SID contentId) {
        this.contentId = contentId;
    }
}
