package xyz.chaobei.tinypool.annotations;

import org.springframework.context.annotation.Import;
import xyz.chaobei.tinypool.config.TinyPoolConfigure;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({TinyPoolConfigure.class})
@Documented
public @interface EnableTinyPool {


}
