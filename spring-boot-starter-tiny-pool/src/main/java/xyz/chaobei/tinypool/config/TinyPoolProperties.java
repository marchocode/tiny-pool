package xyz.chaobei.tinypool.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("tiny.pool")
public class TinyPoolProperties {

    private String name = "default";

    private int corePoolSize;

    private int maximumPoolSize;

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }
}
