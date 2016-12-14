CREATE SCHEMA IF NOT EXISTS shoppinglist;
USE shoppinglist ;
	
CREATE TABLE IF NOT EXISTS shoppinglist.users (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	email VARCHAR(128) NOT NULL,
	password VARCHAR(128) NOT NULL,
	full_name VARCHAR(128) NOT NULL,
	active TINYINT(1) NOT NULL DEFAULT 1,
	created_utc TIMESTAMP NOT NULL,
	modified_utc TIMESTAMP NOT NULL,
	role VARCHAR(128) NOT NULL DEFAULT 'USER',
	PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS shoppinglist.shopping_lists (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	user_id INT UNSIGNED NULL,
	name VARCHAR(128) NOT NULL,
	color VARCHAR(7) NOT NULL DEFAULT '#000000',
	created_utc TIMESTAMP NOT NULL,
	modified_utc TIMESTAMP NOT NULL,
	PRIMARY KEY (id));
	
CREATE TABLE IF NOT EXISTS shoppinglist.shopping_list_item_priorities (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(128) NOT NULL,
	created_utc TIMESTAMP NOT NULL,
	modified_utc TIMESTAMP NOT NULL,
	PRIMARY KEY (id));
	
CREATE TABLE IF NOT EXISTS shoppinglist.shopping_list_item_notes (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	body VARCHAR(500) NOT NULL,
	created_utc TIMESTAMP NOT NULL,
	modified_utc TIMESTAMP NOT NULL,
	PRIMARY KEY (id));
	
CREATE TABLE IF NOT EXISTS shoppinglist.shopping_list_items (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	shopping_list_id INT UNSIGNED NOT NULL,
	name VARCHAR(128) NOT NULL,
	shopping_list_item_priority_id INT UNSIGNED NOT NULL,
	is_checked TINYINT(1) NOT NULL DEFAULT 0,
	shopping_list_item_note_id INT UNSIGNED NULL,
	created_utc TIMESTAMP NOT NULL,
	modified_utc TIMESTAMP NOT NULL,
	PRIMARY KEY (id));
