package com.example.pfenningvaadin2022mysql3.login.view;

import com.example.pfenningvaadin2022mysql3.login.loginService.AuthService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.context.annotation.Bean;

@Route(value = "login")
@PageTitle("Login")

public class LoginView extends VerticalLayout {


public static String usernameFromLogin;

    public LoginView(AuthService authService) {
        setId("login-view");
        var username = new TextField("Username");
        var password = new PasswordField("Password");
        setSizeFull();
        setAlignItems(FlexComponent.Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        add(
                new H1("Pfenning Login"),
                username,
                password,
                new Button("Login", event -> {
                    try {
                        authService.authenticate(username.getValue(), password.getValue());

                        UI.getCurrent().navigate("home");
                        usernameFromLogin=username.getValue();
                        System.out.println(usernameFromLogin);
                    } catch (AuthService.AuthException e) {
                        Notification.show("Wrong credentials.");
                    }
                })
                //new RouterLink("Register", RegisterView.class)
        );
    }

    public static String getUsernameFromLogin() {
        return usernameFromLogin;
    }
}
