-- create table invoice(id int primary key auto_increment, name varchar(255))
-- as select null, * from csvread('/Users/ego/My/C0de/ing-labs/growth-navigator/src/main/resources/test.csv');


-- create table invoice(id int primary key auto_increment, party_id int, invoice_number int, due_date timestamp, amount decimal(10,4), ledger varchar(255))
create table invoice(id int primary key auto_increment, party_id int, invoice_number int, amount DECIMAL(10, 4), due_date timestamp, ledger varchar(255))
as select null, party_id, invoice_number, amount, parsedatetime(due_date, 'yyyy-MM-dd hh:mm:ss'), ledger from csvread('classpath:invoices.csv');

