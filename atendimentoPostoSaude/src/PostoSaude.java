import java.util.Random;

public class PostoSaude{
    public static void main(String[] args) {
        FilaAtendimento filaAtendimento = new FilaAtendimento();
        Random random = new Random();

        for (int grupo = 1; grupo <= 10; grupo++) {
            int atendidos = grupo;

            for (int i = 0; i < atendidos; i++) {
                boolean gestante = random.nextInt(10) < 1; 
                boolean lactante = random.nextInt(10) < 1; 
                boolean necessidadeEspecial = random.nextInt(10) < 1; 
                int idade = random.nextInt(80) + 20; 

                String sexo;
                if (random.nextBoolean()) {
                    sexo = "M";
                } else {
                    sexo = "F";
                }

                Pessoa pessoa = new Pessoa("ID " + (grupo * 10 + i), sexo, idade, gestante, lactante, necessidadeEspecial);
                filaAtendimento.adicionarPessoa(pessoa);
            }
        }

        System.out.println("Fila de atendimento inicial:");
        filaAtendimento.mostrarFila();

        int numeroAtendidos = 0;
        while (numeroAtendidos < 100 && filaAtendimento.tamanhoFila() > 0) {
            Pessoa atendida = filaAtendimento.atenderPessoa();
            System.out.println("Pessoa atendida: " + atendida);
            numeroAtendidos++;
        }

        System.out.println("Pessoas não atendidas:");
        filaAtendimento.mostrarFila();
    }
}
