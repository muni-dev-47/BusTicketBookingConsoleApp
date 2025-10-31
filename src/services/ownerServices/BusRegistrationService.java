package services.ownerServices;

import config.ServiceLocator;
import models.Bus;
import models.Seat;
import repository.ownerRepo.BusRepository;
import java.sql.SQLException;
import java.util.List;

public class BusRegistrationService {
    private static BusRegistrationService brs;
    private static final BusRepository br = ServiceLocator.getInstance().gerBusRepo();

    private BusRegistrationService() {
    }

    public static BusRegistrationService getInstance() {
        if (brs == null) brs = new BusRegistrationService();
        return brs;
    }

    public boolean isBusNumberAvailable(String busNo) {
        return !br.findByBusRegistrationNumber(busNo);
    }

    public long handleRegisterNewBus(Bus bus, List<Seat> seats) throws SQLException {
        long id = br.save(bus);
        for (int i = 0; i < seats.size(); i++) {
            seats.get(i).setBusId(id);
            br.saveSeats(seats.get(i));
        }
        return id;
    }

}
