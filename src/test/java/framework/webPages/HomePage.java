package framework.webPages;

import org.openqa.selenium.By;
public class HomePage extends BasePage{

    private String title = "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations";

    public boolean isValidTitle(){
        return getTitle().equals(title);
    }
}
