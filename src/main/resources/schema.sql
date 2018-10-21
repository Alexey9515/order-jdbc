CREATE TABLE "categories" (
  "id"          SERIAL NOT NULL,
  "id_parent"   INT,
  "name"        VARCHAR(45),
  "system_name" VARCHAR(45) UNIQUE,
  CONSTRAINT categories_pk PRIMARY KEY (id),
  CONSTRAINT categories_fk0 FOREIGN KEY ("id_parent") REFERENCES "categories" ("id")
);

CREATE TABLE "products" (
  "id"       SERIAL        NOT NULL,
  "name"     VARCHAR(1000) NOT NULL UNIQUE,
  "articale" INT           NOT NULL UNIQUE,
  "price"    FLOAT         NOT NULL DEFAULT 0.0,
  CONSTRAINT products_pk PRIMARY KEY (id)
);

CREATE TABLE "product_categories" (
  "id"          SERIAL NOT NULL,
  "id_category" INT    NOT NULL,
  "id_product"  INT    NOT NULL,
  CONSTRAINT product_categories_pk PRIMARY KEY (id),
  CONSTRAINT product_categories_fk0 FOREIGN KEY ("id_category") REFERENCES "categories" ("id"),
  CONSTRAINT product_categories_fk1 FOREIGN KEY ("id_product") REFERENCES "products" ("id")
);