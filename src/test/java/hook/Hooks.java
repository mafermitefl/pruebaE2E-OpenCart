package hook;

import java.time.Duration;
import java.util.Map;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public String url = "https://www.saucedemo.com/";
	
	@Before
	public void setUp() {
		driver = setUpChromeDriver();
		driver.get(url);
		
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	public WebDriver setUpChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("autofill.profile_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);
		
		options.setExperimentalOption("prefs", prefs);
		
		//options.addArguments("--headless");
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		
		driver = new ChromeDriver(options);
		
		return driver;
	}
}