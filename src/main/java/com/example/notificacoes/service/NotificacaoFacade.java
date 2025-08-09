package com.example.notificacoes.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.notificacoes.model.Notificacao;
import com.example.notificacoes.model.TipoNotificacao;

@Service
public class NotificacaoFacade {

    private final Map<TipoNotificacao, NotificacaoStrategy> strategies;

    public NotificacaoFacade(List<NotificacaoStrategy> strategyList) {
        this.strategies = strategyList.stream()
            .collect(Collectors.toMap(NotificacaoStrategy::getTipo, Function.identity()));
    }

    public void enviarNotificacao(Notificacao notificacao) {
        NotificacaoStrategy strategy = strategies.get(notificacao.getTipo());
        if (strategy == null) {
            throw new IllegalArgumentException("Tipo de notificação não suportado: " + notificacao.getTipo());
        }
        strategy.enviar(notificacao);
    }
}