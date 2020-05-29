package sample.project.utils;

/**
 * Created by AnilK on 11/04/2019.
 */
public enum ClassNames {
    CONFIGURATION("Configuration"),
    DRIVER("Driver"),
    BROWSERSTACK("uk.gov.ho.cts.utils.BrowserStackSerenityDriver"),
    UDT("uk.gov.ho.cts.utils.UniqueDataUtils");

    private String className;

    ClassNames(String s) {
        this.className = s;
    }

    public String getClassName() {
        return this.className;
    }


}
