package xyz.chaobei.tinypool.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {TinyMvcConfigure.class})
@ComponentScan(
        basePackages = {"xyz.chaobei.tinypool.web"}
)
public class TinyPoolConfigure {


}
