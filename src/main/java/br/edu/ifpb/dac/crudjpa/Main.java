/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.crudjpa;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jose2
 */
public class Main {

    public static void main(String[] args) {
        System.err.println("iniciando");
        // criando objetos tipo pessoa
        Pessoa chaves = Pessoa.of("chaves", "caves@hotmail.com");
        Pessoa chiquinha = Pessoa.of("chiquinha", "chiquinha@hotmail.com");
        Pessoas pessoas = new Pessoas();
        /* cliando um objeto pessoas que twm os métodos para manipular
         objetos do tipo pessoa
         */
        // salvando pessoas
        pessoas.novaEntidade(chaves);
        pessoas.novaEntidade(chiquinha);

        // fazer busca por pessoas
        List<Pessoa> busca = pessoas.listarTodos();
        busca.forEach(System.out::println);

        // atualizar pessoa
        Pessoa pessoa = busca.get(0);

        pessoa.setNome("Caves do 8");

        pessoas.atualizarEntidade(pessoa);
        pessoa = pessoas.buscarEntidade(pessoa.getId());
        System.err.println("pessoa atualizada " + pessoa.toString());

        // remover pessoa
        pessoas.excluirEntidade(pessoa);
        // listando as pessoas depois da exclusão
        pessoas.listarTodos().forEach(System.out::println);
        
        pessoas.fecharEntityManager();

    }
}
