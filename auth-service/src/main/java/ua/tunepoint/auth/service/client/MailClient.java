package ua.tunepoint.auth.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import ua.tunepoint.auth.service.client.config.ClientConfiguration;
import ua.tunepoint.mail.api.MailEndpoint;

@FeignClient(name = "mail-service", decode404 = true, configuration = ClientConfiguration.class)
public interface MailClient extends MailEndpoint {
}
