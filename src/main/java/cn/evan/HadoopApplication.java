package cn.evan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动方法
 *
 * @Author Evan
 * @date 2019.11.07 15:12
 */
@SpringBootApplication
public class HadoopApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HadoopApplication.class);
        // app.setWebEnvironment(false);
        app.run(args);
    }

}
