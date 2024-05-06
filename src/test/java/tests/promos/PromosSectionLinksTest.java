package tests.promos;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.promossection.PromosSection;
import qa.support.URLs;
import tests.base.BaseTest;

public class PromosSectionLinksTest extends BaseTest {

    private PromosSection promosSection;

    @BeforeMethod
    public void create() {

        promosSection = new PromosSection(getPage());
    }

    @Test
    public void PhysicalAndVirtualGiftCardsImage() {

        clickAndVerifyPageUrl(PromosSection::clickPhysicalAndVirtualGiftCardsImage, promosSection, URLs.HOME_DECOR_PAGE);
    }

    @Test
    public void shopPrivateSalesImage() {

        clickAndVerifyPageUrl(PromosSection::clickShopPrivateSalesImage, promosSection, URLs.VIP_PAGE);
    }

    @Test
    public void travelGearImage() {

        clickAndVerifyPageUrl(PromosSection::clickTravelGearImage, promosSection, URLs.BAGS_LUGGAGE_PAGE);
    }
}
