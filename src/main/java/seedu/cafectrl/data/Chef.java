package seedu.cafectrl.data;

import seedu.cafectrl.CafeCtrl;
import seedu.cafectrl.ui.Messages;
import seedu.cafectrl.ui.Ui;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chef {
    private final Order order;
    private final Pantry pantry;
    private final Ui ui;
    private Menu menu;
    private final DecimalFormat dollarValue = new DecimalFormat("0.00");
    private static Logger logger = Logger.getLogger(CafeCtrl.class.getName());

    public Chef(Order order, Pantry pantry, Ui ui, Menu menu) {
        this.order = order;
        this.pantry = pantry;
        this.ui = ui;
        this.menu = menu;
    }

    public void cookDish() {
        logger.info("Checking if order can be made...");
        try {
            if (!order.getIsComplete()) {
                ui.showChefMessage();
                boolean isComplete = pantry.isDishCooked(order.getIngredientList());
                logger.info("Dish cooked: " + isComplete);
                order.setComplete(isComplete);
            }
            String orderStatus = order.getIsComplete() ? Messages.COMPLETE_ORDER : Messages.INCOMPLETE_ORDER;
            String totalCost = dollarValue.format(order.getTotalOrderCost());
            ui.showOrderStatus(orderStatus, totalCost);
            pantry.calculateDishAvailability(menu);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Unsuccessful order: " + e.getMessage(), e);
            ui.showToUser(e.getMessage());
        }
    }
}
