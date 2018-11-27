package com.tws.refactoring.extract_variable;

public class BannerRender {
    void renderBanner(String platform, String browser) {
        if (isMac(platform) && isIE(browser)){
            System.out.print("Banner");
        }
    }

    boolean isMac(String platform) {
        return containIgnoreCase(platform, "MAC");
    }

    boolean isIE(String browser) {
        return containIgnoreCase(browser, "IE");
    }

    boolean containIgnoreCase(String string, String searchString) {
        return string.toUpperCase().contains(searchString);
    }

}
