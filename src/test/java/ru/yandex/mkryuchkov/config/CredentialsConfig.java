package ru.yandex.mkryuchkov.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:credentials.properties")
public interface CredentialsConfig extends Config {

    @Key("url")
    @DefaultValue("https://${login}:${password}@selenoid.autotests.cloud/wd/hub")
    String url();

    @Key("login")
    String login();

    @Key("password")
    String password();
}
