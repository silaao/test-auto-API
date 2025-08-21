package br.com.silasferreira.testeAutomacao.pesquisar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestPesquisarProduto {

    @Test
    public void pesquisarProduto(){
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        navegador.manage().window().maximize();
        navegador.get("https://shopee.com.br/");
        String bApp = navegador.findElement(By.cssSelector("#sll2-InformationBlockBR > div > div._87kPP > div:nth-child(5) > div.JlKgZM")).getText();
        Assertions.assertEquals("BAIXAR APP SHOPEE", bApp);
    }
}
