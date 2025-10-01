import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraIntegracaoTest {

    private Calculadora calculadora;
    private HistoricoDeCalculos historico;

    @BeforeEach
    void setUp() {
        // 1. Prepara o ambiente do teste
        // Instancia os dois componentes que serão integrados
        historico = new HistoricoDeCalculos();
        calculadora = new Calculadora(historico);
    }

    @Test
    void deveSomarESalvarNoHistoricoCorretamente() {
        // 2. Ação (Action)
        // Chama o método da calculadora, que por sua vez deve chamar o histórico
        int resultado = calculadora.somar(10, 5);

        // 3. Verificação (Verification)
        // Verifica se o resultado da calculadora está correto
        assertEquals(15, resultado, "O resultado da soma deve ser 15");

        // Verifica se a integração com o histórico funcionou
        assertEquals(1, historico.getNumeroDeOperacoes(), "Deveria haver 1 operação registrada");
        assertEquals("10 + 5 = 15", historico.getUltimaOperacao(), "A descrição da operação no histórico está incorreta");
    }

    @Test
    void deveMultiplicarESalvarNoHistoricoCorretamente() {
        // 2. Ação (Action)
        // Chama o método da calculadora, que por sua vez deve chamar o histórico
        int resultado = calculadora.multiplicar(10, 5);

        // 3. Verificação (Verification)
        // Verifica se o resultado da calculadora está correto
        assertEquals(50, resultado, "O resultado da soma deve ser 50");

        // Verifica se a integração com o histórico funcionou
        assertEquals(1, historico.getNumeroDeOperacoes(), "Deveria haver 1 operação registrada");
        assertEquals("10 * 5 = 50", historico.getUltimaOperacao(), "A descrição da operação no histórico está incorreta");
    }

    @Test
    void deveRealizarMultiplasOperacoesEIntegrarComHistorico() {
        // Ação
        calculadora.somar(10, 5);
        calculadora.subtrair(20, 10);

        // Verificação
        assertEquals(2, historico.getNumeroDeOperacoes(), "Deveriam haver 2 operações registradas");
        assertEquals("20 - 10 = 10", historico.getUltimaOperacao(), "A última operação registrada está incorreta");
    }
}