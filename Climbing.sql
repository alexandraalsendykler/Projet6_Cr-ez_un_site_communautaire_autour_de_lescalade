--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 13.1

-- Started on 2021-02-09 19:16:37

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

--
-- TOC entry 2898 (class 0 OID 26983)
-- Dependencies: 203
-- Data for Name: site; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.site (id_site, nom, description, coordonneesgps, officiel) FROM stdin;
2	spot localisé proche Lyon	spot très sympa localisé dans le parc des Huguettes	34k45	f
3	grimpette débutant en Bretagne	spot localisé en Bretagne très sympa	56k34	t
5	mur de la fraise	spot escalade localisé dans le Morbihan	67g12	t
6	falaise des oiseaux sauvages	lieu escalade proche de Trouville	23m79	t
7	mur grimpette des chiens perdus	spot parfait pour les débutants	90a67	t
8	escalade des landes	spot escalade localisé dans les landes	89t45	f
9	murs de Béziers	mur escalade dédié aux pros	90i12	t
10	escalades des Escouillades	spot de grimpette proche de Nices	34f65	f
11	escalade du 91	localisé près de Corbeille Essonne	98u90	t
12	spot de Nantes	localisé dans la banlieue de Nantes	76m30	t
13	mur escalade franco-espagnole	spot grimpette frontalier avec Espagne	59o27	t
14	spot grimpe pro	mur escalade pour professionnel	46y89	f
15	mur escalade débutant	spot idéal proche de Versailles 	34t72	t
1	escalade du 92	point escalade situé près de Rueil	89q23	t
4	escalade de la motte dorée	lieu dédié aux pros	87e34	t
\.


--
-- TOC entry 2906 (class 0 OID 27018)
-- Dependencies: 211
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utilisateur (id_utilisateur, pseudo, membre, email, motdepasse) FROM stdin;
27	romain	f	romain.sessa@gmail.com	$2a$10$pl3E.JIF6/llLSVmzcMYA.6gXI0w/2lB0HpzcBge9/vAJhAW.oOqW
28	Poisson	f	yodele@gmail.com	$2a$10$D8OgrRHWpBhM5NJsQnrChuUSabiKc0cb6/L7uI41DLeU5m6464sW.
29	pongpong	f	dong@dong.com	$2a$10$pnTT3PthgaD6jOb0ypltM.rlB3NXbvHX/3FkEkRM5w1H70uTEjtpO
30	test	f	test@test.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
3	brunoescaladepro	t	escaladepro78@outlook.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
4	lilasfleurs	f	kirbyaileetoile23@msn.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
5	catherine45	t	catherineescalade@gmail.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
6	officielescaladedu23	t	lesamisescaladesdu23@gmail.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
7	dongdong76	f	dongdongfaitdelescalade@windows.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
8	salome134	t	salome34@gmail.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
9	enfantsgrimpeursdesnuages	t	enfantsvolantsdusoleil@gmail.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
10	kirbyvolant	f	kirbyetoile45@gmail.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
11	yodelesuisseescalade	f	lessuissesfontdelescalade@gmail.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
12	coraline606	t	coralune666@gmail.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
13	Kewin45	f	kewin345hello@gmail.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
14	lola89	t	89lola98@gmail.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
15	popol87	f	popoleescalade@hotmail.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
32	Zozo	f	Zozo@gmail.com	$2a$10$VgRlVx1aYyzqh60gKj1dGeUoACUrhPJx0LaBUMNA8hLe0bjDQvgHS
31	dupontdu92	f	jean.dupont@gmail.com	$2a$10$4OZPO.rSwrt8ts/Y5rOGvOkPRne4HgJPLwasgvLYhZgAbzwM7rhXG
1	grimpeur69	t	grimpeur69@gmail.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
2	girllovesgrimpette	f	grimpette95@gmail.com	$2a$10$ZyrwXDAz649TYP3TDkIz5.a/OZbcw4p7iZdrNUQEYzU0yPJlBclre
35	patate	f	patate@patate.fr	$2a$10$9pFcmws/HrwzGGzv9I8XGOMiRL55IdxmDLKdzMEPACw47IzY3DVK2
34	fraise	t	fraise@fraise.com	$2a$10$rraGyykTxZ94uhtuBCs0n.ANOs8hUkF/XeatqYrrQblGTYChk0E36
36	TrucTruc	f	trucmuche@trucmuche.com	$2a$10$bOX6reAfBAWSdwQowd9sj.kl6TWi.53YUsjkUULG7nBK.AkVwrIVa
37	Alex	f	alexandra.alsen.dykler@gmail.com	$2a$10$hiAA2GwWXIZmBDHcYMxThubHaTASKnGhOZeSBZR1.VtslSP700FMO
\.


