package by.epamtc.vaskevichartsiom.finalproject.airline.domain.model;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Flight extends BaseEntity<Long>{
    private String flightNumber;
    private Date departureDate;
    private Time departureTime;
    private Long airplaneId;
    private Long destinationId;
    private Set<User> users = new HashSet<User>();

    public Flight() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Long getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Long airplaneId) {
        this.airplaneId = airplaneId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(departureDate, flight.departureDate) && Objects.equals(departureTime, flight.departureTime) && Objects.equals(airplaneId, flight.airplaneId) && Objects.equals(destinationId, flight.destinationId) && Objects.equals(users, flight.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, departureDate, departureTime, airplaneId, destinationId, users);
    }
}