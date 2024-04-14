package steps;

import hooks.Hooks;
import io.cucumber.java.ru.И;

public class ExampleSteps {
 
    @И("шаг фрагмента")
    public void loginTest(){
        System.out.println("шаг фрагмента");
        Hooks.softAssertions.fail("test fail");
    }

    @И("шаг")
    public void Step() {
        System.out.println("шаг");
    }

}