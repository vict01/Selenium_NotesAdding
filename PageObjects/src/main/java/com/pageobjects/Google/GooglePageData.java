package com.pageobjects.Google;

public class GooglePageData {

    public String getGoogleTittleUrl() {
        return googleTittleUrl;
    }

    public String getGoogleEmail() {
        return googleEmail;
    }

    public String getGooglePassword() {
        return googlePassword;
    }

    public void setGoogleTittleUrl(String googleTittleUrl) {
        this.googleTittleUrl = googleTittleUrl;
    }

    public void setGoogleEmail(String googleEmail) {
        this.googleEmail = googleEmail;
    }

    public void setGooglePassword(String googlePassword) {
        this.googlePassword = googlePassword;
    }


    private String googleTittleUrl = "Acceso: Cuentas de Google";
    private String googleEmail = "";
    private String googlePassword = "";

}
