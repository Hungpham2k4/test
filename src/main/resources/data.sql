INSERT INTO post(id, title, description, content, created_at, updated_at)
VALUES          (1 , "Spring Framework", "Learn Spring Framework", "Learn with Mentor Khoa", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (2 , "Spring Framework", "Learn Spring Framework", "Learn with Mentor Long", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                (3 , "Spring Framework", "Learn Spring Framework", "Learn with Mentor Huy", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO user (name, username, email, password, role, created_at, updated_at)
VALUES
    ('Nguyen Van A', 'admin', 'admin01@example.com', '$2a$12$4Kc7mwIhn8EnWJAmM7ogCOzy45umYu9gOzUmHENL9gyNaIRKp8H7q', 'ADMIN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Le Thi B', 'employee01', 'employee01@example.com', 'employee123', 'EMPLOYEE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Tran Van C', 'manager01', 'manager01@example.com', 'manager123', 'MANAGER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Pham Thi D', 'employee02', 'employee02@example.com', 'employee456', 'EMPLOYEE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Do Van E', 'admin02', 'admin02@example.com', 'admin456', 'ADMIN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
