package seedu.cafectrl.command;

import org.junit.jupiter.api.Test;
import seedu.cafectrl.data.Menu;
import seedu.cafectrl.data.dish.Dish;
import seedu.cafectrl.ui.Ui;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListMenuCommandTest {
    @Test
    public void execute_addTwoDishes_expectTwoDishes() {
        ArrayList<Dish> menuItems = new ArrayList<>();
        menuItems.add(new Dish("Chicken Rice", 2.50F));
        menuItems.add(new Dish("Chicken Curry", 4.30F));
        Menu menu = new Menu(menuItems);
        assertEquals(2, menu.getSize());

        ArrayList<String> commandOutput = new ArrayList<>();
        Ui ui = new Ui() {
            @Override
            public void showToUser(String... message) {
                String parseString = convertArrayToString(message, ",");
                commandOutput.add(parseString);
            }
        };

        Command listMenuCommand = new ListMenuCommand();
        listMenuCommand.execute(menu, ui);

        String actualOutput = String.join(", ", commandOutput);

        String expectedOutput = "Ah, behold, the grand menu of delights!" +
                " 1. Chicken Rice $2.50" +
                " 2. Chicken Curry $4.30";

        assertEquals(expectedOutput.trim().replaceAll(", ", " "),
                actualOutput.trim().replaceAll(", ", " "));
    }

    private static String convertArrayToString(String[] message, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (String str : message) {
            sb.append(str.toString()).append(delimiter);
        }
        return sb.substring(0, sb.length() -1);
    }
}
