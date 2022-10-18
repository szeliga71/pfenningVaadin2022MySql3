package com.example.pfenningvaadin2022mysql3.login.loginService;

import com.example.pfenningvaadin2022mysql3.login.loginRepository.UserRepository;
import com.example.pfenningvaadin2022mysql3.login.model.Role;
import com.example.pfenningvaadin2022mysql3.login.model.User;
import com.example.pfenningvaadin2022mysql3.login.view.HomeView;
import com.example.pfenningvaadin2022mysql3.login.view.LogoutView;
import com.example.pfenningvaadin2022mysql3.login.view.MainView;
import com.example.pfenningvaadin2022mysql3.model.Fahrer;
import com.example.pfenningvaadin2022mysql3.repository.FahrerRepository;
import com.example.pfenningvaadin2022mysql3.vaadin.*;
import com.example.pfenningvaadin2022mysql3.vaadin.mobil.MArbeitTagForm;
import com.example.pfenningvaadin2022mysql3.vaadin.mobil.MStopp;
import com.example.pfenningvaadin2022mysql3.vaadin.mobil.MTour;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {






    public List<User> getAllUser(String username) {
        return userRepository.findAllByName(username);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }


    public record AuthorizedRoute(String route, String name, Class<? extends Component> view) {

    }

    public class AuthException extends Exception {

    }

    private final UserRepository userRepository;
    // private final MailSender mailSender;

    public AuthService(UserRepository userRepository){//, MailSender mailSender) {
        this.userRepository = userRepository;
        //this.mailSender = mailSender;
    }

    public void authenticate(String username, String password) throws AuthException {
        User user = userRepository.getByUsername(username);
        if (user != null && user.checkPassword(password) && user.isActive()) {
            VaadinSession.getCurrent().setAttribute(User.class, user);


            createRoutes(user.getRole());
        } else {
            throw new AuthException();
        }
    }

    private void createRoutes(Role role) {
        getAuthorizedRoutes(role).stream()
                .forEach(route ->
                        RouteConfiguration.forSessionScope().setRoute(
                                route.route, route.view, MainView.class));
    }

    public List<AuthorizedRoute> getAuthorizedRoutes(Role role) {
        var routes = new ArrayList<AuthorizedRoute>();

        if (role.equals(Role.USER)) {
            routes.add(new AuthorizedRoute("home", "Home", HomeView.class));
            routes.add(new AuthorizedRoute("mArbeiTagForm", "MArbeit Tag form", MArbeitTagForm.class));
            routes.add(new AuthorizedRoute("mTour", "MTour", MTour.class));
            routes.add(new AuthorizedRoute("mStopp", "MStopp", MStopp.class));
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));

        } else if (role.equals(Role.ADMIN)) {
           routes.add(new AuthorizedRoute("home", "Home", HomeView.class));
            routes.add(new AuthorizedRoute("fahrerList", "Fahrer List", FahrerList.class));
            routes.add(new AuthorizedRoute("arbeitTagList", "Arbeit Tag List", ArbeitTagList.class));
            routes.add(new AuthorizedRoute("tourList", "Tour List", TourList.class));
            routes.add(new AuthorizedRoute("stoppList", "Stopp List", StoppList.class));
            routes.add(new AuthorizedRoute("marktList", "Markt List", MarktList.class));
            routes.add(new AuthorizedRoute("lkwList", "Lkw List", LkwList.class));
            routes.add(new AuthorizedRoute("userList","User List",UserList.class));
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));
        }

        return routes;
    }


}
  /*  public void register(String email, String password) {
        User user = userRepository.save(new User(email, password, Role.USER));
        String text = "http://localhost:8080/activate?code=" + user.getActivationCode();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@example.com");
        message.setSubject("Confirmation email");
        message.setText(text);
        message.setTo(email);
        //mailSender.send(message);
    }

    public void activate(String activationCode) throws AuthException {
        User user = userRepository.getByActivationCode(activationCode);
        if (user != null) {
            user.setActive(true);
            userRepository.save(user);
        } else {
            throw new AuthException();
        }
    }
}*/
