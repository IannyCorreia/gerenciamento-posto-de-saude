public class Pessoa{
    private String id;
    private String sexo;
    private int idade;
    private boolean gestante;
    private boolean lactante;
    private boolean necessidadeEspecial;

    public Pessoa(String id, String sexo, int idade, boolean gestante, boolean lactante, boolean necessidadeEspecial) {
        this.id = id;
        this.sexo = sexo;
        this.idade = idade;
        this.gestante = gestante;
        this.lactante = lactante;
        this.necessidadeEspecial = necessidadeEspecial;
    }

    public int calcularPrioridade() {
        if (gestante || lactante) {
            return 3;
        } else if (necessidadeEspecial) {
            return 2;
        } else if (idade >= 60) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "ID: " + id + ", Sexo: " + sexo + ", Idade: " + idade + ", Gestante: " + gestante +
                ", Lactante: " + lactante + ", Necessidade Especial: " + necessidadeEspecial;
    }
}
