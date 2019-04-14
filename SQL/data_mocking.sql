truncate table Books
truncate table Magazines
truncate table Films

-- /// Mock Authors Table data
----------------------------------------
insert into Authors (name, surname) values ('Gabriele', 'Cottom');
insert into Authors (name, surname) values ('Marian', 'Sterke');
insert into Authors (name, surname) values ('Alfreda', 'Stirley');
insert into Authors (name, surname) values ('Nana', 'Clowton');
insert into Authors (name, surname) values ('Lewie', 'Sewley');
insert into Authors (name, surname) values ('Vladamir', 'Nettles');
insert into Authors (name, surname) values ('Patience', 'Conn');
insert into Authors (name, surname) values ('Othella', 'McGraith');
insert into Authors (name, surname) values ('Mirabel', 'Grooby');
insert into Authors (name, surname) values ('Vaughan', 'Valentin');
insert into Authors (name, surname) values ('Caesar', 'Brayne');
insert into Authors (name, surname) values ('Gris', 'Bladen');
insert into Authors (name, surname) values ('Antonie', 'Campion');
insert into Authors (name, surname) values ('Standford', 'Meeus');
insert into Authors (name, surname) values ('Odo', 'Cuming');
insert into Authors (name, surname) values ('Gerardo', 'Dansie');
insert into Authors (name, surname) values ('Ronni', 'Cratere');
insert into Authors (name, surname) values ('Becky', 'Judson');
insert into Authors (name, surname) values ('Durward', 'Crutchley');
insert into Authors (name, surname) values ('Gertie', 'Adriaan');

-- /// Mock Directors Table data
----------------------------------------
insert into Directors (name, surname) values ('Lucinda', 'McLae');
insert into Directors (name, surname) values ('Sigismund', 'Josupeit');
insert into Directors (name, surname) values ('Lanna', 'Dutch');
insert into Directors (name, surname) values ('Sharron', 'Alcide');
insert into Directors (name, surname) values ('Gabriello', 'Eastes');
insert into Directors (name, surname) values ('Rowen', 'Gabbitus');
insert into Directors (name, surname) values ('Kameko', 'Nutbeem');
insert into Directors (name, surname) values ('Martita', 'Kobus');
insert into Directors (name, surname) values ('Hedi', 'Rechert');
insert into Directors (name, surname) values ('Angie', 'Querrard');
insert into Directors (name, surname) values ('Trace', 'Sopper');
insert into Directors (name, surname) values ('Horten', 'Munsey');
insert into Directors (name, surname) values ('Averil', 'McKeefry');
insert into Directors (name, surname) values ('Dani', 'Crayke');
insert into Directors (name, surname) values ('Odette', 'Tradewell');
insert into Directors (name, surname) values ('Rosalynd', 'Farlamb');
insert into Directors (name, surname) values ('Del', 'Iveson');
insert into Directors (name, surname) values ('Chucho', 'McEwan');
insert into Directors (name, surname) values ('Nissie', 'Fearnsides');
insert into Directors (name, surname) values ('Toddie', 'Give');

-- /// Mock Films Table data
----------------------------------------
insert into Films (title, directorId, year, genreId) values ('Crime After Crime', 17, 2011, 3);
insert into Films (title, directorId, year, genreId) values ('Four Eyed Monsters', 7, 2005, 2);
insert into Films (title, directorId, year, genreId) values ('Pan', 18, 2012, 1);
insert into Films (title, directorId, year, genreId) values ('Guy X', 9, 2012, 2);
insert into Films (title, directorId, year, genreId) values ('Navy Seals', 20, 2002, 3);
insert into Films (title, directorId, year, genreId) values ('Slave of Love, A (Raba lyubvi)', 17, 2012, 3);
insert into Films (title, directorId, year, genreId) values ('Fire on the Mountain', 6, 2005, 2);
insert into Films (title, directorId, year, genreId) values ('Rango', 6, 1991, 3);
insert into Films (title, directorId, year, genreId) values ('Harper', 11, 2000, 4);
insert into Films (title, directorId, year, genreId) values ('Facing the Truth (At kende sandheden)', 7, 2003, 1);
insert into Films (title, directorId, year, genreId) values ('Three Times (Zui hao de shi guang)', 2, 2012, 4);
insert into Films (title, directorId, year, genreId) values ('Wheeler Dealers, The', 20, 2013, 2);
insert into Films (title, directorId, year, genreId) values ('Rudolph the Red-Nosed Reindeer', 19, 2009, 4);
insert into Films (title, directorId, year, genreId) values ('Trans', 20, 1989, 2);
insert into Films (title, directorId, year, genreId) values ('Eddie Murphy Delirious', 13, 2006, 3);
insert into Films (title, directorId, year, genreId) values ('Story of Seabiscuit, The', 14, 1992, 2);
insert into Films (title, directorId, year, genreId) values ('Thin Blue Line, The', 19, 1994, 2);
insert into Films (title, directorId, year, genreId) values ('Bubble Boy', 9, 2000, 1);
insert into Films (title, directorId, year, genreId) values ('Advanced Style', 10, 2010, 2);
insert into Films (title, directorId, year, genreId) values ('Cowards Bend the Knee ', 1, 2001, 2);

