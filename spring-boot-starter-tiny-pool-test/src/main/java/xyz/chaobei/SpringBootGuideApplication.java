package xyz.chaobei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.chaobei.tinypool.TinyPoolExecutor;

@SpringBootApplication
public class SpringBootGuideApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGuideApplication.class, args);
    }

    @Autowired
    private TinyPoolExecutor tinyPoolExecutor;

    @Override
    public void run(String... args) throws Exception {

        Runnable runnable = () -> {
            System.out.println("success");
        };

        tinyPoolExecutor.execute(runnable);
    }
}
