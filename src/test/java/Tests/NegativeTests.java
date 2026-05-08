package Tests;

import Base.Base;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests extends Base {

    @Test
    public void TC_N01_loginConContrasenaIncorrecta() {
        LoginPage login = new LoginPage(driver, wait);

        login.login("Admin", "contrasenaIncorrecta");
        String mensaje = login.getErrorMessage();

        Assert.assertEquals(mensaje, "Invalid credentials",
                "TC-N01 FALLO: Mensaje de error inesperado. Obtenido: " + mensaje);
    }

    @Test
    public void TC_N02_loginConCamposVacios() {
        LoginPage login = new LoginPage(driver, wait);

        login.clickLogin();
        int count = login.getRequiredMessageCount();

        Assert.assertTrue(count >= 2,
                "TC-N02 FALLO: Se esperaban 2+ mensajes 'Required', se obtuvieron: " + count);
    }

    @Test
    public void TC_N03_loginConUsuarioInexistente() {
        LoginPage login = new LoginPage(driver, wait);

        login.login("usuarioQueNoExiste", "admin123");
        String mensaje = login.getErrorMessage();

        Assert.assertTrue(mensaje.contains("Invalid credentials"),
                "TC-N03 FALLO: Mensaje esperado 'Invalid credentials', obtenido: " + mensaje);
    }

    @Test
    public void TC_N04_loginConCaracteresEspecialesEnUsername() {
        LoginPage login = new LoginPage(driver, wait);

        login.login("' OR '1'='1", "admin123");
        String mensaje = login.getErrorMessage();

        Assert.assertTrue(mensaje.contains("Invalid credentials"),
                "TC-N04 FALLO: El sistema no rechazo el input especial correctamente. Mensaje: " + mensaje);
    }
}
