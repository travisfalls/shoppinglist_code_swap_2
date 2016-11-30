INSERT INTO shopping_list.users (email, password, full_name, active, created_utc, modified_utc) VALUES ('test@test.com', 'test', 'Test Test', true, '2016-11-30 10:25:00', '2016-11-30 10:25:00');

INSERT INTO shopping_list.user_roles (user_id, role, created_utc, modified_utc) VALUES (1, 'ADMIN', '2016-11-30 10:25:00', '2016-11-30 10:25:00');

INSERT INTO shopping_list.shopping_list_groups (name, created_utc, modified_utc) VALUES ('Clothing', '2016-11-30 10:25:00', '2016-11-30 10:25:00');

INSERT INTO shopping_list.shopping_lists (user_id, name, color, shopping_list_group_id, created_utc, modified_utc) VALUES (1, 'Shopping List 1', '000000', 1, '2016-11-30 10:25:00', '2016-11-30 10:25:00');

INSERT INTO shopping_list.shopping_list_item_priorities (name, created_utc, modified_utc) VALUES ('It can wait', '2016-11-30 10:25:00', '2016-11-30 10:25:00');
INSERT INTO shopping_list.shopping_list_item_priorities (name, created_utc, modified_utc) VALUES ('Need it soon', '2016-11-30 10:25:00', '2016-11-30 10:25:00');
INSERT INTO shopping_list.shopping_list_item_priorities (name, created_utc, modified_utc) VALUES ('Grab it now', '2016-11-30 10:25:00', '2016-11-30 10:25:00');

INSERT INTO shopping_list.shopping_list_item_notes (body, created_utc, modified_utc) VALUES ('Note 1', '2016-11-30 10:25:00', '2016-11-30 10:25:00');
INSERT INTO shopping_list.shopping_list_item_notes (body, created_utc, modified_utc) VALUES ('Note 2', '2016-11-30 10:25:00', '2016-11-30 10:25:00');
INSERT INTO shopping_list.shopping_list_item_notes (body, created_utc, modified_utc) VALUES ('Note 3', '2016-11-30 10:25:00', '2016-11-30 10:25:00');

INSERT INTO shopping_list.shopping_list_items (shopping_list_id, name, shopping_list_item_priority_id, is_checked, shopping_list_item_note_id, created_utc, modified_utc) VALUES (1, 'Item 1', 1, false, 1, '2016-11-30 10:25:00', '2016-11-30 10:25:00');
INSERT INTO shopping_list.shopping_list_items (shopping_list_id, name, shopping_list_item_priority_id, is_checked, shopping_list_item_note_id, created_utc, modified_utc) VALUES (2, 'Item 2', 2, false, 2, '2016-11-30 10:25:00', '2016-11-30 10:25:00');
INSERT INTO shopping_list.shopping_list_items (shopping_list_id, name, shopping_list_item_priority_id, is_checked, shopping_list_item_note_id, created_utc, modified_utc) VALUES (3, 'Item 3', 3, false, 3, '2016-11-30 10:25:00', '2016-11-30 10:25:00');
