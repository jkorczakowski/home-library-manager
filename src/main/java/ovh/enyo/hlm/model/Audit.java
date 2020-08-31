package ovh.enyo.hlm.model;

import org.apache.tomcat.jni.Local;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Embeddable
abstract class Audi {
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @PrePersist
    void prePersist() { createdOn = LocalDateTime.now(); }

    @PreUpdate
    void preMerge() { updatedOn = LocalDateTime.now(); }
}
