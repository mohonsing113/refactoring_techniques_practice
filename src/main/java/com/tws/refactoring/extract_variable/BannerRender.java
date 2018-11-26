package com.tws.refactoring.extract_variable;

public class BannerRender {
    void renderBanner(String platform, String browser) {
        if ((platform.toUpperCase().contains("MAC")) &&
                (browser.toUpperCase().contains("IE"))) {
            System.out.print("Banner");
        }


    }


}
