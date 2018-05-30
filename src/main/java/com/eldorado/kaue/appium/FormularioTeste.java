package com.eldorado.kaue.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;

public class FormularioTeste {
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "NZAA470170");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\kaue.pereira\\eclipse-workspace\\AppiumTeste\\src\\main\\resources\\CTAppium-1-1.apk");
	    //desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\kauef\\eclipse-workspace\\appiumSample\\src\\main\\resources\\CTAppium-1-1.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionar formulario
	    List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
	    elementosEncontrados.get(1).click();
	    
	    //Escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Kaue");
	    
	    //checar nome escrito
	    String text = campoNome.getText();
	    Assert.assertEquals("Kaue", text);
	    
	    driver.quit();
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "NZAA470170");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
	    //desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\kaue.pereira\\eclipse-workspace\\AppiumTeste\\src\\main\\resources\\CTAppium-1-1.apk");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\kauef\\eclipse-workspace\\appiumSample\\src\\main\\resources\\CTAppium-1-1.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionar formulario
	    List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
	    elementosEncontrados.get(1).click();
	    
	    //clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //selecionar a opcao desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
	    
	    //verificar a opcao selecionada
	    String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    Assert.assertEquals("PS4", text);
	    	    
	    driver.quit();
	}


}
