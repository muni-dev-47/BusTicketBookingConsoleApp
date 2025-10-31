package config;

import repository.ownerRepo.BusRepository;
import repository.ownerRepo.BusScheduleRepository;
import repository.passengerRepo.AuthRepository;
import services.AdminServices.AdminService;
import services.ownerServices.BusRegistrationService;
import services.ownerServices.BusScheduleService;
import services.ownerServices.OwnerService;
import services.passengerServices.PassengerService;
import view.auth.AuthView;
import view.auth.login.OwnerLoginView;
import view.auth.login.PassengerLoginView;
import view.auth.signup.OwnerSignUpView;
import view.auth.signup.PassengerSignUpView;
import view.owner.*;
import view.passenger.PassengerView;

import java.sql.Connection;

public class ServiceLocator {

    private static ServiceLocator instance;

    private final AdminService as;
    private final OwnerService os;
    private final PassengerService ps;
    private final Connection connection;
    private final AuthView av;
    private final AuthRepository pr;
    private final repository.ownerRepo.AuthRepository or;
    private final PassengerView pv;
    private final PassengerSignUpView psv;
    private final PassengerLoginView plv;
    private final OwnerLoginView olv;
    private final OwnerSignUpView osv;
    private final OwnerView ov;
    private final BookingAndRevenueMonitoryView booking;
    private final BusAndInventoryManagementView busAndInventoryView;
    private final TripAndScheduleManagementView tripAndScheduleManagementView;
    private final AddBusView addbusview;
    private final BusRepository br;
    private final BusRegistrationService brs;
    private final AddSeatView asv;
    private final BusScheduleService busScheduleService;
    private final BusScheduleRepository busScheduleRepository;
    private final AddScheduleView addScheduleView;

    private ServiceLocator() {

        this.as = AdminService.getInstance();
        this.os = OwnerService.getInstance();
        this.pr = AuthRepository.getInstance();
        this.ps = PassengerService.getInstance();
        this.connection = DBConnector.getConnection();
        this.av = AuthView.getInstance();
        this.or = repository.ownerRepo.AuthRepository.getInstance();
        this.pv = PassengerView.getInstance();
        this.psv = PassengerSignUpView.getInstance();
        this.plv = PassengerLoginView.getInstance();
        this.osv = OwnerSignUpView.getInstance();
        this.olv = OwnerLoginView.getInstance();
        this.ov = OwnerView.getInstance();
        this.booking = BookingAndRevenueMonitoryView.getInstance();
        this.busAndInventoryView = BusAndInventoryManagementView.getInstance();
        this.tripAndScheduleManagementView = TripAndScheduleManagementView.getInstance();
        this.addbusview = AddBusView.getInstance();
        this.br = BusRepository.getInstance();
        this.brs = BusRegistrationService.getInstance();
        this.asv = AddSeatView.getInstance();
        this.busScheduleService = BusScheduleService.getInstance();
        this.busScheduleRepository = BusScheduleRepository.getInstance();
        this.addScheduleView = AddScheduleView.getInstance();
    }

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new ServiceLocator();
        }
        return instance;
    }

    public PassengerService getPassengerService() {
        return ps;
    }

    public Connection getConnection() {
        return connection;
    }

    public AuthView getAuthView() {
        return av;
    }

    public AdminService getAdminService() {
        return as;
    }

    public OwnerService getOwnerService() {
        return os;
    }

    public AuthRepository getPassengerAuthRepo() {
        return pr;
    }

    public repository.ownerRepo.AuthRepository getOwnerRepo() {
        return or;
    }

    public PassengerView getPassengerView() {
        return pv;
    }

    public PassengerSignUpView getPassengerSignUpView() {
        return psv;
    }

    public PassengerLoginView getPassengerLoginView() {
        return plv;
    }

    public OwnerSignUpView getOwnerSignUpView() {
        return osv;
    }

    public OwnerLoginView getOwnerLoginView() {
        return olv;
    }

    public OwnerView getOwnerView() {
        return ov;
    }

    public BookingAndRevenueMonitoryView getBookingView() {
        return booking;
    }

    public BusAndInventoryManagementView getBusAndInventoryView() {
        return busAndInventoryView;
    }

    public AddBusView getAddBusView() {
        return addbusview;
    }

    public BusRepository gerBusRepo() {
        return br;
    }

    public BusRegistrationService getBusRegistrationService() {
        return brs;
    }

    public AddSeatView getAddSeatView() {
        return asv;
    }

    public BusScheduleService getBusScheduleService() {
        return busScheduleService;
    }

    public BusScheduleRepository getBusScheduleRepository() {
        return busScheduleRepository;
    }

    public AddScheduleView getAddScheduleView() {
        return addScheduleView;
    }

    public TripAndScheduleManagementView getTripAndScheduleManagementView() {
        return tripAndScheduleManagementView;
    }
}
