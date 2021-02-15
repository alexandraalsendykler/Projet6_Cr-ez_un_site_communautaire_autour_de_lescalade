--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 13.1

-- Started on 2021-02-09 19:18:43

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 213 (class 1259 OID 27026)
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    id_commentaire integer NOT NULL,
    id_site integer NOT NULL,
    id_utilisateur integer NOT NULL,
    contenu character varying(300) NOT NULL
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 27024)
-- Name: commentaire_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commentaire_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commentaire_id_seq OWNER TO postgres;

--
-- TOC entry 2902 (class 0 OID 0)
-- Dependencies: 212
-- Name: commentaire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id_commentaire;


--
-- TOC entry 209 (class 1259 OID 27010)
-- Name: longueur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.longueur (
    id_longueur integer NOT NULL,
    id_voie integer NOT NULL,
    cotation character varying(10) NOT NULL
);


ALTER TABLE public.longueur OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 27008)
-- Name: longueur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.longueur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.longueur_id_seq OWNER TO postgres;

--
-- TOC entry 2903 (class 0 OID 0)
-- Dependencies: 208
-- Name: longueur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.longueur_id_seq OWNED BY public.longueur.id_longueur;


--
-- TOC entry 218 (class 1259 OID 27047)
-- Name: reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation (
    id_reservation integer NOT NULL,
    id_topo integer NOT NULL,
    id_utilisateur integer NOT NULL,
    statut character varying(50) NOT NULL
);


ALTER TABLE public.reservation OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 27045)
-- Name: reservation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_id_seq OWNER TO postgres;

--
-- TOC entry 2904 (class 0 OID 0)
-- Dependencies: 217
-- Name: reservation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reservation_id_seq OWNED BY public.reservation.id_reservation;


--
-- TOC entry 205 (class 1259 OID 26994)
-- Name: secteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.secteur (
    id_secteur integer NOT NULL,
    id_site integer NOT NULL,
    nom character varying(100) NOT NULL
);


ALTER TABLE public.secteur OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 26992)
-- Name: secteur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.secteur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.secteur_id_seq OWNER TO postgres;

--
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 204
-- Name: secteur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.secteur_id_seq OWNED BY public.secteur.id_secteur;


--
-- TOC entry 203 (class 1259 OID 26983)
-- Name: site; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.site (
    id_site integer NOT NULL,
    nom character varying(100) NOT NULL,
    description character varying(400) NOT NULL,
    coordonneesgps character varying(10) NOT NULL,
    officiel boolean NOT NULL
);


ALTER TABLE public.site OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 26981)
-- Name: site_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.site_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.site_id_seq OWNER TO postgres;

--
-- TOC entry 2906 (class 0 OID 0)
-- Dependencies: 202
-- Name: site_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.site_id_seq OWNED BY public.site.id_site;


--
-- TOC entry 215 (class 1259 OID 27034)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    id_topo integer NOT NULL,
    id_utilisateur integer NOT NULL,
    region character varying(100) NOT NULL,
    disponibilite boolean NOT NULL,
    nom text,
    description text,
    date_parution date
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 27032)
-- Name: topo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.topo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topo_id_seq OWNER TO postgres;

--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 214
-- Name: topo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id_topo;


--
-- TOC entry 216 (class 1259 OID 27040)
-- Name: topo_site; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo_site (
    id_topo integer NOT NULL,
    id_site integer NOT NULL
);


ALTER TABLE public.topo_site OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 27018)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    id_utilisateur integer NOT NULL,
    pseudo character varying(50),
    membre boolean,
    email character varying(50) NOT NULL,
    motdepasse character varying(255) NOT NULL
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 27016)
-- Name: utilisateur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.utilisateur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.utilisateur_id_seq OWNER TO postgres;

--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 210
-- Name: utilisateur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.utilisateur_id_seq OWNED BY public.utilisateur.id_utilisateur;


--
-- TOC entry 207 (class 1259 OID 27002)
-- Name: voie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.voie (
    id_voie integer NOT NULL,
    id_secteur integer NOT NULL,
    nom character varying(50) NOT NULL,
    cotation character varying(10) NOT NULL,
    hauteur real,
    nombredepoint integer
);


ALTER TABLE public.voie OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 27000)
-- Name: voie_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.voie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.voie_id_seq OWNER TO postgres;

--
-- TOC entry 2909 (class 0 OID 0)
-- Dependencies: 206
-- Name: voie_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.voie_id_seq OWNED BY public.voie.id_voie;


--
-- TOC entry 2740 (class 2604 OID 27029)
-- Name: commentaire id_commentaire; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN id_commentaire SET DEFAULT nextval('public.commentaire_id_seq'::regclass);


--
-- TOC entry 2738 (class 2604 OID 27013)
-- Name: longueur id_longueur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.longueur ALTER COLUMN id_longueur SET DEFAULT nextval('public.longueur_id_seq'::regclass);


