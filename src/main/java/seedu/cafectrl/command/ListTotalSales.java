package seedu.cafectrl.command;

import seedu.cafectrl.data.Menu;
import seedu.cafectrl.data.Sales;
import seedu.cafectrl.ui.Ui;

public class ListTotalSales extends Command {
    public static final String COMMAND_WORD = "list_total_sales";
    public static final String MESSAGE_USAGE = "To show sales for all days:\n" + COMMAND_WORD;
    private Sales sales;
    private Ui ui;
    private Menu menu;

    public ListTotalSales(Sales sales, Ui ui, Menu menu) {
        this.sales = sales;
        this.ui = ui;
        this.menu = menu;
    }

    @Override
    public void execute() {
        sales.printSales(ui, menu);
    }
}