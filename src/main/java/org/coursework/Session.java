package org.coursework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class Session {
    static final private ThreadLocal<Session> _instance = new ThreadLocal<>();
    private WebDriver _webdriver;
    private final boolean HEADLESS_FLAG = setHeadlessFlag();
    private final String WEB_BROWSER = setWebBrowser();

    static public Session get() {
        if (_instance.get() == null)
            _instance.set(new Session());
        return _instance.get();
    }

    public WebDriver webdriver() {
        if (this._webdriver == null) {
            if ("chrome".equalsIgnoreCase(WEB_BROWSER)) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-default-apps");
                options.addArguments("disable-extensions");
                Map<String, Object> preferences = new HashMap<>();
                preferences.put("browser.show_home_button", false);
                options.addArguments("start-maximized");
                if (HEADLESS_FLAG) {
                    options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("start-maximized");
                }
                this._webdriver = new ChromeDriver(options);
                this._webdriver.manage().window().maximize();
            }
            if ("firefox".equalsIgnoreCase(WEB_BROWSER)) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("disable-default-apps");
                options.addArguments("disable-extensions");
                Map<String, Object> preferences = new HashMap<>();
                preferences.put("browser.show_home_button", false);
                options.addArguments("start-maximized");
                if (HEADLESS_FLAG) {
                    options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("start-maximized");
                }
                this._webdriver = new FirefoxDriver(options);
                this._webdriver.manage().window().maximize();
            }
        }
        return this._webdriver;
    }

    public void close() {
        if (this._webdriver != null) {
            this._webdriver.quit();
            this._webdriver = null;
        }
    }

    private Session() {
        Runtime.getRuntime().addShutdownHook(new Thread(Session.this::close));
    }

    //TODO - refactor if has time
    private boolean setHeadlessFlag() {
        String property = System.getProperty("headless");
        if (property == null) {
            return true;
        }
        return Boolean.valueOf(property);
    }

    private String setWebBrowser() {
        String property = System.getProperty("browser");
        String chrome = "chrome";
        String firefox = "firefox";
        if (property == null) {
            return chrome;
        } else if (property.equalsIgnoreCase(chrome) || property.equalsIgnoreCase(firefox)) {
            return property;
        }
        return chrome;
    }
}
