CREATE TABLE IF NOT EXISTS public.continents
(
    id   serial NOT NULL,
    name character varying(255),
    UNIQUE (name),
    PRIMARY KEY (id)
)