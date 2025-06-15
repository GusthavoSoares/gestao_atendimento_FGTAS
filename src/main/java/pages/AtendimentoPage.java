package pages;

import interfaces.IntAtendimentoPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AtendimentoPage implements IntAtendimentoPage {
    private final WebDriver driver;
    private final String url = System.getProperty("user.dir") +
            "\\src\\main\\resources\\formulario.html";

    private final By nomeAtendenteBy = By.id("nomeAtendente");
    private final By formaAtendimentoBy = By.id("formaAtendimento");
    private final By perfilAtendidoBy = By.id("perfilAtendido");
    private final By nomeAtendidoBy = By.id("nomeAtendido");
    private final By contatoBy = By.id("contatoAtendido");
    private final By documentoBy = By.id("documentoAtend");
    private final By tipoAtendimentoBy = By.id("tipoAtendimento");
    private final By btnEnviarBy = By.id("btn_enviar");
    private final By alertaDocumentoBy = By.id("alertaDocumento");
    private final By resumoContainerBy = By.id("dadosAtendimento");

    public AtendimentoPage(WebDriver driver) {
        this.driver = driver;
    }



    @Override
    public void open() {
        driver.get(url);
    }



    public List<WebElement> getResumoParagraphs() {
        return driver.findElements(By.cssSelector("#dadosAtendimento p"));
    }

    public String getResumoParagraph(int index) {
        List<WebElement> pars = getResumoParagraphs();
        if (index < 0 || index >= pars.size()) {
            throw new IndexOutOfBoundsException("Resumo não contém parágrafo na posição " + index);
        }
        return pars.get(index).getText().trim();
    }

    @Override
    public void setNomeAtendente(String nome) {
        driver.findElement(nomeAtendenteBy).clear();
        driver.findElement(nomeAtendenteBy).sendKeys(nome);
    }

    @Override
    public void selectFormaAtendimento(String forma) {
        new Select(driver.findElement(formaAtendimentoBy)).selectByVisibleText(forma);
    }

    @Override
    public void selectPerfilAtendido(String perfil) {
        new Select(driver.findElement(perfilAtendidoBy)).selectByVisibleText(perfil);
    }

    @Override
    public void setNomeAtendido(String nome) {
        driver.findElement(nomeAtendidoBy).clear();
        driver.findElement(nomeAtendidoBy).sendKeys(nome);
    }

    @Override
    public void setContato(String contato) {
        driver.findElement(contatoBy).clear();
        driver.findElement(contatoBy).sendKeys(contato);
    }

    @Override
    public void setDocumento(String documento) {

        String apenasDigitos = documento.replaceAll("\\D", "");
        WebElement elem = driver.findElement(documentoBy);
        elem.clear();
        elem.sendKeys(apenasDigitos);
        elem.sendKeys("\t");
    }

    @Override
    public void selectTipoAtendimento(String tipo) {
        new Select(driver.findElement(tipoAtendimentoBy)).selectByVisibleText(tipo);
    }

    @Override
    public void submitForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(btnEnviarBy)
        );

        // scroll para trazê‑lo ao centro da viewport
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({ block: 'center' });", btn);

        // tenta clicar normalmente, com fallback em JS
        try {
            btn.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", btn);
        }
    }

    @Override
    public String getAlertaDocumento() {
        return driver.findElement(alertaDocumentoBy).getText().trim();
    }

    @Override
    public String getResumo() {
        return driver.findElement(resumoContainerBy).getText().trim();
    }
}
