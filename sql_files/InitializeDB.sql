CREATE DATABASE music_manager;


use  music_manager;

CREATE TABLE user (
	user_id VARCHAR(100) UNIQUE NOT NULL, 
	user_name VARCHAR(100) NOT NULL,
	user_email VARCHAR(20) NOT NULL,
	sex VARCHAR(20),
	password VARCHAR(50) NOT NULL,
	PRIMARY KEY(user_id)	
);

CREATE TABLE artist (
	artist_id VARCHAR(100) NOT NULL UNIQUE,
	artist_name VARCHAR(100) NOT NULL,
	artist_email VARCHAR(20) NOT NULL ,
	PRIMARY KEY(artist_id)	
);

CREATE TABLE following (
	following_id VARCHAR(100) UNIQUE,
	user_id VARCHAR(100),
	follower_id VARCHAR(100),
	PRIMARY KEY(following_id),
	FOREIGN KEY(user_id) REFERENCES user(user_id),
	FOREIGN KEY(follower_id) REFERENCES user(user_id)
);

CREATE TABLE album (
	album_id VARCHAR(100) UNIQUE NOT NULL,
	album_name VARCHAR(100) NOT NULL,
	artist_id VARCHAR(100) ,
	genre VARCHAR(20) NOT NULL,
	PRIMARY KEY(album_id),
	FOREIGN KEY(artist_id) REFERENCES artist(artist_id)
);


CREATE TABLE song (
	song_id VARCHAR(100) NOT NULL UNIQUE,
	song_name VARCHAR(100) NOT NULL,
	album_id VARCHAR(100) NOT NULL,
	artist_id VARCHAR(100) NOT NULL,
	PRIMARY KEY(song_id),
	FOREIGN KEY(album_id) REFERENCES album(album_id),
	FOREIGN KEY(artist_id) REFERENCES artist(artist_id)
);

CREATE TABLE playlist (
	playlist_id VARCHAR(100) NOT NULL UNIQUE,
	user_id VARCHAR(100) NOT NULL,
	PRIMARY KEY(playlist_id),
	FOREIGN KEY(user_id) REFERENCES user(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE playlist_songs (
	playlist_songs_id VARCHAR(100) NOT NULL UNIQUE,
	playlist_id VARCHAR(100) NOT NULL,
	song_id VARCHAR(100) NOT NULL,
	PRIMARY KEY(playlist_songs_id),
	FOREIGN KEY(playlist_id) REFERENCES playlist(playlist_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(song_id) REFERENCES song(song_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO user(user_id, user_name, user_email, sex, password) 
VALUES('01', 'sai003sam', 'ssp5@uic.edu', 'male', 'password' ),
('02', 'ssp5', 'spati@uic.edu', 'male', 'pass'),
('03', 'spati', 'ssp5@gmail.com', 'male', 'pass1234');

INSERT INTO artist(artist_id, artist_name, artist_email)
VALUES('01', 'Kendrick Lamar', 'kdot@gmail.com'),
('02', 'Travis Scott', 'cactusjack@gmail.com'),
('03', 'Kanye West', 'yeeszus@gmail.com');

INSERT INTO following(following_id, user_id, follower_id)
VALUES('01', '02', '01'),
('02', '01', '02'),
('03', '02', '03');

INSERT INTO album(album_id, album_name, artist_id, genre)
VALUES('01', 'DAMN.', '01', 'Hip-Hop'),
('02', 'ASTROWORLD', '02', 'Hip-Hop'),
('03', 'ye', '03', 'Hip-Hop');

INSERT INTO song(song_id, song_name, album_id, artist_id)
VALUES('01', 'LOVE', '01', '01'),
('02', 'FEEL', '01', '01'),
('03', 'YAH.', '01', '01');

INSERT INTO playlist(playlist_id, user_id)
VALUES('01', '01'),
('02', '01'),
('03', '02');

INSERT INTO playlist_songs(playlist_songs_id, playlist_id, song_id)
VALUES('01', '01', '02'),
('02', '01', '01'),
('03', '01', '03');






