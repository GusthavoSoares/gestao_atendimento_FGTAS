package pages;

import interfaces.IntLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage implements IntLoginPage {

    private final WebDriver driver;
    private final String url = System.getProperty("user.dir") +
            "\\src\\main\\resources\\index.html";

    private final By cpfBy = By.id("loginCPF");
    private final By senhaBy = By.id("senha");
    private final By alertaCpfBy = By.id("loginAlerta");

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void open() {
        driver.get(url);
    }

    @Override
    public void setCpf(String cpf) {
        driver.findElement(cpfBy).clear();
        driver.findElement(cpfBy).sendKeys(cpf);
        driver.findElement(senhaBy).click();
    }

    @Override
    public void setSenha(String senha) {
        driver.findElement(senhaBy).clear();
        driver.findElement(senhaBy).sendKeys(senha);
    }

    @Override
    public String getAlertaCpf() {
        return driver.findElement(alertaCpfBy).getText().trim();
    }

}
