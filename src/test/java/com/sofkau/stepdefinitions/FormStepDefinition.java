package com.sofkau.stepdefinitions;

import com.sofkau.models.Estudiante;
import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormStepDefinition extends WebUI {

    private Estudiante estudiante;
    private FormPage formPage;
    public static Logger LOGGER = Logger.getLogger(FormStepDefinition.class);

    private static final String ASSERTION_EXCEPTION_MESSAGE = "No son los valores esperados";

    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetup();
        LOGGER.info("inicio de la automatizacion");
    }

    @When("navega hasta la opcion de formulario")
    public void navegaHastaLaOpcionDeFormulario() throws InterruptedException {
        FormPage formPage = new FormPage(estudiante, super.driver);
        formPage.clickInicio();
    }

    @When("complete los campos con la informacion del estudiante")
    public void completeLosCamposConLaInformacionDelEstudiante() {

        generarEstudiante();


    }

    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() {
        try {
            formPage = new FormPage(estudiante, super.driver);
            formPage.fillMandatotyFields();
            Assertions.assertEquals(
                    formPage.estaRegistrado(), elementosRegistrados(),
                    String.format(ASSERTION_EXCEPTION_MESSAGE, resultado()));
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
        } finally {
            //quiteDriver();
        }

    }


    private void generarEstudiante() {
        estudiante = new Estudiante();
        estudiante.setName("yulitza");
        estudiante.setLastName("osorio");
        estudiante.setEmail("yulitzaOsorio@gmail.com");
        estudiante.setGender(Gender.MALE);
        estudiante.setMobile("3108457845");
        estudiante.setDateOfBirth("10 June 1994");
        ArrayList<String> materias = new ArrayList<>(Arrays.asList("Maths", "History", "English"));
        estudiante.setSubject(materias);
        estudiante.setHobbies(Hobbies.SPORTS);
        estudiante.setCurrentAddress("calle cucuta-norte de santander");
        estudiante.setState("NCR");
        estudiante.setCity("Delhi");

    }


    public List<String> elementosRegistrados() {
        List<String> botonResultado = new ArrayList<>();
        botonResultado.add(estudiante.getName().trim() + " " + estudiante.getLastName().trim());
        botonResultado.add(estudiante.getMobile().trim());
        System.out.println("boton resultado" + botonResultado);

        return botonResultado;

    }


    private String resultado() {
        return "\n" + formPage.estaRegistrado().toString() + "\n\r" + elementosRegistrados().toString();
    }


}
