class Aluno {
    String nome;
    int matricula;
    char sexo;

    public Aluno(String nome, int matricula, char sexo) {
        this.nome = nome;
        this.matricula = matricula;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", sexo=" + sexo +
                '}';
    }
}

class PilhaEstatica {
    private int tamanhoMaximo;
    private int topo;
    private Aluno[] elementos;

    public PilhaEstatica(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.elementos = new Aluno[tamanhoMaximo];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == tamanhoMaximo - 1;
    }

    public void push(Aluno elemento) {
        if (!isFull()) {
            topo++;
            elementos[topo] = elemento;
        } else {
            System.out.println("Pilha cheia");
        }
    }

    public Aluno pop() {
        if (!isEmpty()) {
            Aluno elemento = elementos[topo];
            topo--;
            return elemento;
        } else {
            System.out.println("Pilha vazia");
            return null;
        }
    }

    public Aluno topo() {
        if (!isEmpty()) {
            return elementos[topo];
        } else {
            System.out.println("Pilha vazia");
            return null;
        }
    }

    public void destroy() {
        topo = -1;
    }
}

public class ControleAlunos {
    public static void main(String[] args) {
        PilhaEstatica pilhaFeminina = new PilhaEstatica(20);
        PilhaEstatica pilhaMasculina = new PilhaEstatica(20);

        // Simulando entrada de dados
        for (int i = 0; i < 20; i++) {
            // Aqui você pode adicionar a lógica para entrada de dados do usuário
            // Estou adicionando dados de exemplo
            String nome = "Aluno" + (i + 1);
            int matricula = i + 1000;
            char sexo = (i % 2 == 0) ? 'F' : 'M'; // Alternando entre sexo masculino e feminino

            Aluno aluno = new Aluno(nome, matricula, sexo);
            if (sexo == 'F') {
                pilhaFeminina.push(aluno);
            } else {
                pilhaMasculina.push(aluno);
            }
        }

        // Desempilhando e mostrando os alunos
        System.out.println("Alunos do sexo feminino:");
        while (!pilhaFeminina.isEmpty()) {
            System.out.println(pilhaFeminina.pop());
        }

        System.out.println("Alunos do sexo masculino:");
        while (!pilhaMasculina.isEmpty()) {
            System.out.println(pilhaMasculina.pop());
        }
    }
}
