package com.example.demoapp;

import org.springframework.stereotype.Component;

import io.github.thymeleaf.ui.components.Sidebar;
import io.github.thymeleaf.ui.elements.Link;

@Component
public class CustomSidebarLink {
    
    public CustomSidebarLink(Sidebar sidebar) {
        sidebar.add(1, new Link("#", "Custom link"));
    }

}
