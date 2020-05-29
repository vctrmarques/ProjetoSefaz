CREATE DATABASE desafioSefaz;

CREATE TABLE public.usuario (
  id bigint NOT NULL,
  nome character varying(255) NOT NULL,
  email character varying(50),
  senha character varying(50) NOT NULL,
  data_criacao date NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public.telefone (
  id bigint NOT NULL,
  ddd character varying(3) NOT NULL,
  numero character varying(20),
  tipo character varying(20) NOT NULL,
  data_criacao date NOT NULL,
  CONSTRAINT telefone_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
