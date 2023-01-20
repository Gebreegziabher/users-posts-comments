INSERT INTO users (id, name) VALUES (111, 'inan');
INSERT INTO users (id, name) VALUES (112, 'Gebreegziabher');
INSERT INTO users (id, name) VALUES (113, 'Abdurahman');

INSERT INTO post (id,title,content,user_id)
VALUES (111, 'title1', 'content1', 111);

INSERT INTO post (id,title,content,user_id)
VALUES (112, 'title2', 'content2', 111);

INSERT INTO post (id,title,content,user_id)
VALUES (113, 'title3', 'content3', 112);

INSERT INTO post (id,title,content,user_id)
VALUES (114, 'title4', 'content4', 113);

INSERT INTO comment (id,name,post_id)
VALUES (1, 'comment1', 111);
INSERT INTO comment (id,name,post_id)
VALUES (2, 'comment2', 111);