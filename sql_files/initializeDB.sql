CREATE DATABASE music_manager;


use  music_manager;

CREATE TABLE song {
	id INT NOT NULL,
	name VARCHAR(100) NOT NULL,
	PRIMARY KEY(id)
};

CREATE TABLE playlist {
	id INT NOT NULL,
	song_id INT,
	PRIMARY KEY(id),
	FOREIGN KEY(song_id) REFERENCES song(id) ON DELETE CASCADE
};

CREATE TABLE song_info{
	id INT AUTO_INCREMENT,
	song_id INT,
	artist_id VARCHAR(100) NOT NULL,
	album_id VARCHAR(100) NOT NULL,
	genre _id VARCHAR(100)
	PRIMARY KEY(id),
	FOREIGN KEY(song_id) REFERENCES song(id)
	FOREIGN KEY(artist_id) REFERENCES  artist_info(artist_id),
	FOREIGN KEY(album_id) REFERENCES album(id),
	FOREIGN KEY(genre_id) REFERENCES genre(id)
};

CREATE TABLE album {
	id INT AUTO_INCREMENT NOT NULL,
	name VARCHAR(200),
	release_date DATE,
	genre INT,
	PRIMARY KEY(id),
};

CREATE TABLE genre {
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL CHECK (name IN ("Hip-Hop", "Rock", "R&B", "Country", "Pop", "K-Pop", "Classical", "Soul", "Dance/Electronic", "Jazz", "Punk", "Desi", "Metal")),
	PRIMARY KEY(id)
};

CREATE TABLE artist {
	id INT NOT NULL AUTO_INCREMENT,
	artist_name VARCHAR(200),
	keyword VARCHAR(200) NOT NULL,
	PRIMARY KEY(id)	
};

CREATE TABLE artist_info {
	artist_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(200),
	email VARCHAR(200)
	PRIMARY KEY(artist_id)
};

CREATE TABLE album_s {
	id INT NOT NULL AUTO_INCREMENT,
	keyword VARCHAR(200),
	album_id INT NOT NULL
};

CREATE TABLE song_s {
	id INT NOT NULL AUTO_INCREMENT,
	song_id INT NOT NULL,
	keyword VARCHAR(200) NOT NULL,
	PRIMARY KEY(id)
};

CREATE TABLE search {
	id INT NOT NULL AUTO_INCREMENT,
	keyword VARCHAR(200) NOT NULL,
	playlist_id INT NOT NULL,
	PRIMARY KEY (id)
};

CREATE TABLE keyword {
	id INT NOT NULL AUTO_INCREMENT,
	word VARCHAR(200) NOT NULL,
	PRIMARY KEY(id)
};

CREATE TABLE user_playlist {
	id INT NOT NULL AUTO_INCREMENT,
	user_id INT NOT NULL,
	playlist INT,
	PRIMARY KEY(id),
	FOREIGN KEY(playlist) REFERENCES playlist(id),
	FOREIGN KEY(user_id) REFERENCES user(id)
};

CREATE TABLE user {
	id INT NOT NULL AUTO_INCREMENT, 
	name VARCHAR(200),
	email VARCHAR(200),
	sex VARCHAR(200),
	`password` VARCHAR(100) NOT NULL,
	PRIMARY KEY(id),
	
};

CREATE TABLE follow {
	id INT NOT NULL AUTO_INCREMENT,
	user_id INT,
	follower_id INT,
	PRIMARY KEY(id),
	FOREIGN KEY(user_id) REFERENCES user(id),
	FOREIGN KEY(follower_id) REFERENCES user(id)
};

