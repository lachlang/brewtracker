# Brews Schema`

# --- !Ups

create table brewers (
  id                        serial,
  first_name                varchar(255) not null,
  last_name                 varchar(255) not null,
  email                     varchar(255) not null,
  hash                      varchar(255) not null,
  constraint pk_brewers primary key (id))
;

create table hop_additions (
  id                        bigint not null,
  name                      varchar(255) not null,
  grams                     integer not null,
  aplha_acid                numeric not null,
  minutes                   integer not null,
  comments                  varchar(255),
  constraint pk_hop_additions primary key (id));

create table recipes (
  id                        bigint not null,
  batch_name                varchar(255),
  style                     varchar(255),
  brewer_id                 bigint not null,
  secondary_brewers         varchar(255),
  date_brewed               timestamp not null,
  constraint pk_recipes primary key (id));

create sequence brewers_seq;
create sequence hop_additions_seq;
create sequence recipes_seq;

--
--create table activation_token (
--  token_val                 varchar(255) not null,
--  creds_id                  bigint not null,
--  expires                   timestamp not null,
--  used                      boolean not null,
--  created_on                timestamp not null,
--  constraint pk_activation_token primary key (token_val))
--;
--
--create table audit_log (
--  id                        bigint,
--  event_id                  integer,
--  person_id                 bigint,
--  representation_id         bigint,
--  organisation_id           bigint,
--  message_id                bigint,
--  reply_id                  bigint,
--  record                    varchar(255),
--  log_date                  timestamp not null)
--;
--
--create table binary_file (
--  id                        bigint not null,
--  use                       integer,
--  file_name                 varchar(255) not null,
--  content_type              varchar(255) not null,
--  size                      bigint not null,
--  content                   bytea not null,
--  owner_id                  bigint,
--  created_on                timestamp not null,
--  constraint pk_binary_file primary key (id))
--;
--
--create table connection_tag (
--  id                        bigint not null,
--  connection_id             bigint,
--  representation_id         bigint,
--  tag_id                    bigint,
--  constraint pk_connection_tag primary key (id))
--;


# --- !Downs

drop table if exists brewers cascade;
drop table if exists hop_additions cascade;
drop table if exists recipes cascade;

drop sequence if exists brewers_seq;
drop sequence if exists hop_additions_seq;
drop sequence if exists recipes_seq;