package com.simbirsoft.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface CredentialsConfig extends Config {
    String email();
    String password();
    String remoteBrowserUser();
    String remoteBrowserPassword();
    String remoteBrowserURL();
}
