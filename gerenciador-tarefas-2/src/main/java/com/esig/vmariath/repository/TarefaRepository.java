package com.esig.vmariath.repository;

import java.util.List;
import com.esig.vmariath.model.Tarefa;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

public class TarefaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Salvar ou atualizar uma tarefa
    @Transactional
    public void salvar(Tarefa tarefa) {
        if (tarefa.getId() == null) {
            entityManager.persist(tarefa); // Insere uma nova tarefa
        } else {
            entityManager.merge(tarefa); // Atualiza uma tarefa existente
        }
    }

    // Buscar uma tarefa por ID
    public Tarefa buscarPorId(Long id) {
        return entityManager.find(Tarefa.class, id);
    }

    // Listar todas as tarefas
    public List<Tarefa> listarTodas() {
        String jpql = "SELECT t FROM Tarefa t";
        TypedQuery<Tarefa> query = entityManager.createQuery(jpql, Tarefa.class);
        return query.getResultList();
    }

    // Listar tarefas por responsável
    public List<Tarefa> listarPorResponsavel(String responsavel) {
        String jpql = "SELECT t FROM Tarefa t WHERE t.responsavel = :responsavel";
        TypedQuery<Tarefa> query = entityManager.createQuery(jpql, Tarefa.class);
        query.setParameter("responsavel", responsavel);
        return query.getResultList();
    }

    // Listar tarefas por prioridade
    public List<Tarefa> listarPorPrioridade(Tarefa.Prioridade prioridade) {
        String jpql = "SELECT t FROM Tarefa t WHERE t.prioridade = :prioridade";
        TypedQuery<Tarefa> query = entityManager.createQuery(jpql, Tarefa.class);
        query.setParameter("prioridade", prioridade);
        return query.getResultList();
    }

    // Listar tarefas em andamento
    public List<Tarefa> listarEmAndamento() {
        String jpql = "SELECT t FROM Tarefa t WHERE t.situacao = 'EM_ANDAMENTO'";
        TypedQuery<Tarefa> query = entityManager.createQuery(jpql, Tarefa.class);
        return query.getResultList();
    }

    // Excluir uma tarefa
    @Transactional
    public void excluir(Long id) {
        Tarefa tarefa = entityManager.find(Tarefa.class, id);
        if (tarefa != null) {
            entityManager.remove(tarefa);
        }
    }

    // Concluir uma tarefa
    @Transactional
    public void concluirTarefa(Long id) {
        Tarefa tarefa = entityManager.find(Tarefa.class, id);
        if (tarefa != null) {
            tarefa.setSituacao(Tarefa.Situacao.CONCLUIDA);
            entityManager.merge(tarefa);
        }
    }
}