package com.google.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class GoogleSearchPage extends BasePage{

    public void navigateToGoogle(){
        open("https://www.google.com/");
    }


}
