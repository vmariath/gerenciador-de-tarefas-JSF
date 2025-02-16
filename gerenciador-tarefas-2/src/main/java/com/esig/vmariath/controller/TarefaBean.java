package com.esig.vmariath.controller;

import java.util.List;
import com.esig.vmariath.model.Tarefa;
import com.esig.vmariath.repository.TarefaRepository;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named // Torna a classe gerenciada pelo CDI e acessível nas páginas JSF
@ViewScoped // Define o escopo do bean como ViewScoped (mantém o estado durante a interação com a mesma página)
public class TarefaBean {

    @Inject
    private TarefaRepository tarefaRepository;

    private Tarefa tarefa;
    private List<Tarefa> tarefas;
    private String filtroResponsavel;
    private Tarefa.Prioridade filtroPrioridade;

    @PostConstruct
    public void init() {
        tarefa = new Tarefa(); // Inicializa uma nova tarefa
        tarefas = tarefaRepository.listarTodas(); // Carrega todas as tarefas ao iniciar
    }

    // Getters e Setters
    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public String getFiltroResponsavel() {
        return filtroResponsavel;
    }

    public void setFiltroResponsavel(String filtroResponsavel) {
        this.filtroResponsavel = filtroResponsavel;
    }

    public Tarefa.Prioridade getFiltroPrioridade() {
        return filtroPrioridade;
    }

    public void setFiltroPrioridade(Tarefa.Prioridade filtroPrioridade) {
        this.filtroPrioridade = filtroPrioridade;
    }

    // Métodos de ação
    public void salvar() {
        tarefaRepository.salvar(tarefa);
        tarefa = new Tarefa(); // Limpa o formulário após salvar
        tarefas = tarefaRepository.listarTodas(); // Atualiza a lista de tarefas
    }

    public void excluir(Long id) {
        tarefaRepository.excluir(id);
        tarefas = tarefaRepository.listarTodas(); // Atualiza a lista de tarefas
    }

    public void concluirTarefa(Long id) {
        tarefaRepository.concluirTarefa(id);
        tarefas = tarefaRepository.listarTodas(); // Atualiza a lista de tarefas
    }

    public void filtrar() {
        if (filtroResponsavel != null && !filtroResponsavel.isEmpty() && filtroPrioridade != null) {
            // Filtra por responsável e prioridade
            tarefas = tarefaRepository.listarPorResponsavelEPorPrioridade(filtroResponsavel, filtroPrioridade);
        } else if (filtroResponsavel != null && !filtroResponsavel.isEmpty()) {
            // Filtra apenas por responsável
            tarefas = tarefaRepository.listarPorResponsavel(filtroResponsavel);
        } else if (filtroPrioridade != null) {
            // Filtra apenas por prioridade
            tarefas = tarefaRepository.listarPorPrioridade(filtroPrioridade);
        } else {
            // Nenhum filtro, carrega todas as tarefas
            tarefas = tarefaRepository.listarTodas();
        }
    }

    public void limparFiltros() {
        filtroResponsavel = null;
        filtroPrioridade = null;
        tarefas = tarefaRepository.listarTodas(); // Recarrega todas as tarefas
    }
}