--
-- TOC entry 2742 (class 2604 OID 27050)
-- Name: reservation id_reservation; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation ALTER COLUMN id_reservation SET DEFAULT nextval('public.reservation_id_seq'::regclass);


--
-- TOC entry 2736 (class 2604 OID 26997)
-- Name: secteur id_secteur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur ALTER COLUMN id_secteur SET DEFAULT nextval('public.secteur_id_seq'::regclass);


--
-- TOC entry 2735 (class 2604 OID 26986)
-- Name: site id_site; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site ALTER COLUMN id_site SET DEFAULT nextval('public.site_id_seq'::regclass);


--
-- TOC entry 2741 (class 2604 OID 27037)
-- Name: topo id_topo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo ALTER COLUMN id_topo SET DEFAULT nextval('public.topo_id_seq'::regclass);


--
-- TOC entry 2739 (class 2604 OID 27021)
-- Name: utilisateur id_utilisateur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur ALTER COLUMN id_utilisateur SET DEFAULT nextval('public.utilisateur_id_seq'::regclass);


--
-- TOC entry 2737 (class 2604 OID 27005)
-- Name: voie id_voie; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie ALTER COLUMN id_voie SET DEFAULT nextval('public.voie_id_seq'::regclass);


--
-- TOC entry 2754 (class 2606 OID 27031)
-- Name: commentaire commentaire_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pk PRIMARY KEY (id_commentaire);


--
-- TOC entry 2750 (class 2606 OID 27015)
-- Name: longueur longueur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.longueur
    ADD CONSTRAINT longueur_pk PRIMARY KEY (id_longueur);


--
-- TOC entry 2760 (class 2606 OID 27052)
-- Name: reservation reservation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pk PRIMARY KEY (id_reservation);


--
-- TOC entry 2746 (class 2606 OID 26999)
-- Name: secteur secteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT secteur_pk PRIMARY KEY (id_secteur);


--
-- TOC entry 2744 (class 2606 OID 26991)
-- Name: site site_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT site_pk PRIMARY KEY (id_site);


--
-- TOC entry 2756 (class 2606 OID 27039)
-- Name: topo topo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pk PRIMARY KEY (id_topo);


--
-- TOC entry 2758 (class 2606 OID 27044)
-- Name: topo_site topo_site_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_site
    ADD CONSTRAINT topo_site_pk PRIMARY KEY (id_topo, id_site);


--
-- TOC entry 2752 (class 2606 OID 27023)
-- Name: utilisateur utilisateur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pk PRIMARY KEY (id_utilisateur);


--
-- TOC entry 2748 (class 2606 OID 27007)
-- Name: voie voie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT voie_pk PRIMARY KEY (id_voie);


--
-- TOC entry 2762 (class 2606 OID 27068)
-- Name: voie secteur_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT secteur_voie_fk FOREIGN KEY (id_secteur) REFERENCES public.secteur(id_secteur);


--
-- TOC entry 2764 (class 2606 OID 27058)
-- Name: commentaire site_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT site_commentaire_fk FOREIGN KEY (id_site) REFERENCES public.site(id_site);


--
-- TOC entry 2761 (class 2606 OID 27053)
-- Name: secteur site_secteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT site_secteur_fk FOREIGN KEY (id_site) REFERENCES public.site(id_site);


--
-- TOC entry 2767 (class 2606 OID 27063)
-- Name: topo_site site_topo_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_site
    ADD CONSTRAINT site_topo_site_fk FOREIGN KEY (id_site) REFERENCES public.site(id_site);


--
-- TOC entry 2770 (class 2606 OID 27093)
-- Name: reservation topo_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT topo_reservation_fk FOREIGN KEY (id_topo) REFERENCES public.topo(id_topo);


--
-- TOC entry 2768 (class 2606 OID 27098)
-- Name: topo_site topo_topo_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_site
    ADD CONSTRAINT topo_topo_site_fk FOREIGN KEY (id_topo) REFERENCES public.topo(id_topo);


--
-- TOC entry 2765 (class 2606 OID 27088)
-- Name: commentaire utilisateur_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT utilisateur_commentaire_fk FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id_utilisateur);


--
-- TOC entry 2769 (class 2606 OID 27083)
-- Name: reservation utilisateur_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT utilisateur_reservation_fk FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id_utilisateur);


--
-- TOC entry 2766 (class 2606 OID 27078)
-- Name: topo utilisateur_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT utilisateur_topo_fk FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id_utilisateur);


--
-- TOC entry 2763 (class 2606 OID 27073)
-- Name: longueur voie_longueur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.longueur
    ADD CONSTRAINT voie_longueur_fk FOREIGN KEY (id_voie) REFERENCES public.voie(id_voie);


-- Completed on 2021-02-09 19:18:43

--
-- PostgreSQL database dump complete
--

