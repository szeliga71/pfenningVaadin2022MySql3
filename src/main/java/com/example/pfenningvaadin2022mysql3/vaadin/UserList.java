package com.example.pfenningvaadin2022mysql3.vaadin;


import com.example.pfenningvaadin2022mysql3.login.loginService.AuthService;
import com.example.pfenningvaadin2022mysql3.login.model.Role;
import com.example.pfenningvaadin2022mysql3.login.model.User;
import com.example.pfenningvaadin2022mysql3.service.MarktService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;


@PageTitle("UserList")
//@RolesAllowed("ADMIN")
public class UserList extends VerticalLayout {
    Grid<User> grid = new Grid<>(User.class);
    TextField filterText = new TextField();
    AuthService authService ;
    UserForm userForm;

    public UserList(AuthService authService) {
        this.authService=authService;
        addClassName("user-list");
        setSizeFull();
        configureGrid();
        configureUserForm();

        //add(getToolbar(), grid);
        add(getToolbar(), getContent());
        updateList();
        closeEditor();
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid,userForm);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, userForm);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    private void configureGrid() {
        grid.addClassNames("user-grid");
        grid.setSizeFull();
        grid.setColumns("username", "password","role","activationCode","active");

        //grid.addColumn(contact -> contact.getStatus().getName()).setHeader("Status");
        //grid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event ->
                editUser(event.getValue()));
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by user name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addUser = new Button("Add User");
        addUser.addClickListener(click -> addUser());
        Button deleteUser = new Button("Delete User");
        Button updateUser = new Button("Update User");

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addUser,
                deleteUser, updateUser);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
    public void editUser(User user) {
        if (user == null) {
            closeEditor();
        } else {
            userForm.setUser(user);
            userForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        userForm.setUser(null);
        userForm.setVisible(false);
        removeClassName("editing");
    }

    private void addUser() {
        grid.asSingleSelect().clear();
        editUser(new User());
    }

    private void updateList() {
        grid.setItems(authService.getAllUser(filterText.getValue()));
    }

    private void configureUserForm() {
        userForm = new UserForm();
        userForm.setWidth("25em");
        userForm.addListener(UserForm.SaveEvent.class, this::saveUser);
        userForm.addListener(UserForm.DeleteEvent.class, this::deleteUser);
        userForm.addListener(UserForm.CloseEvent.class, e -> closeEditor());
    }

    private void saveUser(UserForm.SaveEvent event) {
        authService.addUser(event.getUser());
        updateList();
        closeEditor();
    }

    private void deleteUser(UserForm.DeleteEvent event) {
        authService.deleteUser(event.getUser());
        updateList();
        closeEditor();
    }
}