/*
Etapa 8 - Mock para Autorização
As regras mudaram: só se pode reembolsar consultas autorizadas. Crie uma interface AutorizadorReembolso e use Mockito para criar um mock. O mock deve simular o comportamento do autorizador e retornar falso em um dos testes. O sistema, nesses casos, deve lançar uma exceção.
*/
package org.example;

public interface AutorizadorReembolso {
    boolean estaAutorizada(Consulta consulta); // true ou false
}
// Foi criado uma classe, ReembolsoService.java,  responsável por verificar a autorização antes de realizar o cálculo.
// Uma separação com intuito de manter CalculadoraReembolso.java responsável apenas por cálculos, enquanto ReembolsoService.java controla a regra de negócio.