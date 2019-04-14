create trigger Books_Insert_trigger on Books
after insert
as
begin
  declare @insertedId int
  set @insertedId=(select id from inserted)
  insert into Items values (1, @insertedId)
end
  go

create trigger Books_Delete_trigger on Books
after delete
as
begin
  declare @deletedId int
  set @deletedId=(select id from deleted)
  delete from Items where itemId = @deletedId
end

create trigger Magazines_Insert_trigger on Magazines
after insert
as
begin
  declare @insertedId int
  set @insertedId=(select id from inserted)
  insert into Items values (2, @insertedId)
end

create trigger Magazines_Delete_trigger on Magazines
after delete
as
begin
  declare @deletedId int
  set @deletedId=(select id from deleted)
  delete from Items where itemId = @deletedId
end


create trigger Films_Insert_trigger on Films
after insert
as
begin
  declare @insertedId int
  set @insertedId=(select id from inserted)
  insert into Items values (3, @insertedId)
end

create trigger Films_Delete_trigger on Films
after delete
as
begin
  declare @deletedId int
  set @deletedId=(select id from deleted)
  delete from Items where itemId = @deletedId
end