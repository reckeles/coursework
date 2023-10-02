package org.coursework;

import org.coursework.base.BaseGUITest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static com.codeborne.selenide.Selenide.*;

public class FirstTest extends BaseGUITest {
    @Test
    public void firsttest() throws URISyntaxException {
        $("input#form-username").sendKeys("admin");
        $("input#form-password").sendKeys("admin");
        $x("//button[@type='submit']").click();

        Assert.assertEquals($(".alert").getText(), "There is nothing assigned to you.");
    }
}
