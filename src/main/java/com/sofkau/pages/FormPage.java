package com.sofkau.pages;

import com.sofkau.models.Estudiante;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.sofkau.util.Gender.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FormPage extends CommonActionOnPages {


    private final Estudiante estudiante;

    /**
     * localizadores
     */


    private final By form = By.xpath("(//div[@class='avatar mx-auto white'])[2]");
    private final By practiceForm = By.xpath("(//span[normalize-space()='Practice Form'])[1]");
    private final By name = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By numero = By.id("userNumber");
    private final By direccion = By.id("currentAddress");
    private final By date = By.id("dateOfBirthInput");
    private final By subject = By.id("subjectsInput");
    private final By genderMale = By.xpath("  //label[normalize-space()='Male']");
    private final By genderFemale = By.xpath(" //label[normalize-space()='Female']");
    private final By genderOther = By.xpath("//label[normalize-space()='Other']");
    private final By sport = By.xpath(" //label[normalize-space()='Sports']");
    private final By reading = By.xpath(" //label[normalize-space()='Reading']");
    private final By music = By.xpath("//label[normalize-space()='Music']");
    private final By clickState = By.id("react-select-3-input");
    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");

    private final By btnSubmit = By.id("submit");

    public FormPage(WebDriver driver, Estudiante estudiante) {
        super(driver);
        this.estudiante = estudiante;
    }


    /**
     * metodo para hacer click
     */


    public void clickInicio() throws InterruptedException {
        scrollDown();
        click(form);
        Thread.sleep(2000);
        click(practiceForm);
        Thread.sleep(2000);
    }


    public void fillMandatotyFields() {


        clearText(name);
        typeInto(name, estudiante.getName());


        clearText(lastName);
        typeInto(lastName, estudiante.getLastName());

        clearText(email);
        typeInto(email, estudiante.getEmail());

        switch (estudiante.getGender()) {
            case FEMALE:
                click(genderFemale);
                break;
            case MALE:
                click(genderMale);
                break;
            case OTHER:
                click(genderOther);
                break;
            default:
        }
        scrollDown();
        clearText(numero);
        typeInto(numero, estudiante.getMobile());

        selectDate(date, estudiante.getDateOfBirth());

        List subjects = estudiante.getSubject();
        for (Object subjec : subjects) {
            typeInto(subject, (String) subjec);
            pressEnter(subject);
        }


        switch (estudiante.getHobbies()) {
            case SPORTS:
                click(sport);
                break;
            case READING:
                click(reading);
                break;
            case MUSIC:
                click(music);
                break;
            default:
        }


        clearText(direccion);
        typeInto(direccion, estudiante.getCurrentAddress());


        typeInto(state, estudiante.getState());
        pressEnter(state);

        typeInto(city, estudiante.getCity());
        pressEnter(city);

        pressEnter(btnSubmit);

    }


    public List<String> estaRegistrado() {
        List<String> resultado = new ArrayList<>();
        resultado.add(getText(name).trim());
        resultado.add(getText(lastName).trim());
        resultado.add(getText(genderFemale).trim());
        resultado.add(getText(numero).trim());
        return resultado;
    }

}