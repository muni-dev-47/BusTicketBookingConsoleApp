package view.owner;

import util.InputUtil;
import view.View;

public class AccountAndProfileView implements View {
    private static AccountAndProfileView accountAndProfileView;

    private AccountAndProfileView() {

    }

    public static AccountAndProfileView getInstance() {
        if (accountAndProfileView == null) accountAndProfileView = new AccountAndProfileView();
        return accountAndProfileView;
    }

    @Override
    public void view() {
        String[] choices = {"🛠️ UPDATE PROFILE (CITY OR CONTACT)", "🔒 CHANGE PASSWORD", "🚪 LOGOUT"};
        int choice = InputUtil.getMenuChoice("\uD83D\uDC64 ACCOUNT & PROFILE", choices);
        switch (choice) {
            case 1:
            case 2:
            case 3:
        }
    }
}