-- /// Mock Books Table data
----------------------------------------
insert into Books (title, authorId, edition, year, publisherId) values ('Killing Me Softly', 3, 5, 1999, 4);
insert into Books (title, authorId, edition, year, publisherId) values ('Shattered', 6, 2, 1998, 1);
insert into Books (title, authorId, edition, year, publisherId) values ('Naked Souls', 1, 2, 2005, 2);
insert into Books (title, authorId, edition, year, publisherId) values ('Devils Backbone', 5, 6, 2011, 1);
insert into Books (title, authorId, edition, year, publisherId) values ('Subject Two', 14, 3, 2004, 4);
insert into Books (title, authorId, edition, year, publisherId) values ('Cyrus', 14, 2, 2011, 2);
insert into Books (title, authorId, edition, year, publisherId) values ('Miracle in Milan', 15, 1, 1996, 2);
insert into Books (title, authorId, edition, year, publisherId) values ('Noise', 17, 5, 1993, 2);
insert into Books (title, authorId, edition, year, publisherId) values ('Fighting Sullivans', 15, 2, 1985, 1);
insert into Books (title, authorId, edition, year, publisherId) values ('Thieves (Voleurs, Les)', 20, 1, 2010, 1);
insert into Books (title, authorId, edition, year, publisherId) values ('Pig Hunt ', 16, 2, 1992, 1);
insert into Books (title, authorId, edition, year, publisherId) values ('Endless Love', 15, 1, 1993, 3);
insert into Books (title, authorId, edition, year, publisherId) values ('Thieves, The (Dodookdeul)', 18, 5, 1992, 4);
insert into Books (title, authorId, edition, year, publisherId) values ('Waterboy, The', 3, 6, 2004, 1);
insert into Books (title, authorId, edition, year, publisherId) values ('To Be Twenty', 8, 2, 2008, 4);
insert into Books (title, authorId, edition, year, publisherId) values ('Wild Orchid', 1, 5, 1995, 3);
insert into Books (title, authorId, edition, year, publisherId) values ('Impromptu', 2, 2, 2000, 3);
insert into Books (title, authorId, edition, year, publisherId) values ('Superman/Batman: Public Enemies', 17, 6, 2012, 3);
insert into Books (title, authorId, edition, year, publisherId) values ('The Five Man Army', 11, 2, 1991, 1);
insert into Books (title, authorId, edition, year, publisherId) values ('Tales of Ordinary Madness', 8, 5, 1993, 4);

-- /// Mock Magazines Table data
----------------------------------------
insert into Magazines (title, year, issue, publisherId) values ('Reallinks', 2007, 3, 1);
insert into Magazines (title, year, issue, publisherId) values ('Tambee', 2011, 12, 1);
insert into Magazines (title, year, issue, publisherId) values ('Thoughtstorm', 1994, 9, 3);
insert into Magazines (title, year, issue, publisherId) values ('Avaveo', 2010, 10, 3);
insert into Magazines (title, year, issue, publisherId) values ('Muxo', 1995, 10, 2);
insert into Magazines (title, year, issue, publisherId) values ('Trudeo', 2002, 7, 4);
insert into Magazines (title, year, issue, publisherId) values ('Thoughtbeat', 2006, 2, 1);
insert into Magazines (title, year, issue, publisherId) values ('Meeveo', 2012, 5, 1);
insert into Magazines (title, year, issue, publisherId) values ('Skinder', 2009, 10, 1);
insert into Magazines (title, year, issue, publisherId) values ('Eimbee', 2011, 1, 3);
insert into Magazines (title, year, issue, publisherId) values ('Demimbu', 2006, 5, 1);
insert into Magazines (title, year, issue, publisherId) values ('Quimba', 2001, 6, 2);
insert into Magazines (title, year, issue, publisherId) values ('Riffpath', 2003, 12, 2);
insert into Magazines (title, year, issue, publisherId) values ('Tagfeed', 2007, 12, 4);
insert into Magazines (title, year, issue, publisherId) values ('Jayo', 2004, 3, 4);
insert into Magazines (title, year, issue, publisherId) values ('Photobug', 1995, 7, 4);
insert into Magazines (title, year, issue, publisherId) values ('Feedbug', 1993, 5, 3);
insert into Magazines (title, year, issue, publisherId) values ('Edgeclub', 2001, 10, 4);
insert into Magazines (title, year, issue, publisherId) values ('Chatterbridge', 2010, 3, 1);
insert into Magazines (title, year, issue, publisherId) values ('Quire', 1996, 2, 3);

