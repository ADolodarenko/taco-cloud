create table if not exists taco_order (
    id bigserial not null primary key,
    delivery_name varchar(50) not null,
    delivery_street varchar(50) not null,
    delivery_city varchar(50) not null,
    delivery_state varchar(2) not null,
    delivery_zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null);

create table if not exists taco (
    id bigserial not null primary key,
    "name" varchar(50) not null,
    taco_order_id bigint null,
    created_at timestamp not null);

alter table taco add foreign key (taco_order_id) references taco_order(id);

create table if not exists ingredient (
    id varchar(4) not null primary key,
    "name" varchar(25) not null,
    "type" varchar(10) not null);

create table if not exists taco_ingredient (
    ingredient_id varchar(4) not null,
    taco_id bigint not null);

alter table taco_ingredient add foreign key (ingredient_id) references ingredient(id);
alter table taco_ingredient add foreign key (taco_id) references taco(id);

create table users (
    id bigserial not null primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    fullname varchar(255) null,
    street varchar(255) null,
    city varchar(255) null,
    "state" varchar(255) null,
    zip varchar(255) null,
    phone_number varchar(255) null
);




