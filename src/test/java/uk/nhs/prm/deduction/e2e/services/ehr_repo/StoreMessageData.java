package uk.nhs.prm.deduction.e2e.services.ehr_repo;

import java.util.List;
import java.util.UUID;

public class StoreMessageData {

    public String type;
    public UUID id;
    public StoreMessageAttributes attributes;

    public StoreMessageData(UUID messageId, UUID conversationId, String nhsNumber, String messageType, List<UUID> attachmentMessageIds) {
        this.type = "messages";
        this.id = messageId;
        this.attributes = new StoreMessageAttributes(conversationId, nhsNumber, messageType, attachmentMessageIds);
    }
}
