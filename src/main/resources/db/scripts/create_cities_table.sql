CREATE TABLE IF NOT EXISTS public.cities
(
    id        serial                 NOT NULL,
    country   character varying(255) NOT NULL,
    name      character varying(255) NOT NULL,
    capital   boolean,
    latitude  numeric,
    longitude numeric,

    PRIMARY KEY (id)

)