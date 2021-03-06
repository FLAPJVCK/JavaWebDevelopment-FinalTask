package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.user;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.AttributeName;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LogInCommand implements Command {

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        String password = request.getParameter(AttributeName.PASSWORD);
        String email = request.getParameter(AttributeName.EMAIL);

        Optional<User> optionalUser = FactoryService.getInstance().getUserServiceImpl().logIn(email, password);
        HttpSession session = request.getSession();
        if (optionalUser.isPresent()) {
            session.setAttribute(AttributeName.USER_ID, optionalUser.get().getId());
            session.setAttribute(AttributeName.USER_ROLE, optionalUser.get().getUserRole());
        } else {
            request.setAttribute(AttributeName.WRONG_DATA, true);
            return new CommandResponse(PagePath.LOGIN_PAGE, CommandResponse.CommandResponseType.FORWARD);
        }
        return new CommandResponse(PagePath.MAIN_PAGE, CommandResponse.CommandResponseType.REDIRECT);
    }
}
