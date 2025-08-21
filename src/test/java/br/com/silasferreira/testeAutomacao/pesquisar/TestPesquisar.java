package br.com.silasferreira.testeAutomacao.pesquisar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Automatizados de Teste")
public class TestPesquisar {
    @Test
    @DisplayName("Pesquisar um produto")
    public void testPesquisarUmProduto(){
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        navegador.manage().window().maximize();
        navegador.get("https://www.kabum.com.br/");
        navegador.findElement(By.id("ins-editable-button-15380496494")).click();
        navegador.findElement(By.id("input-busca")).click();
        navegador.findElement(By.id("input-busca")).sendKeys("RTX 4060TI", Keys.ENTER);

//        navegador.findElement(By.cssSelector("a[href='https://www.kabum.com.br/hardware']")).click();
        navegador.findElement(By.cssSelector("#blocoCategoriasListagem > div > div:nth-child(1) > a")).click();
        String herdware = navegador.findElement(By.cssSelector("#blocoCategoriasListagem > div > div:nth-child(1) > a")).getText();
        Assertions.assertEquals("Hardware", herdware);




//        navegador.quit();
    }
}
