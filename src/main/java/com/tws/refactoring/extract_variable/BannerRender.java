package com.tws.refactoring.extract_variable;

public class BannerRender {
    void renderBanner(String platform, String browser) {
        if (containIgnoreCase(platform, "MAC") &&
                (containIgnoreCase(browser, "IE"))) {
            System.out.print("Banner");
        }

    }

    boolean containIgnoreCase(String string, String searchString){
        return string.toUpperCase().contains(searchString);
    }


}
