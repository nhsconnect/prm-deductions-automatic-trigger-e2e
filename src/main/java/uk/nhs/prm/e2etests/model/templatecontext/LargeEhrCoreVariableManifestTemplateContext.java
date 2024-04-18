package uk.nhs.prm.e2etests.model.templatecontext;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static uk.nhs.prm.e2etests.utility.TestDataUtility.randomUppercaseUuidAsString;
import static uk.nhs.prm.e2etests.utility.ValidationUtility.NHS_NUMBER_REGEX;
import static uk.nhs.prm.e2etests.utility.ValidationUtility.ODS_CODE_REGEX;
import static uk.nhs.prm.e2etests.utility.ValidationUtility.UUID_REGEX;

@Getter
@Builder
public class LargeEhrCoreVariableManifestTemplateContext implements TemplateContext {
    @Pattern(regexp = UUID_REGEX, message = "An invalid Inbound Conversation ID was provided.")
    private String inboundConversationId;

    @Builder.Default
    @Pattern(regexp = UUID_REGEX, message = "An invalid Large EHR Core Message ID was provided.")
    private String largeEhrCoreMessageId = randomUppercaseUuidAsString();

    // TODO Tech debt? - is this field still needed?
    @Builder.Default
    @Pattern(regexp = UUID_REGEX, message = "An invalid Fragment Message ID was provided.")
    private String fragmentMessageId = randomUppercaseUuidAsString();

    @Pattern(regexp = NHS_NUMBER_REGEX, message = "An invalid NHS Number was provided.")
    private String nhsNumber;

    @Pattern(regexp = ODS_CODE_REGEX, message = "An invalid sender ODS code was provided.")
    @NotBlank(message = "The sender ODS Code cannot be blank.")
    private String senderOdsCode;

    @Builder.Default
    private List<String> referencedFragmentMessageIds = new ArrayList<>();
}