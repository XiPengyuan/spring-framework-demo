-- 插入示例数据
INSERT INTO tb_user (user_num, name, age, grade, email, residence) VALUES
    ('010001', 'Jone', 18, 2, 'test1@baomidou.com', 1),
    ('010002', 'Jack', 20, NULL, 'test2@baomidou.com', 1),
    ('010003', 'Tom', 28, NULL, 'test3@baomidou.com', 2),
    ('010004', 'Sandy', 21, NULL, 'test4@baomidou.com', 3),
    ('010005', 'Billie', 24, NULL, 'test5@baomidou.com', NULL);

INSERT INTO tb_address (province, city, district) VALUES
    ('江苏', '南京', '鼓楼区'),
    ('江苏', '苏州', '姑苏区'),
    ('上海', '上海', '浦东新区');
