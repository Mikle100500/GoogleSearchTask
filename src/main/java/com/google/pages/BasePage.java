package com.google.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class BasePage {

    public void search(String query){
        $("#lst-ib").setValue(query).submit();
    }

}
