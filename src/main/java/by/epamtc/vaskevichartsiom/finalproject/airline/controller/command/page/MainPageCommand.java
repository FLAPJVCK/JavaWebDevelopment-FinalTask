package by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.page;

import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.Command;
import by.epamtc.vaskevichartsiom.finalproject.airline.controller.command.CommandResponse;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FactoryService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MainPageCommand implements Command {

    private static final String CURRENT_PAGE = "current_page";
    private static final String MAIN_PAGE = "/view/welcome.jsp";

    @Override
    public CommandResponse execute(HttpServletRequest request) throws ServiceException {
        request.getSession().setAttribute(CURRENT_PAGE, MAIN_PAGE);
        List<Flight> currentFlights = FactoryService.getInstance().getFlightServiceImpl().findAllCurrentFlights();
        request.getSession().setAttribute("currentFlightList", currentFlights);
        return new CommandResponse(MAIN_PAGE, CommandResponse.CommandResponseType.FORWARD);
    }
}
