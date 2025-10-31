package services.AdminServices;

public class AdminService {
    private static AdminService as = null;

    private AdminService() {

    }
    public static AdminService getInstance() {
        if (as == null) {
            as = new AdminService();
        }
        return as;
    }

}
