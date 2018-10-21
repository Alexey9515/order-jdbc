DELETE FROM "product_categories";
DELETE FROM "products";
DELETE FROM "categories";

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (1,null,'Овощи, Фрукты','vegetables-fruits');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (2,null,'Мясо, Рыба','meat-fish');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (3,null,'Молоко, Сыр, Яйцо','milk-cheese-egg');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (4,null,'Напитки','drink');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (5,1,'Овощи','vegetables');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (6,1,'Зелень, салаты','greens-salads');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (7,1,'Грибы','mushrooms');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (8,2,'Птица','bird');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (9,2,'Рыба, морепродукты','fish-seafood');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (10,2,'Полуфабрикаты из мяса, птицы','meat-poultry');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (11,3,'Сыры','cheese');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (12,3,'Сгущенное молоко, десерты','condensed milk-desserts');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (13,4,'Вода','water');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (14,4,'Соки. Нектары','juices-nectar');

INSERT INTO "categories"(id, id_parent, name, system_name)
VALUES (15,4,'Квас, холодный чай, кофе','kvass-cold tea-coffee');


INSERT INTO "products"(id, name, articale,price)
VALUES (1,'Грибы Вешенки',456789,234.23);
INSERT INTO "products"(id, name, articale,price)
VALUES (2,'Грибное ассорти 4 сезона, 400 гр Россия',123456,323.43);

INSERT INTO "products"(id, name, articale,price)
VALUES (3,'Грибы сушеные белые 45г Наша Ферма Россия',123345,456.45);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (7,1);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (7,2);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (7,3);


INSERT INTO "products"(id, name, articale,price)
VALUES (4,'Филе грудки индейки, "Разуменская индейка", в/у, Россия',123340,2343.45);

INSERT INTO "products"(id, name, articale,price)
VALUES (5,'Цыплята фермерские охлажденные "Наша Ферма" Карпов КФХ',456345,234.56);

INSERT INTO "products"(id, name, articale,price)
VALUES (6,'Сердце индейки охлажденное Дюк-Индюк лоток Россия',345234,678.45);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (8,4);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (8,5);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (8,6);


INSERT INTO "products"(id, name, articale,price)
VALUES (7,'Семга охлажденная филе от "Азбуки Вкуса"',123678,345.89);

INSERT INTO "products"(id, name, articale,price)
VALUES (8,'Дорада (морской карась), 600/800, Средиземное море',678567,654.45);

INSERT INTO "products"(id, name, articale,price)
VALUES (9,'Ледяная рыба охлажденная 250+ Фишерис',567456,1233.34);


INSERT INTO "product_categories"(id_category, id_product)
VALUES (9,7);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (9,8);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (9,9);

INSERT INTO "products" (id, name, articale,price)
VALUES (10,'Корейка молодого барашка с розмарином и чесноком, Почти готово, 400 г',213567,234.55);

INSERT INTO "products"(id, name, articale,price)
VALUES (11,'Чевапчичи из телятины охлажденные Мираторг 300 г лоток Россия',645678,444.98);

INSERT INTO "products"(id, name, articale,price)
VALUES (12,'Жиго ягненка с молодым сыром гойя, п/ф',678890,987.45);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (10,10);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (10,11);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (10,12);


INSERT INTO "products"(id, name, articale,price)
VALUES (13,'Сыр плавленый колбасный копченый 45%, "Просто Азбука", 150 г, Россия',123890,656.56);

INSERT INTO "products"(id, name, articale,price)
VALUES (14,'Сыр "Легкий" 15%, "Тысяча Озер", 125 г, Россия',345789,2344.54);

INSERT INTO "products"(id, name, articale,price)
VALUES (15,'Сыр из коровьего молока Гран Карактер 32% Santa Rosa Milkana Milkaut S.A.',234890,345.22);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (11,13);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (11,14);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (11,15);



INSERT INTO "products"(id, name, articale,price)
VALUES (16,'Молоко сгущенное "Рогачевъ" 8,5% с сахаром, 380 г Беларусь',456858,654.33);

INSERT INTO "products"(id, name, articale,price)
VALUES (17,'Коктейль йогуртный Danissimo 5,2% лайм-мятный сорбет АО "Данон',454747,765.23);

INSERT INTO "products"(id, name, articale,price)
VALUES (18,'Напиток кофейный Starbucks Cappuccino ультрапастеризованный',102202,8353.12);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (12,16);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (12,17);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (12,18);


INSERT INTO "products"(id, name, articale,price)
VALUES (19,'Вода минеральная природная питьевая столовая негазированная,',123569,675.43);

INSERT INTO "products"(id, name, articale,price)
VALUES (20,'Вода минеральная Evian природная негазированная 1 л пластиковая бутылка',545969,100.45);

INSERT INTO "products"(id, name, articale,price)
VALUES (21,'Вода минеральная Архыз негазированная 19 л пластиковая бутылка',365656,1224.54);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (13,19);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (13,20);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (13,21);


INSERT INTO "products"(id, name, articale,price)
VALUES (22,'Морс клюквенный, "Просто Азбука", 1 л, Россия',985857,433.77);

INSERT INTO "products"(id, name, articale,price)
VALUES (23,'Сок прямого отжима апельсиновый, "Просто Азбука", 0.5 л',458965,455.77);

INSERT INTO "products"(id, name, articale,price)
VALUES (24,'Квас "Вкусный", "ЦАРСКИЕ ПРИПАСЫ", 0.5 л, Россия',369526,888.67);

INSERT INTO "products"(id, name, articale,price)
VALUES (25,'Холодный чай Lipton персик 0.5л пластиковая бутылка Россия',452458,484.45);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (14,22);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (14,23);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (15,24);

INSERT INTO "product_categories"(id_category, id_product)
VALUES (15,25);