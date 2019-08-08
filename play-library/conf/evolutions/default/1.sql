# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table actor (
  actorid                       integer auto_increment not null,
  actorname                     varchar(255),
  constraint pk_actor primary key (actorid)
);

create table authors (
  authorid                      integer auto_increment not null,
  authorname                    varchar(255),
  constraint pk_authors primary key (authorid)
);

create table authors_books (
  authors_author_id             integer not null,
  books_isbn                    integer not null,
  constraint pk_authors_books primary key (authors_author_id,books_isbn)
);

create table books (
  isbn                          integer auto_increment not null,
  title                         varchar(255),
  sector                        varchar(255),
  publicationdate               varchar(255),
  borroweddate                  varchar(255),
  borrowedtime                  integer not null,
  reader                        integer,
  author                        integer,
  publisher                     varchar(255),
  totalnopages                  integer not null,
  constraint pk_books primary key (isbn)
);

create table dvds (
  isbn                          integer auto_increment not null,
  title                         varchar(255),
  sector                        varchar(255),
  publicationdate               varchar(255),
  borroweddate                  varchar(255),
  borrowedtime                  integer not null,
  reader                        integer,
  avail_languages               varchar(255),
  avail_subtitiles              varchar(255),
  producer                      varchar(255),
  actor                         integer,
  constraint pk_dvds primary key (isbn)
);

create table reader (
  readerid                      integer auto_increment not null,
  readername                    varchar(255),
  constraint pk_reader primary key (readerid)
);

create table report (
  isbn                          integer not null,
  itemname                      varchar(255),
  readername                    varchar(255),
  borrowdate                    varchar(255),
  returndate                    varchar(255),
  days                          integer not null,
  fee                           double not null
);

alter table authors_books add constraint fk_authors_books_authors foreign key (authors_author_id) references authors (authorid) on delete restrict on update restrict;
create index ix_authors_books_authors on authors_books (authors_author_id);

alter table authors_books add constraint fk_authors_books_books foreign key (books_isbn) references books (isbn) on delete restrict on update restrict;
create index ix_authors_books_books on authors_books (books_isbn);

alter table books add constraint fk_books_reader foreign key (reader) references reader (readerid) on delete restrict on update restrict;
create index ix_books_reader on books (reader);

alter table books add constraint fk_books_author foreign key (author) references authors (authorid) on delete restrict on update restrict;
create index ix_books_author on books (author);

alter table dvds add constraint fk_dvds_reader foreign key (reader) references reader (readerid) on delete restrict on update restrict;
create index ix_dvds_reader on dvds (reader);

alter table dvds add constraint fk_dvds_actor foreign key (actor) references actor (actorid) on delete restrict on update restrict;
create index ix_dvds_actor on dvds (actor);


# --- !Downs

alter table authors_books drop foreign key fk_authors_books_authors;
drop index ix_authors_books_authors on authors_books;

alter table authors_books drop foreign key fk_authors_books_books;
drop index ix_authors_books_books on authors_books;

alter table books drop foreign key fk_books_reader;
drop index ix_books_reader on books;

alter table books drop foreign key fk_books_author;
drop index ix_books_author on books;

alter table dvds drop foreign key fk_dvds_reader;
drop index ix_dvds_reader on dvds;

alter table dvds drop foreign key fk_dvds_actor;
drop index ix_dvds_actor on dvds;

drop table if exists actor;

drop table if exists authors;

drop table if exists authors_books;

drop table if exists books;

drop table if exists dvds;

drop table if exists reader;

drop table if exists report;

