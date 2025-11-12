package config;

import repository.ownerRepo.BusRepository;
import repository.ownerRepo.BusScheduleRepository;
import repository.ownerRepo.DriverRepository;
import repository.passengerRepo.AuthRepository;
import services.AdminServices.AdminService;
import services.ownerServices.BusService;
import services.ownerServices.BusScheduleService;
import services.ownerServices.DriverService;
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

    // service
    private final DriverService driverService;
    private final BusScheduleService busScheduleService;
    private final AdminService adminService;
    private final OwnerService ownerService;
    private final PassengerService passengerService;

    //view
    private final AuthView authView;
    private final PassengerSignUpView passengerSignUpView;
    private final PassengerLoginView passengerLoginView;
    private final OwnerLoginView ownerLoginView;
    private final PassengerView passengerView;
    private final OwnerSignUpView ownerSignUpView;
    private final OwnerView ownerView;
    private final BusAndInventoryManagementView busAndInventoryView;
    private final TripAndScheduleManagementView tripAndScheduleManagementView;
    private final AddBusView addbusview;
    private final AddSeatView addSeatView;
    private final AddScheduleView addScheduleView;
    private final DriverView driverView;
    private final BusListView busListView;
    private final DriverListView driverListView;
    //repo
    private final AuthRepository passengerRepo;
    private final repository.ownerRepo.AuthRepository ownerRepo;
    private final BookingAndRevenueMonitoryView booking;
    private final BusRepository busRepository;
    private final BusService busService;
    private final BusScheduleRepository busScheduleRepository;
    private final DriverRepository driverRepository;

    //db
    private final Connection connection;

    private ServiceLocator() {

        this.adminService = AdminService.getInstance();
        this.ownerService = OwnerService.getInstance();
        this.passengerRepo = AuthRepository.getInstance();
        this.passengerService = PassengerService.getInstance();
        this.connection = DBConnector.getConnection();
        this.authView = AuthView.getInstance();
        this.ownerRepo = repository.ownerRepo.AuthRepository.getInstance();
        this.passengerView = PassengerView.getInstance();
        this.passengerSignUpView = PassengerSignUpView.getInstance();
        this.passengerLoginView = PassengerLoginView.getInstance();
        this.ownerSignUpView = OwnerSignUpView.getInstance();
        this.ownerLoginView = OwnerLoginView.getInstance();
        this.ownerView = OwnerView.getInstance();
        this.booking = BookingAndRevenueMonitoryView.getInstance();
        this.busAndInventoryView = BusAndInventoryManagementView.getInstance();
        this.tripAndScheduleManagementView = TripAndScheduleManagementView.getInstance();
        this.addbusview = AddBusView.getInstance();
        this.busRepository = BusRepository.getInstance();
        this.busService = BusService.getInstance();
        this.addSeatView = AddSeatView.getInstance();
        this.busScheduleService = BusScheduleService.getInstance();
        this.busScheduleRepository = BusScheduleRepository.getInstance();
        this.addScheduleView = AddScheduleView.getInstance();
        this.driverRepository = DriverRepository.getInstance();
        this.driverService = DriverService.getInstance();
        this.driverView = DriverView.getInstance();
        this.busListView = BusListView.getInstance();
        this.driverListView = DriverListView.getInstance();
    }

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new ServiceLocator();
        }
        return instance;
    }

    public DriverRepository getDriverRepository() {
        return driverRepository;
    }

    public DriverService getDriverService() {
        return driverService;
    }

    public PassengerService getPassengerService() {
        return passengerService;
    }

    public Connection getConnection() {
        return connection;
    }

    public AuthView getAuthView() {
        return authView;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public OwnerService getOwnerService() {
        return ownerService;
    }

    public AuthRepository getPassengerAuthRepo() {
        return passengerRepo;
    }

    public repository.ownerRepo.AuthRepository getOwnerRepo() {
        return ownerRepo;
    }

    public PassengerView getPassengerView() {
        return passengerView;
    }

    public PassengerSignUpView getPassengerSignUpView() {
        return passengerSignUpView;
    }

    public PassengerLoginView getPassengerLoginView() {
        return passengerLoginView;
    }

    public OwnerSignUpView getOwnerSignUpView() {
        return ownerSignUpView;
    }

    public OwnerLoginView getOwnerLoginView() {
        return ownerLoginView;
    }

    public OwnerView getOwnerView() {
        return ownerView;
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
        return busRepository;
    }

    public BusService getBusRegistrationService() {
        return busService;
    }

    public AddSeatView getAddSeatView() {
        return addSeatView;
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

    public DriverView getDriverView() {
        return driverView;
    }

    public BusListView getBusListView() {
        return busListView;
    }

    public DriverListView getDriverListView() {
        return driverListView;
    }
}
