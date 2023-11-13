-- Criando esquema de dados

CREATE DATABASE IF NOT EXISTS visoes /*!40100 COLLATE 'utf8_general_ci' */;

USE visoes;

CREATE TABLE IF NOT EXISTS vendedor(

id numeric(5),

nome varchar(30),

cidade varchar(30),

comissao decimal(5,2), -- comissão do vendededor

CONSTRAINT pk_vendedor_id PRIMARY key(id)

);

CREATE TABLE IF NOT EXISTS cliente(

id numeric(5),

nome varchar(30),

cidade varchar(30),

nivel numeric(3), -- grade que o consumidor está alocado

CONSTRAINT pk_clienteId PRIMARY key(id)

);

CREATE TABLE IF NOT EXISTS pedido(

numero numeric(5),

valor decimal(8,2), -- valor comprado

dataCompra DATE,

idCliente numeric(5),

idVendedor numeric(5),

CONSTRAINT pk_numeroPedido PRIMARY key(numero),

CONSTRAINT fk_cliente FOREIGN key(idCliente) REFERENCES cliente(id),

CONSTRAINT fk_vendedor FOREIGN key(idVendedor) REFERENCES vendedor(id)

);

-- inserindo dados na tabela salesman

INSERT INTO vendedor (id,nome,cidade,comissao) VALUES 

(1,"Brendan Tillman","Kessenich",77),

(2,"Owen Barr","Genk",7),

(3,"Hu Cortez","Pöttsching",89),

(4,"Edward Herring","Vitrival",34),

(5,"Jack Sutton","Arendonk",92),

(6,"Kennedy Douglas","New York",19),

(7,"Andrew Hamilton","Surendranagar",11),

(8,"Todd Bond","Henley-on-Thames",33),

(9,"Carlos Hernandez","Baasrode",65),

(10,"Duncan Gill","Aliano",99),

(11,"Timothy Larsen","Hildesheim",63),

(12,"Rogan Gaines","Chastre",79),

(13,"Holmes Brooks","Grobbendonk",90),

(14,"Cain Oneill","Barrie",13),

(15,"Grant Weiss","Puente Alto",87),

(16,"Gabriel Suarez","Palmiano",53),

(17,"Yardley Willis","Blue Mountains",80),

(18,"Jerry Gillespie","Bayswater",13),

(19,"Jarrod Haley","Leamington",34),

(20,"Howard Ellis","Rockville",5),

(21,"Avram Pratt","Blehen",34),

(22,"Grant Sellers","New York",5),

(23,"Adam Fisher","Hulste",56),

(24,"Cameron Sharp","Igboho",44),

(25,"Berk Landry","Toulon",61),

(26,"Samson Christensen","New York",55),

(27,"Geoffrey Hawkins","Newport News",13),

(28,"Ross Olson","Drancy",5),

(29,"Martin Rosales","İmamoğlu",91),

(30,"Sawyer Mcknight","Lago Ranco",30),

(31,"Walter Merritt","Cervino",24),

(32,"Noah Bell","Bungay",83),

(33,"Hu Graves","New York",97),

(34,"Aidan Boyle","Vorst",42),

(35,"Laith Ayers","Taunusstein",100),

(36,"Odysseus Ramsey","Awka",59),

(37,"Nash Chase","Montleban",64),

(38,"Vaughan Frederick","Bad Dürkheim",19),

(39,"Nigel Mason","New York",72),

(40,"Louis Fleming","Herentals",24),

(41,"Maxwell Acosta","Baidyabati",100),

(42,"Murphy Berger","Soma",39),

(43,"Henry Mckinney","Whittlesey",28),

(44,"Murphy Davis","New York",11),

(45,"Vaughan Ratliff","Harrison Hot Springs",23),

(46,"Xavier Summers","Ohain",42),

(47,"Amery Carson","Kakinada",72),

(48,"Dale Olsen","Holywell",36),

(49,"Nathaniel Morton","Caen",32),

(50,"Stephen Huff","Arica",61),

(51,"Hammett Mccormick","Gespeg",86),

(52,"Tate Armstrong","Fortune",90),

(53,"Malik Hardy","Beerzel",68),

(54,"Arsenio Franks","Bradford",60),

(55,"Ferdinand Gilbert","Nieuwmunster",60),

(56,"Raymond David","Recoleta",37),

(57,"Kermit Blake","Fresno",20),

(58,"Hayden Elliott","New York",58),

(59,"Wade Hoffman","Vannes",79),

(60,"Barclay Trevino","Wevelgem",62),

(61,"Declan Dale","Hamilton",23),

(62,"Steel Wolfe","Perk",11),

(63,"Cain Price","Koersel",93),

(64,"Wesley Garza","H�rouxville",98),

