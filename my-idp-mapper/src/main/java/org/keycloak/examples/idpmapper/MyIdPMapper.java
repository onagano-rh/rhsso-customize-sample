/*
 * Copied from https://github.com/keycloak/keycloak/blob/18.0.2/testsuite/integration-arquillian/servers/auth-server/services/testsuite-providers/src/main/java/org/keycloak/testsuite/broker/provider/MultiValuedTestIdPMapper.java
 */

package org.keycloak.examples.idpmapper;

import org.keycloak.broker.provider.AbstractIdentityProviderMapper;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.ArrayList;
import java.util.List;

public class MyIdPMapper extends AbstractIdentityProviderMapper {
    public static final String[] COMPATIBLE_PROVIDERS = {ANY_PROVIDER};

    public static final String PROVIDER_ID = "my-idp-mapper";
    public static final String VALUES_ATTRIBUTE = "values";

    protected static final List<ProviderConfigProperty> configProperties = new ArrayList<>();

    static {
        ProviderConfigProperty property;
        property = new ProviderConfigProperty();
        property.setName(VALUES_ATTRIBUTE);
        property.setLabel("Test values");
        property.setHelpText("Define test values");
        property.setType(ProviderConfigProperty.MULTIVALUED_STRING_TYPE);
        configProperties.add(property);
    }

    @Override
    public String[] getCompatibleProviders() {
        return COMPATIBLE_PROVIDERS;
    }

    @Override
    public String getDisplayCategory() {
        return "My IdP Mapper";
    }

    @Override
    public String getDisplayType() {
        return "My IdP Mapper";
    }

    @Override
    public String getHelpText() {
        return "This is testing IdP mapper";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return configProperties;
    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }
}
