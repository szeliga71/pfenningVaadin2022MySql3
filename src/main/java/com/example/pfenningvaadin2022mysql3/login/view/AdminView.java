package com.example.pfenningvaadin2022mysql3.login.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Admin")
public class AdminView extends Div {


    Label notification=new Label("Hello Admin !!");

    AdminView(){

        notification.setVisible(true);

        add(notification);
    }
}
