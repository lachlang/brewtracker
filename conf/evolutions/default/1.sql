# Brews Schema`

# --- !Ups

create table brewers (
  id                        bigint not null,
  first_name                 varchar(255) not null,
  last_name                  varchar(255) not null,
  constraint pk_acting_as primary key (id))
;

create sequence acting_as_seq;

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
--
--create table country (
--  id                        bigint not null,
--  name                      varchar(255),
--  code                      varchar(255),
--  region_id                 bigint,
--  constraint pk_country primary key (id))
--;

# --- !Downs

drop table if exists brewers cascade;

drop sequence if exists acting_as_seq;
