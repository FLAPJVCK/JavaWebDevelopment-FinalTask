package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.PagePath;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BrigadePageCommand implements Command {

    private static final String CURRENT_PAGE = "current_page";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, PagePath.BRIGADE_PAGE);
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        List<User> brigade = FactoryService.getInstance().getFlightServiceImpl().findBrigade(flightId);
        request.getSession().setAttribute("brigade", brigade);
        return new CommandResponse(PagePath.BRIGADE_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
