CREATE DATABASE desafioSefaz;

CREATE TABLE public.usuario (
  id bigint NOT NULL,
  nome character varying(255) NOT NULL,
  numero numeric(13,2) NOT NULL,
  data_exclusao date DEFAULT NULL,
  data_criacao date NOT NULL,
  CONSTRAINT produto_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public.telefone (
  id bigint NOT NULL,
  nome character varying(255) NOT NULL,
  email character varying(50),
  senha character varying(50) NOT NULL,
  data_criacao date NOT NULL,
  CONSTRAINT produto_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
