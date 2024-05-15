package qa.pageobject.minicart;

import com.microsoft.playwright.Page;
import lombok.Getter;
import qa.base.BasePage;

@Getter
public class MiniCart extends BasePage {

    private final String wrapperSelector;

    public MiniCart(Page page) {

        super(page);

        wrapperSelector = ".minicart-wrapper";
    }
}
