import escola.valueobjects.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TelefoneTest {

    @Test
    void naoDeveCriarTelefoneComDDDInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", "123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("1", "123456789"));
    }

    @Test
    void naoDeveCriarTelefoneComNumeroInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12", "1234"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12", "1234567890"));
    }

    @Test
    void deveCriarTelefoneComDDDENumeroValidos() {
        Telefone telefoneValido = new Telefone("12", "123456789");
        assertEquals("12", telefoneValido.getDdd());
        assertEquals("123456789", telefoneValido.getNumero());
    }
}
