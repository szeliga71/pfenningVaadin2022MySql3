package com.example.pfenningvaadin2022mysql3.vaadin.mobil;


import com.example.pfenningvaadin2022mysql3.login.loginService.AuthService;
import com.example.pfenningvaadin2022mysql3.login.model.User;
import com.example.pfenningvaadin2022mysql3.login.view.LoginView;
import com.example.pfenningvaadin2022mysql3.model.ArbeitTag;
import com.example.pfenningvaadin2022mysql3.model.Fahrer;
import com.example.pfenningvaadin2022mysql3.service.ArbeitTagService;
import com.example.pfenningvaadin2022mysql3.service.FahrerService;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.shared.Registration;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;

//@Route(value="mmarbeittag",layout = MMainLayout.class)
@PageTitle("MArbeit Tag Form")


public class MArbeitTagForm extends VerticalLayout {

    String namee=LoginView.getUsernameFromLogin();


FahrerService fahrerService;
ArbeitTagService arbeitTagService;
ArbeitTag arbeitTag;
    Binder<ArbeitTag> binder = new Binder<>(ArbeitTag.class);
AuthService authService;

    NativeButton toTour = new NativeButton(
            "ADD TOUR");

    Button save = new Button("Save");
    Button update = new Button("Update");
    Button close = new Button("Cancel");

     DayOfWeek day;

    public MArbeitTagForm(FahrerService fahrerService, ArbeitTagService arbeitTagService){
        this.fahrerService=fahrerService;
        this.arbeitTagService=arbeitTagService;




        setSizeFull();
        setMargin(true);
        setSpacing(true);
        FormLayout formLayout=new FormLayout();

        //addClassName("mm-arbeitTag");
        //setWidth("25em");


//arbeit tag id long

        /*TextField fahrer_name=new TextField();
        fahrer_name.setSizeFull();
        fahrer_name.setValue(namee);*/
        //binder.forField(fahrer_name).bindReadOnly(namee);
        //formLayout.addFormItem(fahrer_name,"fahrer name");
        //fahrer_name.setValue(namee);

        //formLayout.addFormItem(fahrer_name,"fahrer name");


        //fahrer_name.setValue(
          //      (String) VaadinSession.getCurrent().getSession().getAttribute(user.getUsername()));


        ComboBox<DayOfWeek>weekDays=new ComboBox<>();
        formLayout.addFormItem(weekDays,"arbeit Tag");
        weekDays.setItems(DayOfWeek.values());
        weekDays.addValueChangeListener(event->{ day = weekDays.getValue();});

        //weekDays.addValueChangeListener(event->{ weekDays(day.)})

        ComboBox<Fahrer> fahrer_name_name=new ComboBox<>();
        fahrer_name_name.setSizeFull();
        fahrer_name_name.setItems(fahrerService.getFahrerByName(VaadinSession.getCurrent().getAttribute(User.class).getUsername()));

        formLayout.addFormItem(fahrer_name_name,"fahrer name");
        binder.forField(fahrer_name_name).bind(ArbeitTag::getFahrerName,ArbeitTag::setFahrerName);

        /*ComboBox<Fahrer> fahrer_name_name=new ComboBox<>();
        fahrer_name_name.setSizeFull();
        fahrer_name_name.setItems(fahrerService.getAllFahrer());

        //fahrer_name_name.setItems()
        formLayout.addFormItem(fahrer_name_name,"fahrer name");
        binder.forField(fahrer_name_name).bind(ArbeitTag::getFahrerName,ArbeitTag::setFahrerName);*/


       DatePicker arbeitbegin_date = new DatePicker();
        arbeitbegin_date.setSizeFull();
        arbeitbegin_date.setValue(setDate());

        //formLayout.addFormItem(arbeitbegin_date,"arbeitbegin");

        binder.forField(arbeitbegin_date).bind(ArbeitTag::getArbeitbeginDate,ArbeitTag::setArbeitbeginDate);

        TimePicker arbeitbegin_zeit = new TimePicker();
        arbeitbegin_zeit.setStep(Duration.ofMinutes(15));
        arbeitbegin_zeit.setSizeFull();
        formLayout.addFormItem(arbeitbegin_zeit,"begin zeit");
        binder.forField(arbeitbegin_zeit).bind(ArbeitTag::getArbeitbeginZeit,ArbeitTag::setArbeitbeginZeit);


        TimePicker arbeitende_zeit = new TimePicker();
        arbeitende_zeit.setStep(Duration.ofMinutes(15));
        arbeitende_zeit.setSizeFull();
        formLayout.addFormItem(arbeitende_zeit,"ende zeit");
        binder.forField(arbeitende_zeit).bind(ArbeitTag::getArbeitendeZeit,ArbeitTag::setArbeitendeZeit);


        IntegerField kilometer = new IntegerField();
        kilometer.setSizeFull();
        formLayout.addFormItem(kilometer,"kilometer");
        binder.forField(kilometer).bind(ArbeitTag::getKilometer,ArbeitTag::setKilometer);


        ComboBox<String> fahrerbruch = new ComboBox<>("","ja","nein");
        fahrerbruch.setSizeFull();
        formLayout.addFormItem(fahrerbruch,"fahrerbruch");
        binder.forField(fahrerbruch).bind(ArbeitTag::getFahrerbruch,ArbeitTag::setFahrerbruch);

        ComboBox<String> unfall = new ComboBox<>("","ja","nein");
        unfall.setSizeFull();
        formLayout.addFormItem(unfall,"unfall");
        binder.forField(unfall).bind(ArbeitTag::getUnfall,ArbeitTag::setUnfall);

        ComboBox<String> pause = new ComboBox<>("","0","15","45","60","90");
        pause.setSizeFull();
        formLayout.addFormItem(pause,"pause");
        binder.forField(pause).bind(ArbeitTag::getPause,ArbeitTag::setPause);

        //private List<Tour> touren;

        formLayout.setResponsiveSteps(
                // Use one column by default
                new FormLayout.ResponsiveStep("0", 1));


        add(formLayout,createButtonsLayout());

        //binder.bindInstanceFields(this);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        update.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        //addTour.addThemeVariants(ButtonVariant.LUMO_CONTRAST);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        toTour.addClickListener(e ->
                toTour.getUI().ifPresent(ui ->
                        //ui.navigate("Mtour")));
                        ui.navigate(MTour.class)));

