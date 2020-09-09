package com.pageobjects.Gbh;

public class GbhPageData  {

    public String getUrl() {
        return url;
    }

    public String setUrl(String url) {
        return this.url = url;
    }

    public String getGbhTittleUrl() {
        return gbhTittleUrl;
    }

    public String setGbhTittleUrl(String gbhTittleUrl) {
        return this.gbhTittleUrl = gbhTittleUrl;
    }

    public String getNoteText() {
        return noteText;
    }

    public String setNoteText(String noteText) {
        this.noteText = noteText;
        return noteText;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String setNoteTitle(String noteTitle) {
        return this.noteTitle = noteTitle;
    }

    private String url = "https://gbhqatest.firebaseapp.com/";
    private String gbhTittleUrl = "GBH QA Onboarding test";
    private String noteTitle = "To get up early";
    private String noteText = "Tomorrow we must get up early if we want to avoid the rush hour";

}
