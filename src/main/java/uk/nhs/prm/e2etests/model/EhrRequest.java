package uk.nhs.prm.e2etests.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EhrRequest {
    private String outboundConversationId;
    private String message;
}
