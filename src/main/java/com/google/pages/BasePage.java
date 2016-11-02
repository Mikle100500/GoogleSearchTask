package com.google.pages;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.*;


public class BasePage {

    public ElementsCollection answers = $$(".g");

    public void navigateToGoogle(){
        open("https://www.google.com/");
    }

    public void search(String query){
        $("#lst-ib").setValue(query).submit();
    }

    public int countAnswersPerPage() {
        return answers.size();
    }

    public String getTitle(){
        return title();
    }
}
