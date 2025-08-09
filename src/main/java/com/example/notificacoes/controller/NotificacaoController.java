package com.example.notificacoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notificacoes.model.Notificacao;
import com.example.notificacoes.service.NotificacaoFacade;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoFacade notificacaoFacade;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarNotificacao(@RequestBody NotificacaoRequestDTO request) {
        Notificacao notificacao = new Notificacao.Builder()
                .para(request.getDestinatario())
                .comTitulo(request.getTitulo())
                .comMensagem(request.getMensagem())
                .doTipo(request.getTipo())
                .construir();

        notificacaoFacade.enviarNotificacao(notificacao);

        return ResponseEntity.ok("Notificação enviada com sucesso!");
    }
}
