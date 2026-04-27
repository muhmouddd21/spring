CREATE SEQUENCE IF NOT EXISTS tasks_id_seq;
ALTER TABLE tasks ALTER COLUMN id SET DEFAULT nextval('tasks_id_seq');
SELECT setval('tasks_id_seq', COALESCE((SELECT MAX(id) FROM tasks), 0) + 1, false);
ALTER SEQUENCE tasks_id_seq OWNED BY tasks.id;