        //testing
    update.addClickListener(click->{try{
    ArbeitTag arbeitTagBean1=new ArbeitTag();
    binder.writeBean(arbeitTagBean1);

    System.out.println(arbeitTagBean1);
    //System.out.println(arbeitTagBean1.getFahrerName());
    //System.out.println(arbeitTagBean1.getArbeitbegin_date());
        System.out.println(arbeitTagBean1.getId());}
    //System.out.println(arbeitTagBean1.getArbeitbegin_zeit());
    //System.out.println(arbeitTagBean1.getArbeitende_zeit());
    //System.out.println(arbeitTagBean1.getKilometer());}
    catch(ValidationException e){}});

        save.addClickListener(click->
        {
            try{
                ArbeitTag arbeitTagBean=new ArbeitTag();
                //arbeitTagBean.setArbeitbeginDate(setDate());
                binder.writeBean(arbeitTagBean);
                //=================================================
                System.out.println(arbeitTagBean.getFahrerName());
                System.out.println(arbeitTagBean.getArbeitbeginZeit());
                //===================================================
                arbeitTagService.addArbeitTag(arbeitTagBean);
            }

            catch(ValidationException e){}});

        //addTour.addClickListener(click ->)

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, update, close,toTour);
    }
    public void setArbeitTag(ArbeitTag arbeitTag) {
        this.arbeitTag = arbeitTag;
        binder.readBean(arbeitTag);
    }

    public LocalDate setDate() {

        LocalDate date=LocalDate.now();

        if (date.minusDays(1).getDayOfWeek().equals(day)) {

            date=date.minusDays(1);


        } else if (date.getDayOfWeek().equals(day)) {

        }
        return date;
    }          //valueOf(weekDays.getValue())){


        //}
        //LocalDate date=LocalDate.now()
        //return date;


    //=====================================================================
    public static abstract class ArbeitTagFormEvent extends ComponentEvent<MArbeitTagForm> {
        private ArbeitTag arbeitTag;

        protected ArbeitTagFormEvent(MArbeitTagForm source, ArbeitTag arbeitTag) {
            super(source, false);
            this.arbeitTag=arbeitTag;
        }

        public ArbeitTag getArbeitTag() {
            return arbeitTag;
        }
    }

    public static class SaveEvent extends ArbeitTagFormEvent {
        SaveEvent(MArbeitTagForm source, ArbeitTag arbeitTag) {
            super(source, arbeitTag);
        }
    }

    public static class DeleteEvent extends ArbeitTagFormEvent {
        DeleteEvent(MArbeitTagForm source, ArbeitTag arbeitTag) {
            super(source, arbeitTag);
        }

    }

    public static class CloseEvent extends ArbeitTagFormEvent {
        CloseEvent(MArbeitTagForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener (Class < T > eventType,
                                                                   ComponentEventListener< T > listener){
        return getEventBus().addListener(eventType, listener);
    }
}
