create table users(
id bigint primary key,
firstname varchar(20),
lastname varchar(20),
pin Int not null unique 
);

create table bankaccount(
id bigint primary key,
user_id bigint,
account_number bigint,
available_balance double,
foreign key (user_id) references users(id)
);

create table transaction(
id bigint primary key auto_increment,
user_id bigint,
account_number bigint,
user_name varchar(30),
amount_debited double,
transaction_date varchar(223),
foreign key (user_id) references users(id)
);

create table History(
id bigint primary key auto_increment,
user_id bigint,
account_number bigint,
user_name varchar(30),
transaction_type varchar(10),
transaction_status varchar(10),
remaining_balance double,
amount_debited double,
transaction_date varchar(223),
foreign key (user_id) references users(id)
);