(65,"Steven Cote","Charlottetown",51),

(66,"Kareem Huff","Kerkhove",22),

(67,"Tiger Harmon","Buggenhout",49),

(68,"Wallace Thompson","Maaseik",30),

(69,"Rudyard Swanson","Pemuco",13),

(70,"Vincent Finch","Pontevedra",100),

(71,"Julian Beard","New York",19),

(72,"Mufutau Castaneda","Bierges",15),

(73,"Josiah Gilliam","Stuttgart",40),

(74,"Lester Dalton","Cabano",61),

(75,"Keaton Williams","Castelluccio Superiore",39),

(76,"Emery Smith","Chambord",90),

(77,"Colt Vance","Hennigsdorf",42),

(78,"Ryan Barker","Dewas",24),

(79,"Drew Fuentes","Ankara",74),

(80,"Randall Berry","Ospedaletto Lodigiano",64),

(81,"Tiger Wilkins","East Kilbride",41),

(82,"Perry Beard","Orhangazi",5),

(83,"Colby Gray","Peutie",3),

(84,"Nathaniel Blevins","Wilmont",9),

(85,"Kasimir Bolton","San Diego",58),

(86,"Todd Rosario","Castel Giorgio",77),

(87,"Robert Crawford","Namen",40),

(88,"Richard Duffy","Valbrevenna",82),

(89,"Abbot Donovan","Castelvecchio Calvisio",77),

(90,"Gregory Lott","Mascalucia",1),

(91,"Avram Harris","Legal",32),

(92,"Xander Mayer","Ruthin",32),

(93,"Ferdinand Cobb","Köflach",26),

(94,"Fulton Santana","Gloucester",99),

(95,"Valentine Ward","Lagundo/Algund",69),

(96,"Jacob Martin","Momignies",33),

(97,"Oscar Dotson","Chillán Viejo",19),

(98,"Nigel Guerrero","Saint-Louis",72),

(99,"Sean Ellison","Sant'Elpidio a Mare",41),

(100,"Edward Woodward","Proddatur",98);



-- Inserindo dados na tabela cliente

INSERT INTO cliente (id,nome,cidade,nivel) VALUES 

(1,"Thane T. Norman","Sangerhausen",6),

(2,"Alan B. Head","Mulhouse",2),

(3,"Miranda U. Graham","San Carlos",9),

(4,"Julian B. Rodriquez","Drayton Valley",2),

(5,"Teegan O. Terrell","Verzegnis",8),

(6,"Giacomo H. Franklin","Castelluccio Valmaggiore",6),

(7,"Karen K. Lloyd","Heusweiler",1),

(8,"Fritz U. Gutierrez","Genval",8),

(9,"Tatum U. Medina","Lüneburg",4),

(10,"Georgia I. Vazquez","Hartford",6),

(11,"Rachel M. Ortiz","Rotheux-RimiŽre",5),

(12,"Gillian S. Justice","Ilkeston",7),

(13,"Gloria Q. Doyle","Río Hurtado",6),

(14,"Cyrus V. Burks","Bologna",3),

(15,"Ora O. Mueller","Vijayawada",4),

(16,"Abraham W. Scott","Chilliwack",8),

(17,"Francis Z. Garcia","Lutterworth",2),

(18,"Winifred L. Barrera","San Giacomo degli Schiavoni",2),

(19,"Gretchen T. Walker","Tokoroa",9),

(20,"Elizabeth S. Miller","Riesa",10),

(21,"Imelda B. Stevenson","Reutlingen",6),

(22,"Oscar Z. Richard","Gbongan",4),

(23,"Cole Y. Fox","Tavigny",8),

(24,"Eaton Y. Morris","Tuscaloosa",6),

(25,"Yetta F. Velez","Viernheim",4),

(26,"Francis Q. Oneil","Cerreto di Spoleto",10),

(27,"Sonya D. Barrera","Słupsk",8),

(28,"Keefe S. Jefferson","Kakinada",7),

(29,"Fay N. Combs","Balfour",6),

(30,"Ciaran I. Swanson","Telde",3),

(31,"Justine N. Hobbs","Jaunpur",3),

(32,"Chava T. Burns","Livorno",4),

(33,"Carolyn B. Fernandez","TrognŽe",1),

(34,"Graiden G. Albert","Ñiquén",5),

(35,"Tyrone T. Weiss","Moircy",6),

(36,"Judith W. Herman","Pozzuolo del Friuli",9),

(37,"Jakeem O. Mcclure","Hofheim am Taunus",9),

(38,"Amaya U. Battle","Ophoven",4),

(39,"Bertha Z. Griffin","Awka",8),

(40,"Tanek T. Wallace","Tintigny",2),

(41,"Daria Q. Curtis","Turriff",6),

