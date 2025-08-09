package com.example.notificacoes.model;

public class Notificacao {

    private final String destinatario;
    private final String titulo;
    private final String mensagem;
    private final TipoNotificacao tipo;

    private Notificacao(Builder builder) {
        this.destinatario = builder.destinatario;
        this.titulo = builder.titulo;
        this.mensagem = builder.mensagem;
        this.tipo = builder.tipo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public TipoNotificacao getTipo() {
        return tipo;
    }

    public static class Builder {
        private String destinatario;
        private String titulo;
        private String mensagem;
        private TipoNotificacao tipo;

        public Builder para(String destinatario) {
            this.destinatario = destinatario;
            return this;
        }

        public Builder comTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder comMensagem(String mensagem) {
            this.mensagem = mensagem;
            return this;
        }

        public Builder doTipo(TipoNotificacao tipo) {
            this.tipo = tipo;
            return this;
        }

        public Notificacao construir() {
            return new Notificacao(this);
        }
    }
}