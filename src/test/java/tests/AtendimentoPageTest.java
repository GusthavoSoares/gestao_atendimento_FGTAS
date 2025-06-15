package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AtendimentoPage;

import java.time.Duration;
import java.util.List;

public class AtendimentoPageTest {
    private WebDriver driver;
    private AtendimentoPage page;

    @BeforeClass
    public void setupClass() {
    }

    @BeforeMethod
    public void setupMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        page = new AtendimentoPage(driver);
        page.open();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(description = "Não deve aceitar um CNPJ inválido ")
    public void validaCNPJInvalido() {
        page.setDocumento("11111111111111");
        String alerta = page.getAlertaDocumento();
        Assert.assertEquals(alerta, "CNPJ inválido!",
                "Mensagem de alerta deve indicar que o CNPJ é inválido");
    }

    @Test(description = "Antedimento cadastrado com sucesso")
    public void criarAtendimentoComSucesso() {
        page.setNomeAtendente("Maria");
        page.selectFormaAtendimento("E-mail");
        page.selectPerfilAtendido("Trabalhador");
        page.setNomeAtendido("João");
        page.setContato("joao@example.com");
        page.setDocumento("123.456.789-09");
        page.selectTipoAtendimento("Informações sobre o Mercado de Trabalho");
        page.submitForm();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector("#dadosAtendimento p"), 0
        ));

        List<WebElement> paras = page.getResumoParagraphs();

        Assert.assertEquals(paras.size(), 7, "Deve gerar 7 parágrafos de resumo");

        // e agora valida conteúdo
        Assert.assertEquals(page.getResumoParagraph(0), "Atendente: Maria");
        Assert.assertEquals(page.getResumoParagraph(1), "Forma de Atendimento: E-mail");
        Assert.assertEquals(page.getResumoParagraph(2), "Perfil do atendido: Trabalhador");
        Assert.assertEquals(page.getResumoParagraph(3), "Nome do atendido: João");
        Assert.assertEquals(page.getResumoParagraph(4), "Contato: joao@example.com");
        Assert.assertEquals(page.getResumoParagraph(5), "Documento: 12345678909");
        Assert.assertEquals(page.getResumoParagraph(6), "Tipo de atendimento: informações sobre mercado de trabalho");
    }
}