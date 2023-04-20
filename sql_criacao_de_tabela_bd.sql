CREATE TABLE IF NOT EXISTS TAREFA(
	id serial PRIMARY KEY,
	texto text,
	prioridade int,
	dataCadastro date
);