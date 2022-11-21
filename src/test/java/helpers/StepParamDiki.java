package helpers;

import java.util.HashMap;
import java.util.Map;

public class StepParamDiki {

    public static final Map<String, String> stepParamDiki = new HashMap<>();

    static {
        stepParamDiki.put("Test Automation", "TEST_AUTOMATION");
        stepParamDiki.put("Automatisiertes Testen", "TEST_AUTOMATION");
        stepParamDiki.put("Portfolio", "SERVICES");
        stepParamDiki.put("Services", "SERVICES");
        stepParamDiki.put("About us", "ABOUT_US");
        stepParamDiki.put("Main page", "URL_MAIN_PAGE");
        stepParamDiki.put("Job Offers page", "URL_JOB_OFFER_DE");
        stepParamDiki.put("Automatisiertes Testen page", "TEST_AUTOMATION_PAGE_TITLE");
        stepParamDiki.put("Events page", "EVENTS_PAGE_TITLE");
        stepParamDiki.put("Stellenangebote page", "JOB_OFFERS_TITLE");
        stepParamDiki.put("Test Automation page", "TEST_AUTOMATION_PAGE_TITLE");
        stepParamDiki.put("Vorname und Nachname", "text");
        stepParamDiki.put("Email", "email");
        stepParamDiki.put("Telefonnummer", "textarea");
        stepParamDiki.put("Bewerbungsschreiben", "textarea");
        }
}
