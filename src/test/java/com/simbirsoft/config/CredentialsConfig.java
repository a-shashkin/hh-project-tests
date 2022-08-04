package com.simbirsoft.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface CredentialsConfig extends Config {

    String remoteBrowserUser();
    String remoteBrowserPassword();
    String remoteBrowserURL();
}
