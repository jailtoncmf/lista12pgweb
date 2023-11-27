CREATE TABLE prato (
    id INT PRIMARY KEY,
    nome VARCHAR(255),
    ingredientes VARCHAR(255),
    tipo_de_prato VARCHAR(50)
);

INSERT INTO prato (id, nome, ingredientes, tipo_de_prato) 
VALUES 
(1, 'Bisteca', 'Carne', 'prato principal'),
(2, 'Frango Grelhado', 'Frango', 'prato principal');

SELECT * FROM prato;

DELETE FROM prato;
