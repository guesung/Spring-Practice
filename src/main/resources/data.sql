-- MemberInfo 레코드 삽입
INSERT INTO member_info (phone_number, job)
VALUES ('123-456-7890', '개발자');
INSERT INTO member_info (phone_number, job)
VALUES ('234-567-8901', '디자이너');

-- Member 레코드 삽입
INSERT INTO member (member_id, username, email)
VALUES (1, 'user1', 'user1@example.com');
INSERT INTO member (member_id, username, email)
VALUES (2, 'user2', 'user2@example.com');
