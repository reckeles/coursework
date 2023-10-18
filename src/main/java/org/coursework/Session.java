package org.coursework;

import org.coursework.config.EnvConfig;
import org.coursework.testbed.BaseTestbed;
import org.coursework.testbed.TestbedGrid;
import org.coursework.testbed.TestbedLocal;
import org.openqa.selenium.WebDriver;

public class Session {
    static final private ThreadLocal<Session> _instance = new ThreadLocal<>();

    private BaseTestbed _testbed;
    private WebDriver _webdriver;
//    private final boolean HEADLESS_FLAG = Boolean.valueOf(getCustomProperty("headless", "true"));
//    private final String WEB_BROWSER = getCustomProperty("browser", "chrome");

    static public Session get() {
        if (_instance.get() == null)
            _instance.set(new Session());
        return _instance.get();
    }

    public WebDriver webdriver() {
        if (this._webdriver == null) {
            if ("local".equalsIgnoreCase(EnvConfig.TESTBED.value)) {
                // Create local testbed
                this._testbed = new TestbedLocal();
            } else if ("grid".equalsIgnoreCase(EnvConfig.TESTBED.value)) {
                // Create grid testbed
                this._testbed = new TestbedGrid();
            } else
                throw new RuntimeException("Unsupported testbed: " + EnvConfig.TESTBED.value);

            this._webdriver = this._testbed.createDriver();
            this._webdriver.manage().window().maximize();
        }

        return this._webdriver;
    }
//    public WebDriver webdriver() {
//        if (this._webdriver == null) {
//            if ("chrome".equalsIgnoreCase(WEB_BROWSER)) {
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("disable-default-apps");
//                options.addArguments("disable-extensions");
//                Map<String, Object> preferences = new HashMap<>();
//                preferences.put("browser.show_home_button", false);
//                options.addArguments("start-maximized");
//                if (HEADLESS_FLAG) {
//                    options.addArguments("--headless");
//                    options.addArguments("--no-sandbox");
//                    options.addArguments("start-maximized");
//                }
//                this._webdriver = new ChromeDriver(options);
//                this._webdriver.manage().window().maximize();
//            }
//            else if ("firefox".equalsIgnoreCase(WEB_BROWSER)) {
//                FirefoxOptions options = new FirefoxOptions();
//                options.addArguments("disable-default-apps");
//                options.addArguments("disable-extensions");
//                Map<String, Object> preferences = new HashMap<>();
//                preferences.put("browser.show_home_button", false);
//                options.addArguments("start-maximized");
//                if (HEADLESS_FLAG) {
//                    options.addArguments("--headless");
//                    options.addArguments("--no-sandbox");
//                    options.addArguments("start-maximized");
//                }
//                this._webdriver = new FirefoxDriver(options);
//                this._webdriver.manage().window().maximize();
//            }
//            else {
//                throw new RuntimeException("Unsupported browser: " + WEB_BROWSER);
//            }
//        }
//        return this._webdriver;
//    }

    public void close() {
        if (this._webdriver != null) {
            this._webdriver.quit();
            this._webdriver = null;
        }
    }

    private Session() {
        Runtime.getRuntime().addShutdownHook(new Thread(Session.this::close));
    }
}
