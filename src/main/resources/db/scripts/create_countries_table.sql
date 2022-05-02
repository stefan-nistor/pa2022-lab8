CREATE TABLE IF NOT EXISTS public.countries
(
    id        serial NOT NULL,
    name      character varying(255),
    code      character varying(255),
    continent character varying(255),
    UNIQUE (name),
    PRIMARY KEY (id)
)