--
-- TOC entry 2908 (class 0 OID 27026)
-- Dependencies: 213
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commentaire (id_commentaire, id_site, id_utilisateur, contenu) FROM stdin;
3	1	13	spot exceptionnel obligatoire de réserver
4	10	9	site escalade sans plus correct pour débuter
5	5	11	site correct fun à faire avec les potes
6	12	4	mur de grimpe pour tout le monde attention très populaire
7	7	10	spot pas sympa du tout à éviter
8	13	2	génial pour éclate entre parents et enfants
10	11	5	fait le taff mais trop populaire à mon goût
11	8	14	excellent et nature autour superbe
12	6	12	bof
13	14	3	superbe en terme de nature mais très très populaire réservation obligatoire
14	2	15	sans rire ce spot est nul bon pour débutant sûrement
15	9	7	si vous avez rien à faire pas très intéressant
17	13	5	site d'escalade super génial !
16	10	8	spot pas très intéressant
18	12	6	fabuleux !
19	3	12	Nul nul nul !
20	1	15	Nature détruite trop de personnes !
21	4	1	magnifique ! Je recommande chaudement !
22	11	10	bof
23	15	9	venez faire la grimpette très tôt afin de profiter du soleil levant !
24	7	3	Spot super pour les tous petits !
25	8	4	uniquement pour les adultes pro limite confirmés
26	5	2	naze
27	9	13	a fuir ! bcp trop de monde et surtout over exagéré...
28	2	14	sublime, juste sublime. A faire absolument que l'on soit grand ou petit.
29	14	7	fuyez ! c'est un bins juste pour grimper ! faire la queue pour faire du sport !
30	6	11	Impec ! A faire par beau temps car pas couvert !
1	1	34	Super spot !!
9	9	35	J'adore ce spot pour s'éclater !
2	2	34	Super site d'escalade !
\.


--
-- TOC entry 2900 (class 0 OID 26994)
-- Dependencies: 205
-- Data for Name: secteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.secteur (id_secteur, id_site, nom) FROM stdin;
1	8	secteur rose
2	1	secteur orange
3	14	secteur rouge vermillon
4	12	secteur jaune
5	4	secteur noir
6	15	secteur nacre
7	11	secteur vert
8	6	secteur blanc
9	10	secteur blanc
10	10	secteur kaki
11	2	secteur gris
12	5	secteur violet
13	13	secteur vert eau
14	9	secteur argent
15	7	secteur doré
16	5	secteur cendré
17	3	secteur lila
18	1	secteur bleu argenté
19	12	secteur rose fluo
20	2	secteur bleu nuit
21	5	secteur rose doré
22	14	secteur violet écarlate
23	13	secteur orange carmin
24	11	secteur noir profond
25	7	secteur jaune soleil
\.


--
-- TOC entry 2902 (class 0 OID 27002)
-- Dependencies: 207
-- Data for Name: voie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.voie (id_voie, id_secteur, nom, cotation, hauteur, nombredepoint) FROM stdin;
1	14	bleuets	4b	10	45
3	8	tournesol	3b	15	23
4	13	lila	6c	20	76
5	1	pensées	7a	4	24
7	4	orchidées	3c	18	68
8	2	lavande	8b	3	15
9	6	runoncule	7c	21	27
10	15	jonquille	3a	25	79
11	11	tulipe	4b	5	34
12	7	azalée	7c	9	48
13	9	anémone	6a	13	37
14	10	pâquerette	5b	19	26
15	5	acacia	8b	22	29
18	12	lilis	6c	34	39
20	3	rose	8b	5	69
17	14	bleuets	8a	14	63
19	5	marguerite	4c	23	57
21	20	amarante	9c	12	36
16	2	coquelicot	7c	24	35
22	21	bouton d'or	6b	20	54
23	22	camomille	2a	34	89
24	23	cyclamen	5b	2	27
25	24	géranium	6c	45	41
26	25	lotus	9c	22	57
27	19	muguet	1a	11	43
28	17	pétunia	5a	37	29
29	18	pissenlit	2b	15	3
30	16	oeillet	1c	45	23
6	12	safran	5a	12	35
2	3	primevère	6a	6	58
\.


--
-- TOC entry 2904 (class 0 OID 27010)
-- Dependencies: 209
-- Data for Name: longueur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.longueur (id_longueur, id_voie, cotation) FROM stdin;
1	11	8c
2	9	5a
4	2	9c
7	1	7b
9	12	7c
10	5	4b
12	14	3a
13	7	6c
14	4	5a
17	3	5a
18	10	4c
22	6	9b
16	13	9c
24	8	8a
23	15	8a
25	21	7b
26	22	5a
27	23	4c
28	24	9b
3	26	4c
5	16	7a
6	27	5b
8	28	3b
11	18	9a
19	17	6b
20	19	1c
21	20	3a
15	29	4b
\.


