package pages;

import commons.BaseCommons;
import org.junit.jupiter.api.Assertions;

public class LeverAppFormPage extends BaseCommons {

    public LeverAppFormPage checkIsOpenedLeverApplicationPage() {
        Assertions.assertEquals("Insider open positions | Insider", getTitle(), "Not on Lever App page!");
        return this;
    }
}
