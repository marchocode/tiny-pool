package xyz.chaobei.tinypool.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import xyz.chaobei.tinypool.TinyPoolExecutor;

@Configuration
@EnableConfigurationProperties(TinyPoolProperties.class)
@ComponentScan("xyz.chaobei.tinypool.web")
@Import(TinyMvcConfigure.class)
public class TinyPoolAutoConfigure {

    private final Logger logger = LoggerFactory.getLogger(TinyPoolAutoConfigure.class);

    @Bean
    @ConditionalOnMissingBean
    public TinyPoolExecutor tinyPoolExecutor(TinyPoolProperties properties) {
        logger.info("init");
        logger.info("properties={}", properties);
        return new TinyPoolExecutor(properties);
    }


}
