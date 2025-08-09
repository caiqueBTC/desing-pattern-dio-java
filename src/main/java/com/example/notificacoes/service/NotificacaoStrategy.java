package com.example.notificacoes.service;

import com.example.notificacoes.model.Notificacao;
import com.example.notificacoes.model.TipoNotificacao;

public interface NotificacaoStrategy {

    void enviar(Notificacao notificacao);

    TipoNotificacao getTipo();
}