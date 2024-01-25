// Definindo a classe ConteudoEducacional
data class ConteudoEducacional(val nome: String, val descricao: String)

// Definindo a interface Formacao
interface Formacao {
    val nome: String
    val nivel: String
    val conteudosEducacionais: List<ConteudoEducacional>

    fun matricular(aluno: Aluno)
}

// Definindo a classe Aluno
data class Aluno(val nome: String, val matricula: String)

// Implementando uma classe concreta que implementa a interface Formacao
class FormacaoTecnologica(
    override val nome: String,
    override val nivel: String,
    override val conteudosEducacionais: List<ConteudoEducacional>
) : Formacao {
    private val alunosMatriculados = mutableListOf<Aluno>()

    override fun matricular(aluno: Aluno) {
        alunosMatriculados.add(aluno)
        println("Aluno ${aluno.nome} matriculado na formação $nome - $nivel")
    }
}

fun main() {
    // Exemplo de uso
    val conteudo1 = ConteudoEducacional("Introdução a Kotlin", "Fundamentos da linguagem Kotlin")
    val conteudo2 = ConteudoEducacional("Desenvolvimento Android", "Construção de aplicativos Android")

    val formacaoAndroid = FormacaoTecnologica("Desenvolvimento Android", "Intermediário", listOf(conteudo1, conteudo2))

    val aluno1 = Aluno("João", "MAT123")
    formacaoAndroid.matricular(aluno1)

    val aluno2 = Aluno("Maria", "MAT456")
    formacaoAndroid.matricular(aluno2)
    
    val aluno3 = Aluno("Vinicius", "MAT620")
    formacaoAndroid.matricular(aluno3)
}
