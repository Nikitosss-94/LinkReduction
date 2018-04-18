-- Table: public."Links"

-- DROP TABLE public."Links";

CREATE TABLE public."Links"
(
  links_id integer NOT NULL,
  links_url character varying NOT NULL,
  links_realurl character varying NOT NULL,
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
  stat_id integer NOT NULL,
  stat_date date NOT NULL,
  stat_ip text NOT NULL,
  links_id integer NOT NULL,
  CONSTRAINT "Statistics_pkey" PRIMARY KEY (stat_id),
  CONSTRAINT linkstat_fkey FOREIGN KEY (links_id)
      REFERENCES public."Links" (links_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Statistics"
  OWNER TO postgres;
GRANT ALL ON TABLE public."Statistics" TO postgres;
GRANT ALL ON TABLE public."Statistics" TO public;
