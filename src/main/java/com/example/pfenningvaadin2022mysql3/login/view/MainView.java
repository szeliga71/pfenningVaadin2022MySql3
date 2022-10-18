package com.example.pfenningvaadin2022mysql3.login.view;

import com.example.pfenningvaadin2022mysql3.login.loginService.AuthService;
import com.example.pfenningvaadin2022mysql3.login.model.User;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinSession;

import java.util.Optional;

//@JsModule("./styles/shared-styles.js")
//@CssImport("./styles/views/main/main-view.css")
public class MainView extends AppLayout {

   // private final Tabs menu;
    private H1 viewTitle;
    private AuthService authService;

    public MainView(AuthService authService) {
        this.authService = authService;




            H2 viewTitle = new H2("Pfenning");
            viewTitle.getStyle().set("font-size", "var(--lumo-font-size-l)")
                    .set("margin", "0");

            Tabs views = getPrimaryNavigation();;

            HorizontalLayout wrapper = new HorizontalLayout(viewTitle);
            wrapper.setAlignItems(FlexComponent.Alignment.CENTER);
            wrapper.setSpacing(false);

            HorizontalLayout viewHeader  = new  HorizontalLayout( views);
           viewHeader.setAlignItems(FlexComponent.Alignment.CENTER);
           viewHeader.setSpacing(false);
           VerticalLayout wrapperVer=new VerticalLayout(wrapper,viewHeader);
           addToNavbar(wrapperVer);

            setPrimarySection(Section.DRAWER);
        }



        private Tab createTab(VaadinIcon viewIcon, String viewName) {
            Icon icon = viewIcon.create();
            icon.getStyle().set("box-sizing", "border-box")
                    .set("margin-inline-end", "var(--lumo-space-m)")
                    .set("padding", "var(--lumo-space-xs)");

            RouterLink link = new RouterLink();
            link.add(icon, new Span(viewName));
            // Demo has no routes
            // link.setRoute(viewClass.java);
            link.setTabIndex(-1);

            return new Tab(link);
        }

        /*private Tabs getSecondaryNavigation() {
            Tabs tabs = new Tabs();
            tabs.add(new Tab("All"), new Tab("Open"), new Tab("Completed"),
                    new Tab("Cancelled"));
            return tabs;
        }*/
        //=================================


   /* private Component createHeaderContent() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setId("header");
        layout.getThemeList().set("dark", true);
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.add(new DrawerToggle());
        viewTitle = new H1();
        layout.add(viewTitle);
        layout.add(new Image("images/user.svg", "Avatar"));
        return layout;
    }*/

    /*private Component createDrawerContent(Tabs menu) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.getThemeList().set("spacing-s", true);
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);
        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setId("logo");
        logoLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        //logoLayout.add(new Image("images/logo.png", "auth-example logo"));
        logoLayout.add(new H1("auth-example"));
        layout.add(logoLayout, menu);
        return layout;
    }*/

    //private Tabs createMenu() {
        private Tabs getPrimaryNavigation(){
        final Tabs tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        tabs.setId("tabs");
        tabs.add(createMenuItems());
        return tabs;
    }

    private Component[] createMenuItems() {
        var user = VaadinSession.getCurrent().getAttribute(User.class);
        return authService.getAuthorizedRoutes(user.getRole()).stream()
                .map(r -> createTab(r.name(), r.view()))
                .toArray(Component[]::new);
    }

    private static Tab createTab(String text, Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();
        tab.add(new RouterLink(text, navigationTarget));
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        return tab;
    }

  /*  @Override
    protected void afterNavigation() {
        super.afterNavigation();
        getTabForComponent(getContent()).ifPresent(menu::setSelectedTab);
        viewTitle.setText(getCurrentPageTitle());
    }*/

    /*private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren()
                .filter(tab -> ComponentUtil.getData(tab, Class.class)
                        .equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }*/

    private String getCurrentPageTitle() {
        return getContent().getClass().getAnnotation(PageTitle.class).value();
    }
}
/*public class MainView extends AppLayout {

    private AuthService authService;
//LogoutView logoutView;


    public MainView(AuthService authService) {
        this.authService = authService;

        createHeader();


    }

    private void createHeader() {
        H4 logo = new H4("pfenning");
        logo.addClassNames("text-l", "m-m");


        Button logout = new Button("Log out");
       logout.addClickListener(click -> new LogoutView());

        HorizontalLayout header = new HorizontalLayout(
                new DrawerToggle(),
                logo, logout
        );

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        header.expand(logo);

        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);

    }
}*/
