package com.shareNwork.resource;

import com.shareNwork.domain.ResourceRequest;
import com.shareNwork.domain.SharedResource;
import com.shareNwork.repository.ResourceRequestRepository;
import com.shareNwork.repository.SharedResourceRepository;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;

@AllArgsConstructor
@GraphQLApi
public class SRRequestResource {

    private ResourceRequestRepository resourceRequestRepository;

    @Query("sharedResourceRequest")
    @Description("Get all resources request")
    @Transactional
    public List<ResourceRequest> getAllSharedResourceRequest() {
        return ResourceRequest.listAll();
    }

    @Mutation
    @Description("Create a new resource request")
    public com.shareNwork.domain.ResourceRequest createOrUpdateResourceRequest(com.shareNwork.domain.ResourceRequest resourceRequest) throws ParseException {
        return this.resourceRequestRepository.updateOrCreate(resourceRequest);
    }

}
