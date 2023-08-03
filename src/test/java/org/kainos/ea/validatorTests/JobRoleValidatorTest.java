package org.kainos.ea.validatorTests;

import org.junit.jupiter.api.Test;
import org.kainos.ea.model.JobRoleRequest;
import org.kainos.ea.validator.JobRoleValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JobRoleValidatorTest {

    JobRoleValidator jobRoleValidator = new JobRoleValidator();
    JobRoleRequest jobRoleRequest = new JobRoleRequest("Test Job Role", "Test Description", 1, 1, "https://kainos.com");

    @Test
    void isValidJobRole_shouldReturnTrue_whenJobRoleValid() {
        assertTrue(jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    void isValidJobRole_shouldReturnFalse_whenNameTooLong() {
        String longName = "name".repeat(1000);
        jobRoleRequest.setName(longName);
        assertFalse(jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    void isValidJobRole_shouldReturnFalse_whenNameIsEmpty() {
        jobRoleRequest.setName("");
        assertFalse(jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    void isValidJobRole_shouldReturnFalse_whenUrlTooLong() {
        String longUrl = "https://" + "a".repeat(1000) + ".com";
        jobRoleRequest.setUrl(longUrl);
        assertFalse(jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    void isValidJobRole_shouldReturnFalse_whenCapabilityIdInvalid() {
        jobRoleRequest.setCapabilityId(1000);
        assertFalse(jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    void isValidJobRole_shouldReturnFalse_whenBandIdInvalid() {
        jobRoleRequest.setBandId(1000);
        assertFalse(jobRoleValidator.isValidJobRole(jobRoleRequest));
    }
}
