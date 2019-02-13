package com.example.demoapp;

import static io.github.thymeleaf.ui.Components.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.thymeleaf.ui.components.Alert;
import io.github.thymeleaf.ui.components.Dropdown;
import io.github.thymeleaf.ui.components.Navigation;
import io.github.thymeleaf.ui.components.NavigationHeader;
import io.github.thymeleaf.ui.components.Sidebar;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public Navigation navBean() {
        return navigation(link("#", "text"));
    }
    
    @Bean
    public Alert demoAlert() {
        return alert("msgkey");
    }
    
    @Bean("sidebar")
    public Sidebar appSidebar() {
        Sidebar sidebar = sidebar("sidebar.header", link("#", "link"));
        sidebar.add(submenu("menu", link("#", "link"), link("#", "Link")));
        
        return sidebar;
    }
    
    @Bean
    public NavigationHeader navbar() {
        NavigationHeader header = navigationHeader("#", "navheader", link("#", "link"));
        Dropdown dropdown = dropdown("tog", "t1");
        dropdown.add(link("#", "Link"));
        dropdown.add(link("#", "Link2"));
        dropdown.divider();
        dropdown.add(link("#", "Link"));
        header.add(dropdown);
        
        return header;
    }

}
