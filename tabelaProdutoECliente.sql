create database floricultura;
use floricultura;

create table produtos(
id int not null auto_increment,
nome varchar(50) not null,
quantidade int not null,
valor double not null,
descricao varchar(100) not null,
primary key(id));

create table clientes(
id int not null auto_increment,
nome varchar(150) not null,
CPF varchar(11) not null,
email varchar(100) null,
endereco varchar(200) not null,
numero varchar(10) not null,
complemento varchar(50) null,
sexo varchar(10) not null,
estadoCivil varchar(50) not null,
dataNasc varchar (50) null,
telefone varchar(150) not null,
primary key(id));


create table itemvenda(
    id int not null auto_increment,
    produtoId int not null,
    vendaId int not null,
    quantidade int not null,
    precoUnitario double not null,
    precoTotal double not null,
    primary key(id),
    foreign key(produtoId) references produtos(id),
    foreign key(vendaId) references vendas(id)
);

create table vendas(
    id int not null auto_increment,
    clienteId int,
    valorTotal double,
    dataDaCompra date,
    dataAtualizacao date,
    desconto int,
    pagamento varchar(45),
    primary key(id),
    foreign key(clienteId) references clientes(id)
);

