package io.vimero.sovio;

import io.vimero.ms.annotation.VimeroBootApplication;
import io.vimero.security.VimeroAuth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@VimeroAuth
@VimeroBootApplication
public class SovioApplication extends SpringBootServletInitializer {
    

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(SovioApplication.class);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(SovioApplication.class, args);
    }

}