(42,"Lillith S. Schneider","Branchon",3),

(43,"Iris P. Pearson","Clovenfords",1),

(44,"Claire Y. Mills","Nordhorn",9),

(45,"Madeson Q. Daugherty","Saint-Hilarion",6),

(46,"Oscar N. Richmond","La Baie",1),

(47,"Quentin K. Conner","Pedace",5),

(48,"Jennifer A. Ayers","Anchorage",5),

(49,"Hedda R. Kaufman","Catemu",7),

(50,"Ryder C. Solis","Ellon",7),

(51,"Alan U. Avery","Southampton",6),

(52,"Martha N. Barker","Marke",10),

(53,"Hedy F. Hewitt","Diano Arentino",8),

(54,"Lesley D. Bridges","Gressan",3),

(55,"Hayden Q. Greene","Saint-Honor�",10),

(56,"Dante Q. Lindsay","Eschwege",10),

(57,"Rahim S. Hyde","Prince Albert",7),

(58,"Sylvester Q. Caldwell","Oudenburg",3),

(59,"Harlan X. Benson","Bruck an der Mur",8),

(60,"Flynn L. Nash","Palanzano",8),

(61,"Chaney R. Dixon","Cariboo Regional District",1),

(62,"Callum E. Hancock","Calco",6),

(63,"Laith O. Horton","Daussoulx",6),

(64,"TaShya D. Richard","Hallaar",4),

(65,"Hope Z. Murphy","Callander",7),

(66,"Matthew J. Webb","Dendermonde",8),

(67,"Odette E. Byrd","San Rafael Abajo",6),

(68,"Stacey D. Lindsay","Mulchén",2),

(69,"Wynter C. Meadows","Cognelee",10),

(70,"Medge F. Welch","Traiguén",7),

(71,"Hannah N. Higgins","Adelaide",1),

(72,"Phelan F. Dyer","Wageningen",1),

(73,"Risa H. Jordan","Vejano",1),

(74,"Flavia M. Beard","Thionville",5),

(75,"Kellie E. Bass","Bonefro",6),

(76,"Lacey G. James","Yamuna Nagar",3),

(77,"Hannah O. Salazar","Neath",1),

(78,"Mufutau U. Hall","Owen Sound",2),

(79,"Kylan U. Moss","Etobicoke",3), 

(80,"Jacob D. Burke","Auburn",3),

(81,"Micah S. Gardner","Burlington",3),

(82,"Geoffrey T. Collier","Haguenau",7),

(83,"Colorado J. Mayer","Boignee",8),

(84,"Callie K. Buckner","Cappelle sul Tavo",7),

(85,"Judith Z. Green","Reus",10),

(86,"Dominic P. Shepard","Corbara",9),

(87,"Urielle D. Ward","Matlock",5),

(88,"Jenna Q. Davis","Zuienkerke",9),

(89,"Dean V. Sharp","Grand Falls",3),

(90,"Sigourney Z. Peck","Columbus",4),

(91,"Lacy M. Sutton","Pietragalla",7),

(92,"Gay U. Barry","Mansfield",7),

(93,"Calista I. Peck","Hay River",8),

(94,"Anne E. Ayala","Avesta",5),

(95,"Maisie B. Andrews","Westende",6),

(96,"Molly M. Conrad","Wimbledon",1),

(97,"Palmer Z. Stephens","Chiguayante",10),

(98,"Jelani I. Pace","Imperatriz",8),

(99,"Jamal E. Hancock","Aurillac",8),

(100,"Timon Q. Mcpherson","San Rafael",10);



-- Inserindo dados na tabela pedido

INSERT INTO pedido (numero,valor,dataCompra,idCliente,idVendedor) VALUES 

(1,33,"2017-04-24",72,60),

(2,59,"2018-05-17",31,54),

(3,6,"2018-08-24",62,15),

(4,22,"2017-09-06",28,59),

(5,39,"2016-12-23",74,54),

(6,50,"2017-05-24",48,11),

(7,7,"2017-03-23",43,17),

(8,80,"2017-03-14",65,3),

(9,4,"2017-11-21",46,77),

(10,62,"2018-03-08",78,20),

(11,91,"2018-07-19",51,94),

(12,51,"2018-03-22",26,55),

(13,62,"2016-11-12",32,28),

(14,76,"2017-10-10",72,62),

(15,85,"2017-09-01",75,90),

(16,63,"2018-07-29",85,56),

(17,20,"2017-04-12",29,77),

(18,100,"2016-10-12",29,36),

(19,3,"2018-06-14",20,92),

(20,91,"2016-12-27",87,67),

(21,98,"2018-05-08",100,30),

(22,83,"2018-07-30",23,52),

(23,79,"2017-03-03",62,56),

