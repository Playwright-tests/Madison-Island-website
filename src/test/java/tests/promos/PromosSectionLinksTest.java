package tests.promos;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.promossection.PromosSection;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
public class PromosSectionLinksTest extends BaseTest {

    private PromosSection promosSection;

    @BeforeMethod
    public void prepare() {

        promosSection = new PromosSection(getPage());
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Promos")
    @Tag("Image")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Home & Decor\" image")
    public void PhysicalAndVirtualGiftCardsImage() {

        clickAndVerifyPageUrl(PromosSection::clickPhysicalAndVirtualGiftCardsImage, promosSection, URLs.HOME_DECOR_PAGE);
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Promos")
    @Tag("Image")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Shop Private Sales\" image")
    public void shopPrivateSalesImage() {

        clickAndVerifyPageUrl(PromosSection::clickShopPrivateSalesImage, promosSection, URLs.VIP_PAGE);
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Promos")
    @Tag("Image")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Travel Gear\" image")
    public void travelGearImage() {

        clickAndVerifyPageUrl(PromosSection::clickTravelGearImage, promosSection, URLs.BAGS_LUGGAGE_PAGE);
    }
}
