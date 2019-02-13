package com.example.demoapp;

import static io.github.thymeleaf.ui.Components.*;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.thymeleaf.ui.components.Alert;
import io.github.thymeleaf.ui.components.Badge;
import io.github.thymeleaf.ui.components.Breadcrumb;
import io.github.thymeleaf.ui.components.Button;
import io.github.thymeleaf.ui.components.ButtonGroup;
import io.github.thymeleaf.ui.components.Card;
import io.github.thymeleaf.ui.components.Carousel;
import io.github.thymeleaf.ui.components.Dropdown;
import io.github.thymeleaf.ui.components.Figure;
import io.github.thymeleaf.ui.components.Navigation;

@Controller
public class HomeController {
    
	@GetMapping("/")
	public String index(Model model) {
	    
	    //Alerts
	    model.addAttribute("alert1", alertDismissible("Text <strong>info</strong>"));
		
	    Alert simpleAlert = alert("Simple alert");
        Alert alertSuccess = alert("Alert text");
        alertSuccess.setClassName("alert alert-success");
        Alert alertFromMessageKey = alert("msgkey");
        model.addAttribute("alerts", Arrays.asList(alertSuccess, simpleAlert, alertFromMessageKey));
        
        model.addAttribute("alert", alert("This is an alert"));
        
        //Badge
        model.addAttribute("badge", badge("4"));
        model.addAttribute("badge2", badge("5"));
        Badge badge = badge("http://google.com", "google.com");
        badge.setClassName("badge badge-warning");
        model.addAttribute("badge3", badge);
        model.addAttribute("badge4", badge("/status", "status"));
        
        //Breadcrumb
		Breadcrumb breadcrumb = breadcrumb(location("/", "breadcrumb.home"), location("/", "Section"), location("breadcrumb.current"));
		model.addAttribute(breadcrumb);
		
		//Button
		model.addAttribute(button("button.text"));
        
        Button buttonlg = button("Size from Java");
        buttonlg.setClassName("btn btn-primary btn-lg");
        model.addAttribute("buttonlg", buttonlg);
        
        Button buttonDisabled = new Button("Disabled") {
            @Override
            public boolean isDisabled(HttpServletRequest request) {
                return true;
            }
        };
        
        model.addAttribute("buttonDisabled", buttonDisabled);
        
        model.addAttribute("buttontoggle", buttonToggle("Toggle"));
        
        Button buttonActive = new Button("Active") {
            @Override
            public boolean isActive(HttpServletRequest request) {
                return true;
            }
        };
        buttonActive.setToggle(true);
        model.addAttribute("buttonActive", buttonActive);
        
        Button buttonlink = buttonLink("#", "Link button");
        model.addAttribute("buttonlink", buttonlink);
        
        //Button group
        ButtonGroup buttonGroup = buttonGroup("Label", button("1"), button("2"));
        model.addAttribute(buttonGroup);
        
		//Card
		Card card = card("https://images.ctfassets.net/o59xlnp87tr5/nywabPmH5Y6W4geG8IYuk/0a59905671f8d637350df8e7ec9e7fb9/backgrounds-min.jpg?w=360&h=240&fit=fill", "Image alt");
		card.setHeader("Card header");
		card.setTitle("Card title");
		card.setText("Some quick example text");
		card.addLink("#", "Launch");
		model.addAttribute(card);
		
		Card simpleCard = card();
		simpleCard.setTitle("title");
		simpleCard.setSubtitle("subtitle");
		simpleCard.setText("Card text");
		model.addAttribute("simpleCard", simpleCard);
		
		//Carousel
		Carousel carousel = carousel("demoCarousel");
		carousel.setShowControls(true);
		carousel.setShowIndicators(true);
        String caption="carousel.caption";
        carousel.add(slide("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvsVEghPrNHRSux7UFeVoHpZX1rTnlJOacbxv1GjexAknNh1fC", caption));
        carousel.add(slide("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRo22PEegbkGiQv6m8N4IybzcX7Cd9ZqGMJbEzqrItpe0sdyRdD"));
        model.addAttribute(carousel);
		
		//Dropdown
        Dropdown dropdown = dropdown("Toggle");
        dropdown.add(link("#", "First Link"));
        dropdown.setHeader("My header");
        model.addAttribute(dropdown);
		
		//Figure
        Figure figure = figure("https://images.ctfassets.net/o59xlnp87tr5/nywabPmH5Y6W4geG8IYuk/0a59905671f8d637350df8e7ec9e7fb9/backgrounds-min.jpg?w=360&h=240&fit=fill", "alt.text");
        figure.setCaption("image.caption");
		model.addAttribute(figure);
        
		//Navigation
		Navigation navigation = navigation(link("#", "Link"), link("#", "Link"));
		navigation.add(dropdown("#"));
		model.addAttribute(navigation);
		
		//Custom component
		model.addAttribute(new CustomComponent("Hello world!"));
		
		return "index";
	}
	
	@GetMapping("/more")
	public String more() {
	    return "more-component";
	}
	
}
