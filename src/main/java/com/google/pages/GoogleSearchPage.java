package com.google.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class GoogleSearchPage {

    public void navigateToGoogle(){
        open("https://www.google.com/");
    }

    public void setQuery(String query){
        $("#lst-ib").setValue(query).submit();
    }
}
