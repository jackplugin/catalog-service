package org.jack.cloudnative.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "catalogservice")
public class CatalogServiceProperties {
    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    /**
     * A message to welcome users
     */
    private String greeting;

    public TestData getTestdata() {
        return testdata;
    }

    public void setTestdata(TestData testdata) {
        this.testdata = testdata;
    }

    private TestData testdata;

    public static class TestData {
        /**
         * A flag to toggle test data loader
         */
        private boolean enabled;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
