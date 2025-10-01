import java.util.ArrayList;
import java.util.List;

public class HistoricoDeCalculos {
    private List<String> operacoes = new ArrayList<>();

    public void registrar(String operacao) {
        operacoes.add(operacao);
    }

    public String getUltimaOperacao() {
        if (operacoes.isEmpty()) {
            return null;
        }
        return operacoes.get(operacoes.size() - 1);
    }

    public int getNumeroDeOperacoes() {
        return operacoes.size();
    }
}