package org.vivi.httplog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "org.vivi.httplog")
@Getter
@Setter
public class OrgViviHttpLogProperties {
    private boolean enabled;
}
