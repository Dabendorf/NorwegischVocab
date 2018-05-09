drop table Raumschiffe if exists;
drop table Raumhafen if exists;
drop table Imperium if exists;
drop table Planeten if exists;
drop table sonnensysteme if exists;

Create Table Sonnensysteme
(
SonnensystemID integer primary key generated by default as identity,
name varchar(64)
);

Create Table Planeten
(
PlanetID integer primary key generated by default as identity,
name varchar(64),
SonnensystemID integer
foreign key references Sonnensysteme (SonnensystemID)
);

create table Imperium
(
ImperiumID integer primary key generated by default as identity,
name varchar(64)
);

Create Table Raumhafen
(
RaumhafenID integer primary key generated by default as identity,
name varchar(64),
PlanetID integer
foreign key references Planeten (PlanetID),
ImperiumID integer
foreign key references Imperium (ImperiumID)
);

Create Table Raumschiffe
(
RaumschiffID integer primary key generated by default as identity,
name varchar(64),
RaumhafenID integer
foreign key references Raumhafen (RaumhafenID)
);