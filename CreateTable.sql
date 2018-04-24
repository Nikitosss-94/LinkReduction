-- Table: public."Links"

-- DROP TABLE public."Links";

CREATE TABLE public."Links"
(
  link_id bigint NOT NULL DEFAULT nextval('links_link_id_seq'::regclass),
  link_url character varying NOT NULL,
  CONSTRAINT "Links_pkey" PRIMARY KEY (links_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Links"
  OWNER TO postgres;

-- Table: public."Statistics"

-- DROP TABLE public."Statistics";

CREATE TABLE public."Statistics"
(
  stat_id bigint NOT NULL DEFAULT nextval('statistics_stat_id_seq'::regclass),
  stat_date date NOT NULL,
  stat_ip text NOT NULL,
  link_id bigint NOT NULL DEFAULT nextval('statistics_link_id_seq'::regclass),
  CONSTRAINT stat_pkey PRIMARY KEY (stat_id),
  CONSTRAINT linkstat_fkey FOREIGN KEY (link_id)
      REFERENCES public.links (link_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Statistics"
  OWNER TO postgres;
GRANT ALL ON TABLE public."Statistics" TO postgres;
GRANT ALL ON TABLE public."Statistics" TO public;
