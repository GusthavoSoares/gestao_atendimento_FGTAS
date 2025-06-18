package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage page;

    @BeforeClass
    public void setupClass() {
    }

    @BeforeMethod
    public void setupMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        page = new LoginPage(driver);
        page.open();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(description = "Deve mostrar mensagem de CPF Válido.")
    public void cpfValido() {
        page.setCpf("52998224725");
        String alerta = page.getAlertaCpf();
        Assert.assertEquals(alerta, "CPF válido!",
                "Mensagem de alerta deve indicar que o CPF é válido");
    }
    @Test(description = "Deve mostrar mensagem de CPF inválido.")
    public void cpfInvalido() {
        page.setCpf("88339384773");
        String alerta = page.getAlertaCpf();
        Assert.assertEquals(alerta, "CPF inválido!",
                "Mensagem de alerta deve indicar que o CPF é inválido");
    }
}
