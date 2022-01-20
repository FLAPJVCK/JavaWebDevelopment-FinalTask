package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LogInCommand implements Command {

    private static final String MAIN_PAGE = "/index.jsp";
    public static final String AUTHORIZATION = "authorization";

    @Override
    public String execute(HttpServletRequest request) {
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Optional<User> optionalUser = FactoryService.getInstance().getUserServiceImpl().logIn(email,password);
        HttpSession session = request.getSession();
        if (optionalUser.isPresent()){
            session.setAttribute("email",  optionalUser.get().getEmail());
            session.setAttribute(AUTHORIZATION, true);
        } else {
            session.setAttribute("email",  "unregistered");
            session.setAttribute(AUTHORIZATION, false);
        }
        return MAIN_PAGE;
    }
}