--
-- TOC entry 2910 (class 0 OID 27034)
-- Dependencies: 215
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topo (id_topo, id_utilisateur, region, disponibilite, nom, description, date_parution) FROM stdin;
42	3	Sud de la France	t	Lion	Parfait pour les débutants	2019-06-14
45	10	A Nice	f	Giraffe	Intéressant pour les enfants	2005-12-31
46	28	Localisé en Vendée	t	Dromadaire	Uniquement pour les enfants	2019-03-16
47	1	Pas loin de la frontière allemande	t	Zèbre	Très cool à faire mais avoir des notions tout de même	2006-10-24
48	8	Limitrophe de l'Espagne	t	Gazelle	Pour grands et petits	2006-06-17
49	13	A côté de Paris	f	Canard	Uniquement pour les adultes	2005-05-23
50	31	A côté de Toulouse	f	Chien	Pratique pour s'entrainer 	2008-10-18
51	15	Près de Nevers	t	Lapin	Dédié pour les adultes avec beaucoup d'expériences	1995-05-26
52	14	Localisé dans les Bouches du Rhone	t	Lama	Spot sympa très jolie	2007-02-13
53	11	En Normandie	f	Babouin	Valeur sûr pour tous les amateurs d'escalade	2004-10-01
54	2	Proche de Trouville	f	Vache	Lieu pour les débutants	2018-09-18
55	7	En Bretagne 	t	Dauphin	Parfait pour les familles et les petits enfants	1983-06-03
56	4	A Strasbourg	t	Chat	A faire entre adultes uniquement 	2003-06-18
57	29	Proche de Toulon	f	Gorille	Cadre trop beau pour petits et grands	2009-08-29
58	9	A Marseille	f	Baleine	Sympa pour les premiers pas des mômes	2020-07-05
59	3	A côté de la frontière Italienne	t	Poney	Les pros s'en donneront à coeur joie	2009-04-27
60	27	Proche frontière Suisse	f	Ours	Spot pratique pour les amateurs aguerris 	2016-01-30
61	12	En région Paca	t	Buffle	Uniquement pour les adolescents	1997-06-12
64	34	Nancy	f	Banzai	spot d'escalade cool à faire avec les enfants	2021-01-20
44	30	A côté de Paris	f	Cheval	Pour les pros uniquement	1990-04-28
43	6	Proche de Lyon	f	Papillon	Parfait pour les initiés	2020-06-12
\.


--
-- TOC entry 2913 (class 0 OID 27047)
-- Dependencies: 218
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservation (id_reservation, id_topo, id_utilisateur, statut) FROM stdin;
16	42	3	reservé
17	42	28	annulé
19	42	34	demande
21	55	36	demande
24	42	34	demande
25	48	34	demande
26	47	34	demande
27	47	34	demande
28	46	34	demande
29	42	34	demande
30	47	34	demande
31	42	34	demande
32	64	30	confirmer
33	42	34	demande
37	64	34	confirmer
38	64	34	confirmer
40	64	35	confirmer
41	44	34	confirmer
42	42	37	demande
46	42	34	demande
47	42	34	demande
18	43	34	confirmer
\.


--
-- TOC entry 2911 (class 0 OID 27040)
-- Dependencies: 216
-- Data for Name: topo_site; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topo_site (id_topo, id_site) FROM stdin;
\.


--
-- TOC entry 2919 (class 0 OID 0)
-- Dependencies: 212
-- Name: commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_id_seq', 31, true);


--
-- TOC entry 2920 (class 0 OID 0)
-- Dependencies: 208
-- Name: longueur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.longueur_id_seq', 52, true);


--
-- TOC entry 2921 (class 0 OID 0)
-- Dependencies: 217
-- Name: reservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservation_id_seq', 48, true);


--
-- TOC entry 2922 (class 0 OID 0)
-- Dependencies: 204
-- Name: secteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.secteur_id_seq', 63, true);


--
-- TOC entry 2923 (class 0 OID 0)
-- Dependencies: 202
-- Name: site_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.site_id_seq', 49, true);


--
-- TOC entry 2924 (class 0 OID 0)
-- Dependencies: 214
-- Name: topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_id_seq', 73, true);


--
-- TOC entry 2925 (class 0 OID 0)
-- Dependencies: 210
-- Name: utilisateur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utilisateur_id_seq', 37, true);


--
-- TOC entry 2926 (class 0 OID 0)
-- Dependencies: 206
-- Name: voie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.voie_id_seq', 60, true);


-- Completed on 2021-02-09 19:16:38

--
-- PostgreSQL database dump complete
--

