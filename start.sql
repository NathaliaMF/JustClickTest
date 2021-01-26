
CREATE TABLE public.urls (
    id integer NOT NULL,
    element character varying,
    directions character varying,
    maximum integer,
    use integer
);

ALTER TABLE public.urls OWNER TO postgres;

ALTER TABLE ONLY public.urls
    ADD CONSTRAINT "URLS_pkey" PRIMARY KEY (id);

INSERT INTO public.urls(
	id, element, directions, maximum, use)
	VALUES (1, 'hola', 'https://www.google.com/search?q=hola', 10, 0);

INSERT INTO public.urls(
	id, element, directions, maximum, use)
	VALUES (2, 'mundo', 'https://www.google.com/search?q=mundo', 10, 0);
	
INSERT INTO public.urls(
	id, element, directions, maximum, use)
	VALUES (3, 'justclick', 'https://www.google.com/search?q=justclick', 10, 0);
	
INSERT INTO public.urls(
	id, element, directions, maximum, use)
	VALUES (4, 'prueba', 'https://www.google.com/search?q=prueba', 10, 0);
