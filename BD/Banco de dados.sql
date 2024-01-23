create database JavaJDBC;
use JavaJDBC;

create table `tbl_pessoa`(
	`id` int not null auto_increment,
	`nomePessoa` varchar(30) not null,
	`cpfPessoa` varchar(11) not null,
	`emailPessoa` varchar(30) not null, 
	`senhaPessoa` varchar(30) not null,
	`telefonePessoa` varchar(11) not null,
	primary key (`id`)
);

select * from tbl_pessoa
