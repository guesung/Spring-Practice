-- insert into member(id, username, email)
-- values (1, '박규성', 'gueit214@naver.com');
--
-- insert into member(id, username, email)
-- values (2, '정현진', 'hyunjin1105@naver.com');
--
-- insert into member(id, username, email)
-- values (3, '강규혁', 'guehyeok@naver.com');


-- Member 테이블에 데이터 삽입
INSERT INTO member (id, username, email)
VALUES (1, 'username1', 'email1@example.com');
INSERT INTO member (id, username, email)
VALUES (2, 'username2', 'email2@example.com');

-- MemberInfo 테이블에 데이터 삽입
-- MemberInfo의 id는 Member 테이블의 id와 동일해야 함
INSERT INTO member_info (member_info_id, phone_number, job)
VALUES (1, '010-1234-5678', 'DEVELOPER');
INSERT INTO member_info (member_info_id, phone_number, job)
VALUES (2, '010-2345-6789', 'TEACHER');
