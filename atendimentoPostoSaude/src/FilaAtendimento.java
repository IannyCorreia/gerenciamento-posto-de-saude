import java.util.ArrayDeque;
import java.util.Deque;

public class FilaAtendimento{
    private Deque<Pessoa> filaPessoas;

    public FilaAtendimento() {
        this.filaPessoas = new ArrayDeque<>();
    }

    public void adicionarPessoa(Pessoa novaPessoa) {
        Deque<Pessoa> filaTemporaria = new ArrayDeque<>();
        boolean adicionada = false;

        while (!filaPessoas.isEmpty()) {
            Pessoa pessoaNaFila = filaPessoas.pollFirst();
            if (!adicionada && novaPessoa.calcularPrioridade() > pessoaNaFila.calcularPrioridade()) {
                filaTemporaria.addLast(novaPessoa);
                adicionada = true;
            }
            filaTemporaria.addLast(pessoaNaFila);
        }
        if (!adicionada) {
            filaTemporaria.addLast(novaPessoa);
        }

        filaPessoas = filaTemporaria;
    }

    public Pessoa atenderPessoa() {
        return filaPessoas.pollFirst();
    }

    public void mostrarFila() {
        for (Pessoa pessoa : filaPessoas) {
            System.out.println(pessoa);
        }
    }

    public int tamanhoFila() {
        return filaPessoas.size();
    }
}
