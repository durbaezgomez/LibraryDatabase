-- /// Create tables for managing accounts
----------------------------------------
create table AccountTypes(
  id integer primary key identity,
  type varchar(40),
);

create table SystemUsers(
  id integer primary key identity,
  login varchar(40),
  passwd varchar(40),
  name varchar(40),
  surname varchar(40),
  accountTypeId integer,
  FOREIGN KEY (accountTypeId) REFERENCES AccountTypes(id)
);

--  TO DO -> BORROWED LOGS DO STWORZENIA W BAZIE
create table BorrowedLogs(
  id integer primary key identity,
  userId integer,
  itemId integer,
  dateStart date,
  dateEnd date,
  FOREIGN KEY (userId) REFERENCES SystemUsers(id),
  FOREIGN KEY (itemId) REFERENCES Items(id)
)


-- /// Insert 1 admin and 1 user
----------------------------------------
insert into AccountTypes values
  ('admin'),
  ('user')
go

insert into SystemUsers values
('admin1', 'admin1','Dominik','Gomez',1)
go

insert into SystemUsers values
('user1', 'user1','Julia','Denis',2)
go

-- /// Create table for LogInfo
----------------------------------------
create table LogInfo(
  logId integer primary key identity,
  logDate datetime,
  userId integer,
  FOREIGN KEY (userId) REFERENCES SystemUsers(id)
);

-- /// Create tables for managing items
----------------------------------------

create table ItemTypes(
  id integer primary key identity,
  type varchar(40),
);

insert into ItemTypes values
('book'),
('magazine'),
('film')
go

create table Items(
  id integer primary key identity,
  typeId integer,
  itemId integer,
  FOREIGN KEY (typeId) REFERENCES ItemTypes(id)
);

-- /// Insert 1 book, 1 magazine and 1 film into [Items] table
----------------------------------------
insert into Items values
(1),
(2),
(3)
go

-- /// Create tables for Authors, Publishers, Directors, Genres
----------------------------------------
create table Authors(
  id integer primary key identity,
  name varchar(40),
  surname varchar(40)
);

create table Publishers(
  id integer primary key identity,
  name varchar(40)
);

create table Directors(
  id integer primary key identity,
  name varchar(40),
  surname varchar(40)
);

create table Genres(
  id integer primary key identity,
  genre varchar(40)
);

-- /// Create tables for Books, Magazines, Films
----------------------------------------
create table Books(
  id integer primary key identity,
  title varchar(40),
  authorId integer,
  edition integer,
  year integer,
  publisherId integer,
  FOREIGN KEY (authorId) REFERENCES Authors(id),
  FOREIGN KEY (publisherId) REFERENCES Publishers(id)
);

create table Magazines(
  id integer primary key identity,
  title varchar(40),
  year integer,
  issue integer,
  publisherId integer,
  FOREIGN KEY (publisherId) REFERENCES Publishers(id)
);

create table Films(
  id integer primary key identity,
  title varchar(40),
  directorId integer,
  year integer,
  genreId integer,
  FOREIGN KEY (directorId) REFERENCES Directors(id),
  FOREIGN KEY (genreId) REFERENCES Genres(id)
);