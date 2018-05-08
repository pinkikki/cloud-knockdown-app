create table users
(
	username varchar(50) not null
		constraint users_pkey
			primary key,
	password varchar(100) not null,
	enabled boolean not null
);

create table authorities
(
	username varchar(50) not null
		constraint fk_authorities_users
			references users,
	authority varchar(50),
	constraint uk_authorities
		unique (username, authority)
);

create table event
(
	id serial not null
		constraint event_pkey
			primary key,
	name varchar(50)
);