package com.example.notificacoes.service.impl;

import org.springframework.stereotype.Service;
import com.example.notificacoes.model.Notificacao;
import com.example.notificacoes.model.TipoNotificacao;
import com.example.notificacoes.service.NotificacaoStrategy;

@Service
public class EmailStrategyImpl implements NotificacaoStrategy {

    @Override
    public void enviar(Notificacao notificacao) {
        System.out.println("Enviando EMAIL para: " + notificacao.getDestinatario());
    }

    @Override
    public TipoNotificacao getTipo() {
        return TipoNotificacao.EMAIL;
    }
}