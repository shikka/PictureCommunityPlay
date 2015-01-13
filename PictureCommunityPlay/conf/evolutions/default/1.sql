# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table picture (
  id                        bigint not null,
  mime_type                 varchar(255),
  data                      blob,
  description               varchar(255),
  creation_date             timestamp,
  name                      varchar(255),
  public_visible            boolean,
  owner_id                  bigint,
  constraint pk_picture primary key (id))
;

create table user (
  id                        bigint not null,
  email                     varchar(255),
  username                  varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (id))
;

create sequence picture_seq;

create sequence user_seq;

alter table picture add constraint fk_picture_owner_1 foreign key (owner_id) references user (id) on delete restrict on update restrict;
create index ix_picture_owner_1 on picture (owner_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists picture;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists picture_seq;

drop sequence if exists user_seq;

