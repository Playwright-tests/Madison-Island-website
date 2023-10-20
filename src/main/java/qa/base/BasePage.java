package qa.base;

import com.microsoft.playwright.Page;

public class BasePage {

    private Page page;

    public BasePage(Page page) {

        this.page = page;
    }

    public Page getPage() {

        return page;
    }

}
