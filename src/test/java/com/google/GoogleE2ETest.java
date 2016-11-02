package com.google;

import com.google.pages.SearchResaultPage;
import org.junit.Test;

/**
 Automate:
 1 visit http://google.com/ncr
 2 search: “Selenium automates browsers”
 3 check that 10 results are found
 4 check the text “Selenium automates browsers” in 1st result
 5 follow the link in 1st result
 6 check that selenium official page is loaded

 Hint:

 You should follow the following strategy:

 - You will do only a smoke coverage and you most probably will not reuse "steps" in other tests.
 (Or you don't know will you reuse or not)

 */
public class GoogleE2ETest {

    public SearchResaultPage page = new SearchResaultPage();

    @Test
    public void testGoogleSearch(){
        //precondition
        page.navigateToGoogle();
        page.search("Selenium automates browsers");

        assert page.countAnswersPerPage() == 10;

        page.clickLink("Selenium automates browsers");

        assert page.getTitle().equals("http://docs.seleniumhq.org/");
    }
}
