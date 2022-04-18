CREATE TABLE IF NOT EXISTS public.countries
(
    id        serial NOT NULL,
    name      character varying(255),
    code      integer,
    continent character varying(255),

    PRIMARY KEY (id)
)