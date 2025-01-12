package com.shareNwork.domain;

import com.shareNwork.domain.constants.ResourceAvailabilityStatus;
import com.shareNwork.domain.constants.ResourceRequestStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResourceRequest extends PanacheEntity {

    @ManyToOne
    private Employee requester;

    private String pillar;

    private String project;

    private String taskDetails;

    private LocalDate startDate;

    private LocalDate endDate;

    private ResourceRequestStatus status;

    public ResourceRequest(Employee requester, String pillar, String project, String taskDetails, LocalDate startDate, LocalDate endDate, ResourceRequestStatus status) {
        this.requester = requester;
        this.pillar = pillar;
        this.project = project;
        this.taskDetails = taskDetails;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
}