(24,75,"2016-10-12",81,19),

(25,12,"2017-02-02",5,7),

(26,23,"2017-03-14",7,9),

(27,20,"2017-10-29",49,39),

(28,90,"2018-02-18",65,77),

(29,51,"2017-08-31",53,86),

(30,58,"2018-08-01",10,46),

(31,62,"2017-04-05",23,78),

(32,53,"2016-10-11",31,53),

(33,1,"2018-06-07",21,88),

(34,83,"2016-12-20",13,10),

(35,23,"2017-10-02",10,77),

(36,44,"2017-04-16",53,62),

(37,90,"2017-04-24",88,91),

(38,29,"2017-05-29",56,100),

(39,82,"2018-02-03",3,28),

(40,44,"2018-05-25",37,83),

(41,64,"2017-04-16",54,62),

(42,71,"2018-09-04",85,4),

(43,95,"2018-01-17",50,3),

(44,38,"2017-08-03",16,94),

(45,27,"2017-05-26",37,78),

(46,57,"2017-06-12",27,33),

(47,12,"2017-06-15",42,5),

(48,30,"2017-04-28",90,32),

(49,23,"2016-12-09",10,51),

(50,38,"2018-10-01",23,88),

(51,3,"2017-03-22",48,38),

(52,67,"2018-07-06",41,16),

(53,63,"2017-10-25",7,27),

(54,42,"2018-06-02",61,19),

(55,29,"2017-09-13",38,5),

(56,11,"2018-03-03",5,46),

(57,7,"2017-05-13",49,21),

(58,57,"2016-11-15",80,54),

(59,96,"2018-04-22",43,22),

(60,6,"2017-03-03",89,46),

(61,51,"2018-04-11",100,62),

(62,87,"2017-12-29",32,48),

(63,63,"2017-06-06",47,94),

(64,36,"2018-05-14",87,87),

(65,80,"2017-09-15",82,52),

(66,42,"2017-01-22",57,89),

(67,58,"2017-02-25",27,53),

(68,39,"2017-11-11",12,85),

(69,72,"2017-01-17",71,89),

(70,27,"2016-11-15",21,94),

(71,88,"2016-11-04",50,76),

(72,90,"2017-05-16",50,29),

(73,8,"2017-05-07",45,48),

(74,11,"2017-09-03",1,35),

(75,54,"2017-03-30",98,98),

(76,82,"2018-07-04",46,73),

(77,76,"2017-12-25",16,71),

(78,14,"2018-02-25",100,16),

(79,25,"2018-01-19",24,73),

(80,37,"2017-12-11",75,61),

(81,43,"2017-12-07",40,51),

(82,8,"2017-07-15",35,76),

(83,73,"2017-11-15",89,41),

(84,48,"2017-05-25",94,86),

(85,93,"2017-10-05",92,55),

(86,42,"2018-01-21",30,59),

(87,33,"2016-10-19",47,20),

(88,55,"2018-05-21",95,20),

(89,9,"2018-03-21",75,4),

(90,11,"2018-07-28",33,66),

(91,43,"2017-10-19",25,82),

(92,90,"2018-06-15",7,38),

(93,35,"2017-10-28",49,13),

(94,45,"2016-11-30",45,1),

(95,64,"2017-11-29",1,41),

(96,73,"2018-01-01",96,59),

(97,32,"2018-09-10",35,67),

(98,57,"2017-05-05",77,97),

(99,86,"2018-03-11",88,96),

(100,34,"2017-09-25",50,100);

-- Questão 01. Escreva uma consulta para criar uma visão sobre os vendedores da cidade de New York.

CREATE VIEW v_vendedoresNY
AS
SELECT vendedor.nome FROM vendedor
WHERE vendedor.cidade = "New York";

SELECT * FROM v_vendedoresNY;

-- Questão 02. Escreva uma consulta para criar uma visão sobre os vendedores da cidade de New Yorkque possuem comissão maior que 13%

CREATE VIEW v_vendedoresNYC
AS
SELECT vendedor.nome FROM vendedor
WHERE vendedor.cidade = "New York" AND vendedor.comissao > 0.13;

SELECT * FROM v_vendedoresNYC;

-- Questão 03. Escreva uma consulta para criar uma visão que mostra o nome dos vendedores, a média de venda o total de pedidos feitos. Assuma que todos os nomes são únicos

CREATE VIEW v_vendedores
AS
SELECT vendedor.nome, round (AVG(pedido.valor), 2) AS Media, COUNT(pedido.numero) AS 'Total de Pedidos' 
FROM vendedor INNER JOIN pedido 
ON vendedor.id = pedido.idVendedor
GROUP BY vendedor.nome;

SELECT * FROM v_vendedores;
