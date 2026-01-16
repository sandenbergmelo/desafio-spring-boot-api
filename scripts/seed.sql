TRUNCATE TABLE questoes RESTART IDENTITY CASCADE;

INSERT INTO questoes (descricao, resposta, ano, categoria) VALUES
('Qual é a capital da França?', 'Paris', 2020, 'Geografia'),
('Quem escreveu ''Dom Quixote''?', 'Miguel de Cervantes', 2019, 'Literatura'),
('Qual é o planeta mais próximo do Sol?', 'Mercúrio', 2021, 'Astronomia'),
('Em que ano terminou a Segunda Guerra Mundial?', '1945', 2018, 'História'),
('Qual é o maior oceano do mundo?', 'Oceano Pacífico', 2022, 'Geografia'),
('Quantos lados tem um pentágono?', '5', 2020, 'Matemática'),
('Qual é a velocidade da luz em km/s?', '299792', 2021, 'Física'),
('Quem foi o primeiro presidente dos Estados Unidos?', 'George Washington', 2019, 'História'),
('Qual é a fórmula química da água?', 'H2O', 2020, 'Química'),
('Em que ano o homem pisou na Lua pela primeira vez?', '1969', 2018, 'Astronomia'),
('Quem pintou a Mona Lisa?', 'Leonardo da Vinci', 2019, 'Arte'),
('Qual é o elemento químico com símbolo ''Au''?', 'Ouro', 2022, 'Química'),
('Em que país fica a Estátua da Liberdade?', 'Estados Unidos', 2020, 'Geografia'),
('Qual é o maior mamífero terrestre?', 'Elefante', 2021, 'Biologia');
