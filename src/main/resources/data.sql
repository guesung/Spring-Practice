-- 멤버 (Member) 테이블에 샘플 데이터 삽입
INSERT INTO member (username, email)
VALUES ('Test1', 'Test1@gachon.ac.kr'),
       ('Test2', 'Test2@gachon.ac.kr');

-- 멤버 정보 (MemberInfo) 테이블에 샘플 데이터 삽입
INSERT INTO member_info (phone_number, job, member_id)
VALUES ('010-1234-5678', 'STUDENT', 1), -- 1번 멤버의 정보
       ('010-9876-5432', 'FREELANCER', 2); -- 2번 멤버의 정보
