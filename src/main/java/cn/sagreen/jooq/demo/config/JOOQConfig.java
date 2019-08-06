package cn.sagreen.jooq.demo.config;

import org.jooq.conf.Settings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author linyicong
 * @since 2019-08-06
 */
@Configuration
public class JOOQConfig {
    @Bean
    public Settings settings() {
        Settings settings = new Settings();
        settings.withExecuteWithOptimisticLocking(true);
        settings.setRenderCatalog(false);
        settings.setRenderSchema(false);
        return settings;
    }
}
