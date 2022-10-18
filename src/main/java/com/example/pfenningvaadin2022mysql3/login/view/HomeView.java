package com.example.pfenningvaadin2022mysql3.login.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;

@PageTitle("Home")

public class HomeView extends VerticalLayout {


    public HomeView(){
    setSpacing(false);

    Image img = new Image("/images/pfenning111.png", "placeholder plant");
        img.setWidth("100%");
    add(img);

    //add(new H2("This place intentionally left empty"));
    // add(new Paragraph("It’s a place where you can grow your own UI 🤗"));

    setSizeFull();
    setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
    setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    getStyle().set("text-align", "center");


}
  /*  Label notification=new Label("Hello HOME !!");

    HomeView(){

        notification.setVisible(true);

        add(notification);
    }*/


}
